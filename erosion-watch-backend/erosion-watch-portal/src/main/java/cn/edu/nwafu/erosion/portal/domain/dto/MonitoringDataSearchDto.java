package cn.edu.nwafu.erosion.portal.domain.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Huang Z.Y.
 */
public class MonitoringDataSearchDto {
    private Long areaId;
    private Date startDate;
    private Date endDate;
    private BigDecimal minSoilErosionRate;
    private BigDecimal maxSoilErosionRate;
    private BigDecimal minVegetationCoverageRate;
    private BigDecimal maxVegetationCoverageRate;
    private BigDecimal minRainfallAmount;
    private BigDecimal maxRainfallAmount;

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getMinSoilErosionRate() {
        return minSoilErosionRate;
    }

    public void setMinSoilErosionRate(BigDecimal minSoilErosionRate) {
        this.minSoilErosionRate = minSoilErosionRate;
    }

    public BigDecimal getMaxSoilErosionRate() {
        return maxSoilErosionRate;
    }

    public void setMaxSoilErosionRate(BigDecimal maxSoilErosionRate) {
        this.maxSoilErosionRate = maxSoilErosionRate;
    }

    public BigDecimal getMinVegetationCoverageRate() {
        return minVegetationCoverageRate;
    }

    public void setMinVegetationCoverageRate(BigDecimal minVegetationCoverageRate) {
        this.minVegetationCoverageRate = minVegetationCoverageRate;
    }

    public BigDecimal getMaxVegetationCoverageRate() {
        return maxVegetationCoverageRate;
    }

    public void setMaxVegetationCoverageRate(BigDecimal maxVegetationCoverageRate) {
        this.maxVegetationCoverageRate = maxVegetationCoverageRate;
    }

    public BigDecimal getMinRainfallAmount() {
        return minRainfallAmount;
    }

    public void setMinRainfallAmount(BigDecimal minRainfallAmount) {
        this.minRainfallAmount = minRainfallAmount;
    }

    public BigDecimal getMaxRainfallAmount() {
        return maxRainfallAmount;
    }

    public void setMaxRainfallAmount(BigDecimal maxRainfallAmount) {
        this.maxRainfallAmount = maxRainfallAmount;
    }
}
    