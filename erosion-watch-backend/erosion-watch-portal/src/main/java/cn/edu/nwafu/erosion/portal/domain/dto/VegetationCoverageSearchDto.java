package cn.edu.nwafu.erosion.portal.domain.dto;

import java.math.BigDecimal;

/**
 * @author Huang Z.Y.
 */
public class VegetationCoverageSearchDto {
    private Long areaId;

    private String vegetationType;

    private BigDecimal minCoveragePercentage;

    private BigDecimal maxCoveragePercentage;

    private String density;

    private Integer status;

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getVegetationType() {
        return vegetationType;
    }

    public void setVegetationType(String vegetationType) {
        this.vegetationType = vegetationType;
    }

    public BigDecimal getMinCoveragePercentage() {
        return minCoveragePercentage;
    }

    public void setMinCoveragePercentage(BigDecimal minCoveragePercentage) {
        this.minCoveragePercentage = minCoveragePercentage;
    }

    public BigDecimal getMaxCoveragePercentage() {
        return maxCoveragePercentage;
    }

    public void setMaxCoveragePercentage(BigDecimal maxCoveragePercentage) {
        this.maxCoveragePercentage = maxCoveragePercentage;
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
    