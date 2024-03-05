package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.erosion.mapper.AreaInfoMapper;
import cn.edu.nwafu.erosion.model.AreaInfo;
import cn.edu.nwafu.erosion.model.AreaInfoExample;
import cn.edu.nwafu.erosion.portal.service.AreaInfoService;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * {@link cn.edu.nwafu.erosion.portal.service.AreaInfoService} 实现类。
 *
 * @author Huang Z.Y.
 */
@Slf4j
@Service
public class AreaInfoServiceImpl implements AreaInfoService {
    @Autowired
    private AreaInfoMapper areaInfoMapper;

    @Override
    public int add(String areaName, String administrativeCode, BigDecimal latitude,
                   BigDecimal longitude, BigDecimal area, Integer population, String climateType,
                   String terrainFeature, String landformFeature, String landUse) {
        AreaInfo areaInfo = AreaInfo
                .builder()
                .areaName(areaName)
                .administrativeCode(administrativeCode)
                .latitude(latitude)
                .longitude(longitude)
                .area(area)
                .population(population)
                .climateType(climateType)
                .terrainFeature(terrainFeature)
                .landformFeature(landformFeature)
                .landUse(landUse).build();
        return areaInfoMapper.insertSelective(areaInfo);
    }

    @Override
    public int update(Long id, String areaName, String administrativeCode, BigDecimal latitude,
                      BigDecimal longitude, BigDecimal area, Integer population, String climateType,
                      String terrainFeature, String landformFeature, String landUse) {
        AreaInfo areaInfo = AreaInfo
                .builder()
                .id(id)
                .areaName(areaName)
                .administrativeCode(administrativeCode)
                .latitude(latitude)
                .longitude(longitude)
                .area(area)
                .population(population)
                .climateType(climateType)
                .terrainFeature(terrainFeature)
                .landformFeature(landformFeature)
                .landUse(landUse).build();
        log.info("areaInfo:{}", areaInfo);
        return areaInfoMapper.updateByPrimaryKeySelective(areaInfo);
    }

    @Override
    public int delete(Long id) {
        return areaInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public AreaInfo getById(Long id) {
        return areaInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AreaInfo> listAll() {
        return areaInfoMapper.selectByExample(new AreaInfoExample());
    }

    @Override
    public List<AreaInfo> search(String areaName, String administrativeCode,
                                 BigDecimal minLatitude, BigDecimal maxLatitude,
                                 BigDecimal minLongitude, BigDecimal maxLongitude) {
        AreaInfoExample example = new AreaInfoExample();
        AreaInfoExample.Criteria criteria = example.createCriteria();

        if (StrUtil.isNotEmpty(areaName)) {
            criteria.andAreaNameLike(areaName);
        }
        if (StrUtil.isNotEmpty(administrativeCode)) {
            criteria.andAdministrativeCodeEqualTo(administrativeCode);
        }
        if (minLatitude != null && maxLatitude != null) {
            criteria.andLatitudeBetween(minLatitude, maxLatitude);
        } else if (minLatitude != null) {
            criteria.andLatitudeGreaterThan(minLatitude);
        } else if (maxLatitude != null) {
            criteria.andLatitudeLessThan(maxLatitude);
        }
        if (minLongitude != null && maxLongitude != null) {
            criteria.andLongitudeBetween(minLongitude, maxLongitude);
        } else if (minLongitude != null) {
            criteria.andLongitudeGreaterThan(minLongitude);
        } else if (maxLongitude != null) {
            criteria.andLongitudeLessThan(maxLongitude);
        }

        return areaInfoMapper.selectByExample(example);
    }
}
    