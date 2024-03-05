package cn.edu.nwafu.erosion.portal.domain.dto;

import java.math.BigDecimal;

/**
 * @author Huang Z.Y.
 */
public class TerrainLandformDto {
    private Long areaId;

    private String terrainType;

    private String landformType;

    private BigDecimal elevation;

    private BigDecimal slope;

    private String soilType;

    private String vegetationType;

    private String waterSystem;

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getTerrainType() {
        return terrainType;
    }

    public void setTerrainType(String terrainType) {
        this.terrainType = terrainType;
    }

    public String getLandformType() {
        return landformType;
    }

    public void setLandformType(String landformType) {
        this.landformType = landformType;
    }

    public BigDecimal getElevation() {
        return elevation;
    }

    public void setElevation(BigDecimal elevation) {
        this.elevation = elevation;
    }

    public BigDecimal getSlope() {
        return slope;
    }

    public void setSlope(BigDecimal slope) {
        this.slope = slope;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public String getVegetationType() {
        return vegetationType;
    }

    public void setVegetationType(String vegetationType) {
        this.vegetationType = vegetationType;
    }

    public String getWaterSystem() {
        return waterSystem;
    }

    public void setWaterSystem(String waterSystem) {
        this.waterSystem = waterSystem;
    }
}
    