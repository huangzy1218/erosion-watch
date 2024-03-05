package cn.edu.nwafu.erosion.portal.service;

import cn.edu.nwafu.erosion.model.LandUseChangeHistory;
import cn.edu.nwafu.erosion.portal.domain.dto.LandUseChangeHistoryDto;
import cn.edu.nwafu.erosion.portal.domain.dto.LandUseChangeHistorySearchDto;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
public interface LandUseChangeHistoryService {
    int add(LandUseChangeHistoryDto landUseChangeHistoryDto);

    LandUseChangeHistory getById(Long id);

    int update(Long id, LandUseChangeHistoryDto landUseChangeHistoryDto);

    int delete(Long id);

    List<LandUseChangeHistory> listAll();

    List<LandUseChangeHistory> search(LandUseChangeHistorySearchDto landUseChangeHistorySearchDto);
}
