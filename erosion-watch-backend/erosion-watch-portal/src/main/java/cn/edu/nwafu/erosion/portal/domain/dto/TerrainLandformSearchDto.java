package cn.edu.nwafu.erosion.portal.domain.dto;

import java.math.BigDecimal;

/**
 * @author Huang Z.Y.
 */
public class TerrainLandformSearchDto {
    private Long areaId;

    private String terrainType;

    private String landformType;

    private BigDecimal minElevation;

    private BigDecimal maxElevation;

    private BigDecimal minSlope;

    private BigDecimal maxSlope;

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

    public BigDecimal getMinElevation() {
        return minElevation;
    }

    public void setMinElevation(BigDecimal minElevation) {
        this.minElevation = minElevation;
    }

    public BigDecimal getMaxElevation() {
        return maxElevation;
    }

    public void setMaxElevation(BigDecimal maxElevation) {
        this.maxElevation = maxElevation;
    }

    public BigDecimal getMinSlope() {
        return minSlope;
    }

    public void setMinSlope(BigDecimal minSlope) {
        this.minSlope = minSlope;
    }

    public BigDecimal getMaxSlope() {
        return maxSlope;
    }

    public void setMaxSlope(BigDecimal maxSlope) {
        this.maxSlope = maxSlope;
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
    