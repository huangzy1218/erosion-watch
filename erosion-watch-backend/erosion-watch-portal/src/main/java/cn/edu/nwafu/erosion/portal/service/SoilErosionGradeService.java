package cn.edu.nwafu.erosion.portal.service;

import cn.edu.nwafu.erosion.model.SoilErosionGrade;
import cn.edu.nwafu.erosion.portal.domain.dto.SoilErosionGradeDto;
import cn.edu.nwafu.erosion.portal.domain.dto.SoilErosionGradeSearchDto;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
public interface SoilErosionGradeService {
    int add(SoilErosionGradeDto soilErosionGradeDto);

    SoilErosionGrade getById(Long id);

    int update(Long id, SoilErosionGradeDto soilErosionGradeDto);

    int delete(Long id);

    List<SoilErosionGrade> listAll();

    List<SoilErosionGrade> search(SoilErosionGradeSearchDto soilErosionGradeSearchDto);
}
