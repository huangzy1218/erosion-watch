package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.common.service.RedisService;
import cn.edu.nwafu.common.util.ExcelUtil;
import cn.edu.nwafu.erosion.portal.domain.ExcelDocument;
import cn.edu.nwafu.erosion.portal.domain.dto.ExcelUpdateDto;
import cn.edu.nwafu.erosion.portal.domain.dto.MinioUploadDto;
import cn.edu.nwafu.erosion.portal.domain.entity.ExcelFile;
import cn.edu.nwafu.erosion.portal.domain.vo.ExcelDataVo;
import cn.edu.nwafu.erosion.portal.domain.vo.ExcelFileVo;
import cn.edu.nwafu.erosion.portal.enums.Bucket;
import cn.edu.nwafu.erosion.portal.mapper.MyDataMapper;
import cn.edu.nwafu.erosion.portal.repository.ExcelDocumentRepository;
import cn.edu.nwafu.erosion.portal.service.MinioService;
import cn.edu.nwafu.erosion.portal.service.MyDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

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
    @Autowired
    private ExcelDocumentRepository repository;
    @Autowired
    private TaskExecutor taskExecutor;

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
        /*try {
            File cvsFile = ExcelUtil.convertMultipartFileToCsv(file);
            file.transferTo(cvsFile);
        } catch (IOException e) {
            log.info("压缩excel文件失败");
        }*/
        MinioUploadDto uploadDto = minioService.upload(file, Bucket.data);
        if (uploadDto == null) {
            return false;
        }
        deleteCache();
        CompletableFuture<String> future = save2MongoAsync(file, 1000);

        ExcelFile excelFile = ExcelFile.builder()
                .fileName(file.getOriginalFilename())
                .urlPath(uploadDto.getUrl())
                .build();
        // 异步任务执行完成后的回调函数
        future.thenAccept(excelFile::setMongoId).exceptionally(ex -> {
            // 异步任务执行失败的处理逻辑
            return null;
        });
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

    @Override
    public int rename(Long id, String fileName) {
        int count = myDataMapper.updateFileName(id, fileName);
        deleteCache();
        updateCache();
        return count;
    }

    @Override
    public ExcelDataVo detail(Long fid) {
        ExcelFile file = myDataMapper.getById(fid);
        log.info("excelFile: {}", file);
        ExcelDocument document = repository.findById(file.getMongoId()).orElse(null);
        if (document == null) {
            log.info("未找到指定的Excel文档");
            return null;
        }
        ExcelDataVo dataVo = new ExcelDataVo();
        dataVo.setColHeaders(document.getHeaders());
        dataVo.setData(document.getData());
        return dataVo;
    }

    @Override
    public void updateExcelData(ExcelUpdateDto excelUpdateDto) {
        try {
            ExcelFile file = myDataMapper.getById(Long.parseLong(excelUpdateDto.getId()));
            log.info("excelFile: {}", file);
            // 查找指定的Excel文档
            ExcelDocument document = repository.findById(file.getMongoId()).orElse(null);
            if (document == null) {
                log.info("未找到指定的Excel文档");
                return;
            }

            // 获取文档中的数据
            List<List<String>> data = document.getData();
            // 更新特定行的特定数据
            List<String> updateDataRow = data.get(excelUpdateDto.getRowId() - 1);
            updateDataRow.set(excelUpdateDto.getColumnId(), excelUpdateDto.getNewVal());

            // 保存更新后的文档
            repository.save(document);
            log.info("Excel数据更新成功");
        } catch (Exception e) {
            log.error("更新Excel数据时发生错误", e);
        }
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

    @SuppressWarnings("unchecked")
    private List<ExcelFileVo> queryWithCache() {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_DATA;
        return (List<ExcelFileVo>) redisService.get(key);
    }

    @Transactional
    public String save2Mongo(ExcelDocument document) {
        return repository.insert(document).getId();
    }

    public CompletableFuture<String> save2MongoAsync(MultipartFile file, int batchSize) {
        CompletableFuture<String> future = new CompletableFuture<>();
        taskExecutor.execute(() -> {
            try {
                String mongoId = null;
                // 读取Excel文件
                ExcelUtil.ExcelReadResult result = ExcelUtil.readExcel(file);
                // 创建ExcelDocument对象
                // 获取Excel行数
                int rowCount = result.getRows().size();
                int totalBatches = (int) Math.ceil((double) rowCount / batchSize);
                for (int i = 0; i < totalBatches; i++) {
                    // 计算当前批次的起始索引和结束索引
                    int startIndex = i * batchSize;
                    int endIndex = Math.min((i + 1) * batchSize, rowCount);
                    List<List<String>> batchRows = result.getRows().subList(startIndex, endIndex);
                    ExcelDocument document = new ExcelDocument();
                    document.setExcelName(file.getOriginalFilename());
                    document.setHeaders(result.getHeaders());
                    document.setData(batchRows);
                    mongoId = save2Mongo(document);
                }
                // 将保存操作提交给异步任务处理
                future.complete(mongoId);
            } catch (IOException e) {
                log.error("读取excel文件失败", e);
                future.completeExceptionally(e);
            }
        });
        return future;
    }

}
    