package cn.edu.nwafu.erosion.mapper;

import cn.edu.nwafu.erosion.model.TerrainLandform;
import cn.edu.nwafu.erosion.model.TerrainLandformExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TerrainLandformMapper {
    long countByExample(TerrainLandformExample example);

    int deleteByExample(TerrainLandformExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TerrainLandform row);

    int insertSelective(TerrainLandform row);

    List<TerrainLandform> selectByExample(TerrainLandformExample example);

    TerrainLandform selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") TerrainLandform row, @Param("example") TerrainLandformExample example);

    int updateByExample(@Param("row") TerrainLandform row, @Param("example") TerrainLandformExample example);

    int updateByPrimaryKeySelective(TerrainLandform row);

    int updateByPrimaryKey(TerrainLandform row);
}