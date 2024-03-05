package cn.edu.nwafu.erosion.portal.service;

import cn.edu.nwafu.erosion.model.TerrainLandform;
import cn.edu.nwafu.erosion.portal.domain.dto.TerrainLandformDto;
import cn.edu.nwafu.erosion.portal.domain.dto.TerrainLandformSearchDto;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
public interface TerrainLandformService {
    int add(TerrainLandformDto terrainLandformDto);

    TerrainLandform getById(Long id);

    int delete(Long id);

    List<TerrainLandform> listAll();

    List<TerrainLandform> search(TerrainLandformSearchDto terrainLandformSearchDto);

    int update(Long id, TerrainLandformDto terrainLandformDto);
}
