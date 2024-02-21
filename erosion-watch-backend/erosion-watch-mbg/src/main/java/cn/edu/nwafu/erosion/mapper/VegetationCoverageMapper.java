package cn.edu.nwafu.erosion.mapper;

import cn.edu.nwafu.erosion.model.VegetationCoverage;
import cn.edu.nwafu.erosion.model.VegetationCoverageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VegetationCoverageMapper {
    long countByExample(VegetationCoverageExample example);

    int deleteByExample(VegetationCoverageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VegetationCoverage row);

    int insertSelective(VegetationCoverage row);

    List<VegetationCoverage> selectByExampleWithBLOBs(VegetationCoverageExample example);

    List<VegetationCoverage> selectByExample(VegetationCoverageExample example);

    VegetationCoverage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") VegetationCoverage row, @Param("example") VegetationCoverageExample example);

    int updateByExampleWithBLOBs(@Param("row") VegetationCoverage row, @Param("example") VegetationCoverageExample example);

    int updateByExample(@Param("row") VegetationCoverage row, @Param("example") VegetationCoverageExample example);

    int updateByPrimaryKeySelective(VegetationCoverage row);

    int updateByPrimaryKeyWithBLOBs(VegetationCoverage row);

    int updateByPrimaryKey(VegetationCoverage row);
}