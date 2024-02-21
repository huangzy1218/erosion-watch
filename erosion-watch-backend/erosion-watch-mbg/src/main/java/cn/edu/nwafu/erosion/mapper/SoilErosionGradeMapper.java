package cn.edu.nwafu.erosion.mapper;

import cn.edu.nwafu.erosion.model.SoilErosionGrade;
import cn.edu.nwafu.erosion.model.SoilErosionGradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SoilErosionGradeMapper {
    long countByExample(SoilErosionGradeExample example);

    int deleteByExample(SoilErosionGradeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SoilErosionGrade row);

    int insertSelective(SoilErosionGrade row);

    List<SoilErosionGrade> selectByExampleWithBLOBs(SoilErosionGradeExample example);

    List<SoilErosionGrade> selectByExample(SoilErosionGradeExample example);

    SoilErosionGrade selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") SoilErosionGrade row, @Param("example") SoilErosionGradeExample example);

    int updateByExampleWithBLOBs(@Param("row") SoilErosionGrade row, @Param("example") SoilErosionGradeExample example);

    int updateByExample(@Param("row") SoilErosionGrade row, @Param("example") SoilErosionGradeExample example);

    int updateByPrimaryKeySelective(SoilErosionGrade row);

    int updateByPrimaryKeyWithBLOBs(SoilErosionGrade row);

    int updateByPrimaryKey(SoilErosionGrade row);
}