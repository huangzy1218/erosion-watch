package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.erosion.mapper.MonitoringDataMapper;
import cn.edu.nwafu.erosion.model.MonitoringData;
import cn.edu.nwafu.erosion.model.MonitoringDataExample;
import cn.edu.nwafu.erosion.portal.domain.dto.MonitoringDataDto;
import cn.edu.nwafu.erosion.portal.domain.dto.MonitoringDataSearchDto;
import cn.edu.nwafu.erosion.portal.service.MonitoringDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
@Slf4j
@Service
public class MonitoringDataServiceImpl implements MonitoringDataService {
    @Autowired
    private MonitoringDataMapper monitoringDataMapper;

    @Override
    public int add(MonitoringDataDto monitoringDataDto) {
        MonitoringData monitoringData = MonitoringData.builder()
                .areaId(monitoringDataDto.getAreaId())
                .monitoringDate(monitoringDataDto.getMonitoringDate())
                .soilErosionRate(monitoringDataDto.getSoilErosionRate())
                .vegetationCoverageRate(monitoringDataDto.getVegetationCoverageRate())
                .rainfallAmount(monitoringDataDto.getRainfallAmount())
                .build();
        return monitoringDataMapper.insertSelective(monitoringData);
    }

    @Override
    public int update(Long id, MonitoringDataDto monitoringDataDto) {
        MonitoringData monitoringData = MonitoringData.builder()
                .id(id)
                .areaId(monitoringDataDto.getAreaId())
                .monitoringDate(monitoringDataDto.getMonitoringDate())
                .soilErosionRate(monitoringDataDto.getSoilErosionRate())
                .vegetationCoverageRate(monitoringDataDto.getVegetationCoverageRate())
                .rainfallAmount(monitoringDataDto.getRainfallAmount())
                .build();
        log.info("MonitoringData: {}", monitoringData);
        return monitoringDataMapper.updateByPrimaryKeySelective(monitoringData);
    }

    @Override
    public int delete(Long id) {
        return monitoringDataMapper.deleteByPrimaryKey(id);
    }

    @Override
    public MonitoringData getById(Long id) {
        return monitoringDataMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<MonitoringData> listAll() {
        return monitoringDataMapper.selectByExample(new MonitoringDataExample());
    }

    @Override
    public List<MonitoringData> search(MonitoringDataSearchDto monitoringDataSearchDto) {
        MonitoringDataExample example = new MonitoringDataExample();
        MonitoringDataExample.Criteria criteria = example.createCriteria();

        if (monitoringDataSearchDto.getAreaId() != null) {
            criteria.andAreaIdEqualTo(monitoringDataSearchDto.getAreaId());
        }
        if (monitoringDataSearchDto.getStartDate() != null && monitoringDataSearchDto.getEndDate() != null) {
            criteria.andMonitoringDateBetween(monitoringDataSearchDto.getStartDate(), monitoringDataSearchDto.getEndDate());
        }
        if (monitoringDataSearchDto.getMinSoilErosionRate() != null && monitoringDataSearchDto.getMaxSoilErosionRate() != null) {
            criteria.andSoilErosionRateBetween(monitoringDataSearchDto.getMinSoilErosionRate(), monitoringDataSearchDto.getMaxSoilErosionRate());
        }
        if (monitoringDataSearchDto.getMinVegetationCoverageRate() != null && monitoringDataSearchDto.getMaxVegetationCoverageRate() != null) {
            criteria.andVegetationCoverageRateBetween(monitoringDataSearchDto.getMinVegetationCoverageRate(), monitoringDataSearchDto.getMaxVegetationCoverageRate());
        }
        if (monitoringDataSearchDto.getMinRainfallAmount() != null && monitoringDataSearchDto.getMaxRainfallAmount() != null) {
            criteria.andRainfallAmountBetween(monitoringDataSearchDto.getMinRainfallAmount(), monitoringDataSearchDto.getMaxRainfallAmount());
        }

        return monitoringDataMapper.selectByExample(example);
    }
}
    