package cn.edu.nwafu.erosion.portal.service.impl;

import cn.edu.nwafu.erosion.mapper.TerrainLandformMapper;
import cn.edu.nwafu.erosion.model.TerrainLandform;
import cn.edu.nwafu.erosion.model.TerrainLandformExample;
import cn.edu.nwafu.erosion.portal.domain.dto.TerrainLandformDto;
import cn.edu.nwafu.erosion.portal.domain.dto.TerrainLandformSearchDto;
import cn.edu.nwafu.erosion.portal.service.TerrainLandformService;
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
public class TerrainLandformServiceImpl implements TerrainLandformService {
    @Autowired
    private TerrainLandformMapper terrainLandformMapper;

    @Override
    public int add(TerrainLandformDto terrainLandformDto) {
        TerrainLandform terrainLandform = TerrainLandform.builder()
                .areaId(terrainLandformDto.getAreaId())
                .terrainType(terrainLandformDto.getTerrainType())
                .landformType(terrainLandformDto.getLandformType())
                .elevation(terrainLandformDto.getElevation())
                .slope(terrainLandformDto.getSlope())
                .soilType(terrainLandformDto.getSoilType())
                .vegetationType(terrainLandformDto.getVegetationType())
                .waterSystem(terrainLandformDto.getWaterSystem())
                .build();
        return terrainLandformMapper.insertSelective(terrainLandform);
    }

    @Override
    public int update(Long id, TerrainLandformDto terrainLandformDto) {
        TerrainLandform terrainLandform = TerrainLandform.builder()
                .id(id)
                .areaId(terrainLandformDto.getAreaId())
                .terrainType(terrainLandformDto.getTerrainType())
                .landformType(terrainLandformDto.getLandformType())
                .elevation(terrainLandformDto.getElevation())
                .slope(terrainLandformDto.getSlope())
                .soilType(terrainLandformDto.getSoilType())
                .vegetationType(terrainLandformDto.getVegetationType())
                .waterSystem(terrainLandformDto.getWaterSystem())
                .build();
        log.info("TerrainLandform: {}", terrainLandform);
        return terrainLandformMapper.updateByPrimaryKeySelective(terrainLandform);
    }

    @Override
    public int delete(Long id) {
        return terrainLandformMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TerrainLandform getById(Long id) {
        return terrainLandformMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TerrainLandform> listAll() {
        return terrainLandformMapper.selectByExample(new TerrainLandformExample());
    }

    @Override
    public List<TerrainLandform> search(TerrainLandformSearchDto terrainLandformSearchDto) {
        TerrainLandformExample example = new TerrainLandformExample();
        TerrainLandformExample.Criteria criteria = example.createCriteria();

        if (terrainLandformSearchDto.getAreaId() != null) {
            criteria.andAreaIdEqualTo(terrainLandformSearchDto.getAreaId());
        }
        if (StrUtil.isNotEmpty(terrainLandformSearchDto.getTerrainType())) {
            criteria.andTerrainTypeEqualTo(terrainLandformSearchDto.getTerrainType());
        }
        if (StrUtil.isNotEmpty(terrainLandformSearchDto.getLandformType())) {
            criteria.andLandformTypeEqualTo(terrainLandformSearchDto.getLandformType());
        }
        if (terrainLandformSearchDto.getMinElevation() != null &&
                terrainLandformSearchDto.getMaxElevation() != null) {
            criteria.andElevationBetween(terrainLandformSearchDto.getMinElevation(),
                    terrainLandformSearchDto.getMaxElevation());
        }
        if (terrainLandformSearchDto.getMinSlope() != null &&
                terrainLandformSearchDto.getMaxSlope() != null) {
            criteria.andSlopeBetween(terrainLandformSearchDto.getMinSlope(),
                    terrainLandformSearchDto.getMaxSlope());
        }
        if (StrUtil.isNotEmpty(terrainLandformSearchDto.getSoilType())) {
            criteria.andSoilTypeEqualTo(terrainLandformSearchDto.getSoilType());
        }
        if (StrUtil.isNotEmpty(terrainLandformSearchDto.getVegetationType())) {
            criteria.andVegetationTypeEqualTo(terrainLandformSearchDto.getVegetationType());
        }
        if (StrUtil.isNotEmpty(terrainLandformSearchDto.getWaterSystem())) {
            criteria.andWaterSystemEqualTo(terrainLandformSearchDto.getWaterSystem());
        }

        return terrainLandformMapper.selectByExample(example);
    }
}