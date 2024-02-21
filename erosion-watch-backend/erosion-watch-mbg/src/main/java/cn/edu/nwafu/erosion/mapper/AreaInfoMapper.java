package cn.edu.nwafu.erosion.mapper;

import cn.edu.nwafu.erosion.model.AreaInfo;
import cn.edu.nwafu.erosion.model.AreaInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AreaInfoMapper {
    long countByExample(AreaInfoExample example);

    int deleteByExample(AreaInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AreaInfo row);

    int insertSelective(AreaInfo row);

    List<AreaInfo> selectByExample(AreaInfoExample example);

    AreaInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") AreaInfo row, @Param("example") AreaInfoExample example);

    int updateByExample(@Param("row") AreaInfo row, @Param("example") AreaInfoExample example);

    int updateByPrimaryKeySelective(AreaInfo row);

    int updateByPrimaryKey(AreaInfo row);
}