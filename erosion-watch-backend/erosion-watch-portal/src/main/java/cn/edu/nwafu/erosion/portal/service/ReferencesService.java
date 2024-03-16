package cn.edu.nwafu.erosion.portal.service;

import cn.edu.nwafu.erosion.portal.domain.dto.ReferencesDto;
import cn.edu.nwafu.erosion.portal.domain.vo.ReferencesListVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
public interface ReferencesService {
    boolean add(MultipartFile file, ReferencesDto referencesDto);

    ReferencesListVo listAll();

    List<String> search(String keyword);
}
