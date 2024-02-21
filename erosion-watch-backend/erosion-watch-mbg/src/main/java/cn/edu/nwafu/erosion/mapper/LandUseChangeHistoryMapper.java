package cn.edu.nwafu.erosion.mapper;

import cn.edu.nwafu.erosion.model.LandUseChangeHistory;
import cn.edu.nwafu.erosion.model.LandUseChangeHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LandUseChangeHistoryMapper {
    long countByExample(LandUseChangeHistoryExample example);

    int deleteByExample(LandUseChangeHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LandUseChangeHistory row);

    int insertSelective(LandUseChangeHistory row);

    List<LandUseChangeHistory> selectByExampleWithBLOBs(LandUseChangeHistoryExample example);

    List<LandUseChangeHistory> selectByExample(LandUseChangeHistoryExample example);

    LandUseChangeHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") LandUseChangeHistory row, @Param("example") LandUseChangeHistoryExample example);

    int updateByExampleWithBLOBs(@Param("row") LandUseChangeHistory row, @Param("example") LandUseChangeHistoryExample example);

    int updateByExample(@Param("row") LandUseChangeHistory row, @Param("example") LandUseChangeHistoryExample example);

    int updateByPrimaryKeySelective(LandUseChangeHistory row);

    int updateByPrimaryKeyWithBLOBs(LandUseChangeHistory row);

    int updateByPrimaryKey(LandUseChangeHistory row);
}