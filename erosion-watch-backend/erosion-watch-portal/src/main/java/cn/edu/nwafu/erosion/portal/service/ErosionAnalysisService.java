package cn.edu.nwafu.erosion.portal.service;

import cn.edu.nwafu.erosion.portal.domain.dto.USLEInputDto;
import cn.edu.nwafu.erosion.portal.domain.vo.ErosionInputResultVo;

/**
 * @author Huang Z.Y.
 */
public interface ErosionAnalysisService {
    ErosionInputResultVo analysis(USLEInputDto usleInputDto);
}
