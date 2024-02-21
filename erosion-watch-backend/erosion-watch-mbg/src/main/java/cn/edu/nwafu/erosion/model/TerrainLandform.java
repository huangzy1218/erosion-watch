package cn.edu.nwafu.erosion.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

public class TerrainLandform implements Serializable {
    @ApiModelProperty(value = "记录ID")
    private Long id;

    @ApiModelProperty(value = "地区ID")
    private Long areaId;

    @ApiModelProperty(value = "地形类型")
    private String terrainType;

    @ApiModelProperty(value = "地貌类型")
    private String landformType;

    @ApiModelProperty(value = "海拔高度（单位：米）")
    private BigDecimal elevation;

    @ApiModelProperty(value = "坡度（单位：度）")
    private BigDecimal slope;

    @ApiModelProperty(value = "土壤类型")
    private String soilType;

    @ApiModelProperty(value = "植被类型")
    private String vegetationType;

    @ApiModelProperty(value = "水系类型")
    private String waterSystem;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", areaId=").append(areaId);
        sb.append(", terrainType=").append(terrainType);
        sb.append(", landformType=").append(landformType);
        sb.append(", elevation=").append(elevation);
        sb.append(", slope=").append(slope);
        sb.append(", soilType=").append(soilType);
        sb.append(", vegetationType=").append(vegetationType);
        sb.append(", waterSystem=").append(waterSystem);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}