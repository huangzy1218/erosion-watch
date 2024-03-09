package cn.edu.nwafu.erosion.portal.mapper;

import cn.edu.nwafu.erosion.portal.annotation.AutoFill;
import cn.edu.nwafu.erosion.portal.domain.entity.ExcelFile;
import cn.edu.nwafu.erosion.portal.domain.vo.ExcelFileVo;
import cn.edu.nwafu.erosion.portal.enums.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
public interface MyDataMapper {
    @Select("select fid, file_name, author, create_time from excel_file;")
    List<ExcelFileVo> listAll();

    @AutoFill(OperationType.INSERT)
    void insert(ExcelFile excelFile);

    @Delete("delete from excel_file where fid = #{id}")
    int delete(Long id);

    @Select("select * from excel_file where fid = #{id}")
    ExcelFile getById(Long id);
}
