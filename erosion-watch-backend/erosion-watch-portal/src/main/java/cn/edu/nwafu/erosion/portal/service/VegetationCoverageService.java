package cn.edu.nwafu.erosion.portal.service;

import cn.edu.nwafu.erosion.model.VegetationCoverage;
import cn.edu.nwafu.erosion.portal.domain.dto.VegetationCoverageDto;
import cn.edu.nwafu.erosion.portal.domain.dto.VegetationCoverageSearchDto;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
public interface VegetationCoverageService {
    int add(VegetationCoverageDto vegetationCoverageDto);

    int update(Long id, VegetationCoverageDto vegetationCoverageDto);

    int delete(Long id);

    List<VegetationCoverage> listAll();

    List<VegetationCoverage> search(VegetationCoverageSearchDto vegetationCoverageSearchDto);

    VegetationCoverage getById(Long id);
}
