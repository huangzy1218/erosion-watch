package cn.edu.nwafu.erosion.portal.domain.dto;

import java.math.BigDecimal;

/**
 * @author Huang Z.Y.
 */
public class AreaInfoDto {
    private String areaName;
    private String administrativeCode;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal area;
    private Integer population;
    private String climateType;
    private String terrainFeature;
    private String landformFeature;
    private String landUse;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAdministrativeCode() {
        return administrativeCode;
    }

    public void setAdministrativeCode(String administrativeCode) {
        this.administrativeCode = administrativeCode;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getClimateType() {
        return climateType;
    }

    public void setClimateType(String climateType) {
        this.climateType = climateType;
    }

    public String getTerrainFeature() {
        return terrainFeature;
    }

    public void setTerrainFeature(String terrainFeature) {
        this.terrainFeature = terrainFeature;
    }

    public String getLandformFeature() {
        return landformFeature;
    }

    public void setLandformFeature(String landformFeature) {
        this.landformFeature = landformFeature;
    }

    public String getLandUse() {
        return landUse;
    }

    public void setLandUse(String landUse) {
        this.landUse = landUse;
    }
}
    