package cn.edu.nwafu.erosion.portal.service;

import cn.edu.nwafu.erosion.model.SoilType;
import cn.edu.nwafu.erosion.portal.domain.dto.SoilTypeDto;
import cn.edu.nwafu.erosion.portal.domain.dto.SoilTypeSearchDto;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
public interface SoilTypeService {
    int add(SoilTypeDto soilTypeDto);

    SoilType getById(Long id);

    int update(Long id, SoilTypeDto soilTypeDto);

    int delete(Long id);

    List<SoilType> listAll();

    List<SoilType> search(SoilTypeSearchDto soilTypeSearchDto);
}
