package cn.edu.nwafu.erosion.portal.service;

import cn.edu.nwafu.erosion.portal.domain.vo.AnalysisProjectVo;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
public interface MyProjectService {
    boolean add(Long fid);

    List<AnalysisProjectVo> listAll();
}
