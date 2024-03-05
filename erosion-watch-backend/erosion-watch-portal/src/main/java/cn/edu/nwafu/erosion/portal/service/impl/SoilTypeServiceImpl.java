package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.erosion.mapper.SoilTypeMapper;
import cn.edu.nwafu.erosion.model.SoilType;
import cn.edu.nwafu.erosion.model.SoilTypeExample;
import cn.edu.nwafu.erosion.portal.domain.dto.SoilTypeDto;
import cn.edu.nwafu.erosion.portal.domain.dto.SoilTypeSearchDto;
import cn.edu.nwafu.erosion.portal.service.SoilTypeService;
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
public class SoilTypeServiceImpl implements SoilTypeService {
    @Autowired
    private SoilTypeMapper soilTypeMapper;

    @Override
    public int add(SoilTypeDto soilTypeDto) {
        SoilType soilType = SoilType.builder()
                .parentId(soilTypeDto.getParentId())
                .name(soilTypeDto.getName())
                .level(soilTypeDto.getLevel())
                .soilQuality(soilTypeDto.getSoilQuality())
                .soilMoisture(soilTypeDto.getSoilMoisture())
                .description(soilTypeDto.getDescription())
                .build();
        return soilTypeMapper.insertSelective(soilType);
    }

    @Override
    public int update(Long id, SoilTypeDto soilTypeDto) {
        SoilType soilType = SoilType.builder()
                .id(id)
                .parentId(soilTypeDto.getParentId())
                .name(soilTypeDto.getName())
                .level(soilTypeDto.getLevel())
                .soilQuality(soilTypeDto.getSoilQuality())
                .soilMoisture(soilTypeDto.getSoilMoisture())
                .description(soilTypeDto.getDescription())
                .build();
        log.info("SoilType: {}", soilType);
        return soilTypeMapper.updateByPrimaryKeySelective(soilType);
    }

    @Override
    public int delete(Long id) {
        return soilTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SoilType getById(Long id) {
        return soilTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SoilType> listAll() {
        return soilTypeMapper.selectByExample(new SoilTypeExample());
    }

    @Override
    public List<SoilType> search(SoilTypeSearchDto soilTypeSearchDto) {
        SoilTypeExample example = new SoilTypeExample();
        SoilTypeExample.Criteria criteria = example.createCriteria();

        if (StrUtil.isNotEmpty(soilTypeSearchDto.getName())) {
            criteria.andNameLike(soilTypeSearchDto.getName());
        }
        if (StrUtil.isNotEmpty(soilTypeSearchDto.getSoilQuality())) {
            criteria.andSoilQualityEqualTo(soilTypeSearchDto.getSoilQuality());
        }
        if (StrUtil.isNotEmpty(soilTypeSearchDto.getSoilMoisture())) {
            criteria.andSoilMoistureEqualTo(soilTypeSearchDto.getSoilMoisture());
        }

        return soilTypeMapper.selectByExample(example);
    }
}
    