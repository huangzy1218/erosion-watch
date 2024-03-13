package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.erosion.portal.domain.entity.AnalysisProject;
import cn.edu.nwafu.erosion.portal.domain.vo.AnalysisProjectVo;
import cn.edu.nwafu.erosion.portal.mapper.MyDataMapper;
import cn.edu.nwafu.erosion.portal.mapper.MyProjectMapper;
import cn.edu.nwafu.erosion.portal.service.MyProjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Huang Z.Y.
 */
@Slf4j
@Service
public class MyProjectServiceImpl extends ServiceImpl<MyProjectMapper, AnalysisProject> implements MyProjectService {
    public static final String DEFAULT_NAME = "未命名项目";
    @Autowired
    private MyProjectMapper myProjectMapper;
    @Autowired
    private MyDataMapper myDataMapper;

    @Override
    public boolean add(Long fid) {
        AnalysisProject project = new AnalysisProject();
        project.setProjectName(DEFAULT_NAME);
        project.setFid(fid);
        int count = myProjectMapper.insert(project);
        myProjectMapper.deleteById(project.getId());
        myProjectMapper.insert(project);
        return count != 0;
    }

    @Override
    public List<AnalysisProjectVo> listAll() {
        return myProjectMapper.selectList(new QueryWrapper<>())
                .stream()
                .map(project -> {
                    AnalysisProjectVo vo = new AnalysisProjectVo();
                    vo.setProjectName(project.getProjectName());
                    vo.setFid(project.getFid());
                    vo.setFileName(myDataMapper.getById(project.getFid()).getFileName());
                    vo.setUpdateTime(project.getUpdateTime());
                    return vo;
                })
                .collect(Collectors.toList());
    }
}
    