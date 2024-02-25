package cn.edu.nwafu.erosion.portal.service;

import cn.edu.nwafu.erosion.model.AreaInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Huang Z.Y.
 */
public interface AreaInfoService {
    int add(String areaName, String administrativeCode, BigDecimal latitude, BigDecimal longitude, BigDecimal area, Integer population, String climateType, String terrainFeature, String landformFeature, String landUse);

    int update(Long id, String areaName, String administrativeCode, BigDecimal latitude, BigDecimal longitude, BigDecimal area, Integer population, String climateType, String terrainFeature, String landformFeature, String landUse);

    int delete(Long id);

    AreaInfo getById(Long id);

    List<AreaInfo> listAll();

    List<AreaInfo> search(String areaName, String administrativeCode, BigDecimal minLatitude, BigDecimal maxLatitude, BigDecimal minLongitude, BigDecimal maxLongitude);
}
