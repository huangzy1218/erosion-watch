package cn.edu.nwafu.erosion.portal.domain.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Huang Z.Y.
 */
public class MonitoringDataDto {
    private Long areaId;
    private Date monitoringDate;
    private BigDecimal soilErosionRate;
    private BigDecimal vegetationCoverageRate;
    private BigDecimal rainfallAmount;

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
}
    