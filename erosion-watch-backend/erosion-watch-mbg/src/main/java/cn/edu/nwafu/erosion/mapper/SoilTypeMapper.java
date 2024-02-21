package cn.edu.nwafu.erosion.mapper;

import cn.edu.nwafu.erosion.model.SoilType;
import cn.edu.nwafu.erosion.model.SoilTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SoilTypeMapper {
    long countByExample(SoilTypeExample example);

    int deleteByExample(SoilTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SoilType row);

    int insertSelective(SoilType row);

    List<SoilType> selectByExampleWithBLOBs(SoilTypeExample example);

    List<SoilType> selectByExample(SoilTypeExample example);

    SoilType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") SoilType row, @Param("example") SoilTypeExample example);

    int updateByExampleWithBLOBs(@Param("row") SoilType row, @Param("example") SoilTypeExample example);

    int updateByExample(@Param("row") SoilType row, @Param("example") SoilTypeExample example);

    int updateByPrimaryKeySelective(SoilType row);

    int updateByPrimaryKeyWithBLOBs(SoilType row);

    int updateByPrimaryKey(SoilType row);
}