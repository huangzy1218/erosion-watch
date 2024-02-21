package cn.edu.nwafu.erosion.mapper;

import cn.edu.nwafu.erosion.model.Member;
import cn.edu.nwafu.erosion.model.MemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
    long countByExample(MemberExample example);

    int deleteByExample(MemberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Member row);

    int insertSelective(Member row);

    List<Member> selectByExampleWithBLOBs(MemberExample example);

    List<Member> selectByExample(MemberExample example);

    Member selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") Member row, @Param("example") MemberExample example);

    int updateByExampleWithBLOBs(@Param("row") Member row, @Param("example") MemberExample example);

    int updateByExample(@Param("row") Member row, @Param("example") MemberExample example);

    int updateByPrimaryKeySelective(Member row);

    int updateByPrimaryKeyWithBLOBs(Member row);

    int updateByPrimaryKey(Member row);
}