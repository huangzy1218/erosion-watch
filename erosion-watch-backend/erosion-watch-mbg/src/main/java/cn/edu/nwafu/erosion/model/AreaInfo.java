package cn.edu.nwafu.erosion.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AreaInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    @ApiModelProperty(value = "地区名称")
    private String areaName;
    @ApiModelProperty(value = "行政区划代码")
    private String administrativeCode;
    @ApiModelProperty(value = "纬度")
    private BigDecimal latitude;
    @ApiModelProperty(value = "经度")
    private BigDecimal longitude;
    @ApiModelProperty(value = "面积")
    private BigDecimal area;
    @ApiModelProperty(value = "人口")
    private Integer population;
    @ApiModelProperty(value = "气候类型")
    private String climateType;
    @ApiModelProperty(value = "地形特征")
    private String terrainFeature;
    @ApiModelProperty(value = "地貌特征")
    private String landformFeature;
    @ApiModelProperty(value = "土地利用情况")
    private String landUse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", areaName=").append(areaName);
        sb.append(", administrativeCode=").append(administrativeCode);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", area=").append(area);
        sb.append(", population=").append(population);
        sb.append(", climateType=").append(climateType);
        sb.append(", terrainFeature=").append(terrainFeature);
        sb.append(", landformFeature=").append(landformFeature);
        sb.append(", landUse=").append(landUse);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}