package cn.edu.nwafu.erosion.portal.service;

import cn.edu.nwafu.erosion.model.LandManagementPlans;
import cn.edu.nwafu.erosion.portal.domain.dto.LandManagementPlansDto;
import cn.edu.nwafu.erosion.portal.domain.dto.LandManagementPlansSearchDto;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
public interface LandManagementPlansService {
    int add(LandManagementPlansDto landManagementPlansDto);

    LandManagementPlans getById(Long id);

    int update(Long id, LandManagementPlansDto landManagementPlansDto);

    int delete(Long id);

    List<LandManagementPlans> listAll();

    List<LandManagementPlans> search(LandManagementPlansSearchDto searchDto);
}
