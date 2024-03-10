package cn.edu.nwafu.erosion.portal.service;

import cn.edu.nwafu.erosion.portal.domain.entity.ExcelFile;
import cn.edu.nwafu.erosion.portal.domain.vo.ExcelDataVo;
import cn.edu.nwafu.erosion.portal.domain.vo.ExcelFileVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
public interface MyDataService {
    List<ExcelFileVo> listAll();

    boolean upload(MultipartFile file);

    int delete(Long id);

    ExcelFile getById(Long id);

    int rename(Long id, String fileName);

    ExcelDataVo detail();
}
