package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.common.service.RedisService;
import cn.edu.nwafu.erosion.portal.domain.dto.MinioUploadDto;
import cn.edu.nwafu.erosion.portal.domain.entity.ExcelFile;
import cn.edu.nwafu.erosion.portal.domain.vo.ExcelFileVo;
import cn.edu.nwafu.erosion.portal.enums.Bucket;
import cn.edu.nwafu.erosion.portal.mapper.MyDataMapper;
import cn.edu.nwafu.erosion.portal.service.MinioService;
import cn.edu.nwafu.erosion.portal.service.MyDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
@Slf4j
@Service
public class MyDataServiceImpl implements MyDataService {
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.key.data}")
    private String REDIS_KEY_DATA;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Autowired
    private RedisService redisService;
    @Autowired
    private MinioService minioService;
    @Autowired
    private MyDataMapper myDataMapper;

    @Override
    public List<ExcelFileVo> listAll() {
        List<ExcelFileVo> excelFileVos = queryWithCache();
        if (excelFileVos != null && excelFileVos.size() > 0) {
            return excelFileVos;
        }
        excelFileVos = queryWithDb();
        return excelFileVos;
    }

    @Override
    public boolean upload(MultipartFile file) {
        MinioUploadDto uploadDto = minioService.upload(file, Bucket.data);
        if (uploadDto == null) {
            return false;
        }
        deleteCache();
        ExcelFile excelFile = ExcelFile.builder()
                .fileName(file.getOriginalFilename())
                .build();
        log.info("excelFile: {}", excelFile);
        myDataMapper.insert(excelFile);
        updateCache();
        return true;
    }

    @Override
    public int delete(Long id) {
        ExcelFile oldData = myDataMapper.getById(id);
        if (oldData != null) {
            String fileName = oldData.getFileName();
            minioService.delete(fileName);
        }
        int count = myDataMapper.delete(id);
        if (count != 0) {
            deleteCache();
            updateCache();
        }
        return count;
    }

    @Override
    public ExcelFile getById(Long id) {
        return myDataMapper.getById(id);
    }

    private List<ExcelFileVo> queryWithDb() {
        return myDataMapper.listAll();
    }

    private void deleteCache() {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_DATA;
        redisService.del(key);
    }

    private void updateCache() {
        List<ExcelFileVo> excelFileVos = queryWithDb();
        String key = REDIS_DATABASE + ":" + REDIS_KEY_DATA;
        redisService.set(key, excelFileVos, REDIS_EXPIRE);
    }

    private List<ExcelFileVo> queryWithCache() {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_DATA;
        return (List<ExcelFileVo>) redisService.get(key);
    }
}
    