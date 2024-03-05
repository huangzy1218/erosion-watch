package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.erosion.mapper.VegetationCoverageMapper;
import cn.edu.nwafu.erosion.model.VegetationCoverage;
import cn.edu.nwafu.erosion.model.VegetationCoverageExample;
import cn.edu.nwafu.erosion.portal.domain.dto.VegetationCoverageDto;
import cn.edu.nwafu.erosion.portal.domain.dto.VegetationCoverageSearchDto;
import cn.edu.nwafu.erosion.portal.service.VegetationCoverageService;
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
public class VegetationCoverageServiceImpl implements VegetationCoverageService {
    @Autowired
    private VegetationCoverageMapper vegetationCoverageMapper;

    @Override
    public int add(VegetationCoverageDto vegetationCoverageDto) {
        VegetationCoverage vegetationCoverage = VegetationCoverage.builder()
                .areaId(vegetationCoverageDto.getAreaId())
                .vegetationType(vegetationCoverageDto.getVegetationType())
                .coveragePercentage(vegetationCoverageDto.getCoveragePercentage())
                .density(vegetationCoverageDto.getDensity())
                .status(vegetationCoverageDto.getStatus())
                .remarks(vegetationCoverageDto.getRemarks())
                .build();
        return vegetationCoverageMapper.insertSelective(vegetationCoverage);
    }

    @Override
    public int update(Long id, VegetationCoverageDto vegetationCoverageDto) {
        VegetationCoverage vegetationCoverage = VegetationCoverage.builder()
                .id(id)
                .areaId(vegetationCoverageDto.getAreaId())
                .vegetationType(vegetationCoverageDto.getVegetationType())
                .coveragePercentage(vegetationCoverageDto.getCoveragePercentage())
                .density(vegetationCoverageDto.getDensity())
                .status(vegetationCoverageDto.getStatus())
                .remarks(vegetationCoverageDto.getRemarks())
                .build();
        log.info("VegetationCoverage: {}", vegetationCoverage);
        return vegetationCoverageMapper.updateByPrimaryKeySelective(vegetationCoverage);
    }

    @Override
    public int delete(Long id) {
        return vegetationCoverageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public VegetationCoverage getById(Long id) {
        return vegetationCoverageMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<VegetationCoverage> listAll() {
        return vegetationCoverageMapper.selectByExample(new VegetationCoverageExample());
    }

    @Override
    public List<VegetationCoverage> search(VegetationCoverageSearchDto vegetationCoverageSearchDto) {
        VegetationCoverageExample example = new VegetationCoverageExample();
        VegetationCoverageExample.Criteria criteria = example.createCriteria();

        if (vegetationCoverageSearchDto.getAreaId() != null) {
            criteria.andAreaIdEqualTo(vegetationCoverageSearchDto.getAreaId());
        }
        if (StrUtil.isNotEmpty(vegetationCoverageSearchDto.getVegetationType())) {
            criteria.andVegetationTypeEqualTo(vegetationCoverageSearchDto.getVegetationType());
        }
        if (vegetationCoverageSearchDto.getMinCoveragePercentage() != null &&
                vegetationCoverageSearchDto.getMaxCoveragePercentage() != null) {
            criteria.andCoveragePercentageBetween(vegetationCoverageSearchDto.getMinCoveragePercentage(),
                    vegetationCoverageSearchDto.getMaxCoveragePercentage());
        }
        if (StrUtil.isNotEmpty(vegetationCoverageSearchDto.getDensity())) {
            criteria.andDensityEqualTo(vegetationCoverageSearchDto.getDensity());
        }
        if (vegetationCoverageSearchDto.getStatus() != null) {
            criteria.andStatusEqualTo(vegetationCoverageSearchDto.getStatus());
        }

        return vegetationCoverageMapper.selectByExample(example);
    }
}
    