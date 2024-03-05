package cn.edu.nwafu.erosion.portal.service;

import cn.edu.nwafu.erosion.model.MonitoringData;
import cn.edu.nwafu.erosion.portal.domain.dto.MonitoringDataDto;
import cn.edu.nwafu.erosion.portal.domain.dto.MonitoringDataSearchDto;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
public interface MonitoringDataService {
    int add(MonitoringDataDto monitoringDataDto);

    MonitoringData getById(Long id);

    int update(Long id, MonitoringDataDto monitoringDataDto);

    int delete(Long id);

    List<MonitoringData> listAll();

    List<MonitoringData> search(MonitoringDataSearchDto monitoringDataSearchDto);
}
