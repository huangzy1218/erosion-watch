package cn.edu.nwafu.erosion.mapper;

import cn.edu.nwafu.erosion.model.LandManagementPlans;
import cn.edu.nwafu.erosion.model.LandManagementPlansExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LandManagementPlansMapper {
    long countByExample(LandManagementPlansExample example);

    int deleteByExample(LandManagementPlansExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LandManagementPlans row);

    int insertSelective(LandManagementPlans row);

    List<LandManagementPlans> selectByExampleWithBLOBs(LandManagementPlansExample example);

    List<LandManagementPlans> selectByExample(LandManagementPlansExample example);

    LandManagementPlans selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") LandManagementPlans row, @Param("example") LandManagementPlansExample example);

    int updateByExampleWithBLOBs(@Param("row") LandManagementPlans row, @Param("example") LandManagementPlansExample example);

    int updateByExample(@Param("row") LandManagementPlans row, @Param("example") LandManagementPlansExample example);

    int updateByPrimaryKeySelective(LandManagementPlans row);

    int updateByPrimaryKeyWithBLOBs(LandManagementPlans row);

    int updateByPrimaryKey(LandManagementPlans row);
}