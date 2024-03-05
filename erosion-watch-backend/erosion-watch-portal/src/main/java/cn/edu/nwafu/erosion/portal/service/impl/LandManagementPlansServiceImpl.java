package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.erosion.mapper.LandManagementPlansMapper;
import cn.edu.nwafu.erosion.model.LandManagementPlans;
import cn.edu.nwafu.erosion.model.LandManagementPlansExample;
import cn.edu.nwafu.erosion.portal.domain.dto.LandManagementPlansDto;
import cn.edu.nwafu.erosion.portal.domain.dto.LandManagementPlansSearchDto;
import cn.edu.nwafu.erosion.portal.service.LandManagementPlansService;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
@Slf4j
@Service
public class LandManagementPlansServiceImpl implements LandManagementPlansService {
    @Autowired
    private LandManagementPlansMapper landManagementPlansMapper;

    @Override
    public int add(LandManagementPlansDto landManagementPlansDto) {
        LandManagementPlans landManagementPlans = LandManagementPlans.builder()
                .areaId(landManagementPlansDto.getAreaId())
                .planDate(landManagementPlansDto.getPlanDate())
                .planType(landManagementPlansDto.getPlanType())
                .responsibleUnit(landManagementPlansDto.getResponsibleUnit())
                .implementationDate(landManagementPlansDto.getImplementationDate())
                .planContent(landManagementPlansDto.getPlanContent())
                .build();

        return landManagementPlansMapper.insert(landManagementPlans);
    }

    @Override
    public int update(Long id, LandManagementPlansDto landManagementPlansDto) {
        LandManagementPlans landManagementPlans = LandManagementPlans.builder()
                .id(id)
                .areaId(landManagementPlansDto.getAreaId())
                .planDate(landManagementPlansDto.getPlanDate())
                .planType(landManagementPlansDto.getPlanType())
                .responsibleUnit(landManagementPlansDto.getResponsibleUnit())
                .implementationDate(landManagementPlansDto.getImplementationDate())
                .planContent(landManagementPlansDto.getPlanContent())
                .build();

        return landManagementPlansMapper.updateByPrimaryKeySelective(landManagementPlans);
    }

    @Override
    public int delete(Long id) {
        return landManagementPlansMapper.deleteByPrimaryKey(id);
    }

    @Override
    public LandManagementPlans getById(Long id) {
        return landManagementPlansMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<LandManagementPlans> listAll() {
        return landManagementPlansMapper.selectByExample(new LandManagementPlansExample());
    }

    @Override
    public List<LandManagementPlans> search(LandManagementPlansSearchDto landManagementPlansSearchDto) {
        LandManagementPlansExample example = new LandManagementPlansExample();
        LandManagementPlansExample.Criteria criteria = example.createCriteria();

        if (landManagementPlansSearchDto.getAreaId() != null) {
            criteria.andAreaIdEqualTo(landManagementPlansSearchDto.getAreaId());
        }
        if (landManagementPlansSearchDto.getPlanDate() != null) {
            criteria.andPlanDateEqualTo(landManagementPlansSearchDto.getPlanDate());
        }
        if (StrUtil.isNotEmpty(landManagementPlansSearchDto.getPlanType())) {
            criteria.andPlanTypeEqualTo(landManagementPlansSearchDto.getPlanType());
        }
        if (landManagementPlansSearchDto.getImplementationDate() != null) {
            criteria.andImplementationDateEqualTo(landManagementPlansSearchDto.getImplementationDate());
        }

        return landManagementPlansMapper.selectByExample(example);
    }
}
    