package cn.edu.nwafu.erosion.mapper;

import cn.edu.nwafu.erosion.model.MonitoringData;
import cn.edu.nwafu.erosion.model.MonitoringDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonitoringDataMapper {
    long countByExample(MonitoringDataExample example);

    int deleteByExample(MonitoringDataExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MonitoringData row);

    int insertSelective(MonitoringData row);

    List<MonitoringData> selectByExample(MonitoringDataExample example);

    MonitoringData selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") MonitoringData row, @Param("example") MonitoringDataExample example);

    int updateByExample(@Param("row") MonitoringData row, @Param("example") MonitoringDataExample example);

    int updateByPrimaryKeySelective(MonitoringData row);

    int updateByPrimaryKey(MonitoringData row);
}