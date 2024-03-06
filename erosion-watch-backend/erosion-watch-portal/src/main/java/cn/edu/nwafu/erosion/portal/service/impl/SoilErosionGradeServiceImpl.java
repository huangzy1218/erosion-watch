package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.erosion.mapper.SoilErosionGradeMapper;
import cn.edu.nwafu.erosion.model.SoilErosionGrade;
import cn.edu.nwafu.erosion.model.SoilErosionGradeExample;
import cn.edu.nwafu.erosion.portal.domain.dto.SoilErosionGradeDto;
import cn.edu.nwafu.erosion.portal.domain.dto.SoilErosionGradeSearchDto;
import cn.edu.nwafu.erosion.portal.service.SoilErosionGradeService;
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
public class SoilErosionGradeServiceImpl implements SoilErosionGradeService {
    @Autowired
    private SoilErosionGradeMapper soilErosionGradeMapper;

    @Override
    public int add(SoilErosionGradeDto soilErosionGradeDto) {
        SoilErosionGrade soilErosionGrade = SoilErosionGrade.builder()
                .areaId(soilErosionGradeDto.getAreaId())
                .erosionType(soilErosionGradeDto.getErosionType())
                .erosionGrade(soilErosionGradeDto.getErosionGrade())
                .erosionYears(soilErosionGradeDto.getErosionYears())
                .riskLevel(soilErosionGradeDto.getRiskLevel())
                .erosionDescription(soilErosionGradeDto.getErosionDescription())
                .riskAssessmentResult(soilErosionGradeDto.getRiskAssessmentResult())
                .managementPractice(soilErosionGradeDto.getManagementPractice()).build();

        return soilErosionGradeMapper.insert(soilErosionGrade);
    }

    @Override
    public int update(Long id, SoilErosionGradeDto soilErosionGradeDto) {
        SoilErosionGrade soilErosionGrade = SoilErosionGrade.builder()
                .id(id)
                .areaId(soilErosionGradeDto.getAreaId())
                .erosionType(soilErosionGradeDto.getErosionType())
                .erosionGrade(soilErosionGradeDto.getErosionGrade())
                .erosionYears(soilErosionGradeDto.getErosionYears())
                .riskLevel(soilErosionGradeDto.getRiskLevel())
                .erosionDescription(soilErosionGradeDto.getErosionDescription())
                .riskAssessmentResult(soilErosionGradeDto.getRiskAssessmentResult())
                .managementPractice(soilErosionGradeDto.getManagementPractice()).build();

        return soilErosionGradeMapper.updateByPrimaryKeySelective(soilErosionGrade);
    }

    @Override
    public int delete(Long id) {
        return soilErosionGradeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SoilErosionGrade getById(Long id) {
        return soilErosionGradeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SoilErosionGrade> listAll() {
        return soilErosionGradeMapper.selectByExampleWithBLOBs(new SoilErosionGradeExample());
    }

    @Override
    public List<SoilErosionGrade> search(SoilErosionGradeSearchDto soilErosionGradeSearchDto) {
        SoilErosionGradeExample example = new SoilErosionGradeExample();
        SoilErosionGradeExample.Criteria criteria = example.createCriteria();

        if (soilErosionGradeSearchDto.getAreaId() != null) {
            criteria.andAreaIdEqualTo(soilErosionGradeSearchDto.getAreaId());
        }
        if (StrUtil.isNotEmpty(soilErosionGradeSearchDto.getErosionType())) {
            criteria.andErosionTypeEqualTo(soilErosionGradeSearchDto.getErosionType());
        }
        if (StrUtil.isNotEmpty(soilErosionGradeSearchDto.getErosionGrade())) {
            criteria.andErosionGradeEqualTo(soilErosionGradeSearchDto.getErosionGrade());
        }
        if (soilErosionGradeSearchDto.getErosionYears() != null) {
            criteria.andErosionYearsEqualTo(soilErosionGradeSearchDto.getErosionYears());
        }
        if (StrUtil.isNotEmpty(soilErosionGradeSearchDto.getRiskLevel())) {
            criteria.andRiskLevelEqualTo(soilErosionGradeSearchDto.getRiskLevel());
        }

        return soilErosionGradeMapper.selectByExampleWithBLOBs(example);
    }
}
    