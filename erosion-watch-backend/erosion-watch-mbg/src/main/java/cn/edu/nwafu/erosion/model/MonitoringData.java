package cn.edu.nwafu.erosion.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MonitoringData implements Serializable {
    @ApiModelProperty(value = "记录ID")
    private Long id;

    @ApiModelProperty(value = "地区ID")
    private Long areaId;

    @ApiModelProperty(value = "监测日期")
    private Date monitoringDate;

    @ApiModelProperty(value = "土壤侵蚀率")
    private BigDecimal soilErosionRate;

    @ApiModelProperty(value = "植被覆盖率")
    private BigDecimal vegetationCoverageRate;

    @ApiModelProperty(value = "降雨量（单位：毫米）")
    private BigDecimal rainfallAmount;

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

    public Date getMonitoringDate() {
        return monitoringDate;
    }

    public void setMonitoringDate(Date monitoringDate) {
        this.monitoringDate = monitoringDate;
    }

    public BigDecimal getSoilErosionRate() {
        return soilErosionRate;
    }

    public void setSoilErosionRate(BigDecimal soilErosionRate) {
        this.soilErosionRate = soilErosionRate;
    }

    public BigDecimal getVegetationCoverageRate() {
        return vegetationCoverageRate;
    }

    public void setVegetationCoverageRate(BigDecimal vegetationCoverageRate) {
        this.vegetationCoverageRate = vegetationCoverageRate;
    }

    public BigDecimal getRainfallAmount() {
        return rainfallAmount;
    }

    public void setRainfallAmount(BigDecimal rainfallAmount) {
        this.rainfallAmount = rainfallAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", areaId=").append(areaId);
        sb.append(", monitoringDate=").append(monitoringDate);
        sb.append(", soilErosionRate=").append(soilErosionRate);
        sb.append(", vegetationCoverageRate=").append(vegetationCoverageRate);
        sb.append(", rainfallAmount=").append(rainfallAmount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}