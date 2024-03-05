package cn.edu.nwafu.erosion.portal.domain.dto;

import java.math.BigDecimal;

/**
 * @author Huang Z.Y.
 */
public class AreaSearchDto {
    private String areaName;
    private String administrativeCode;
    private BigDecimal minLatitude;
    private BigDecimal maxLatitude;
    private BigDecimal minLongitude;
    private BigDecimal maxLongitude;

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

    public BigDecimal getMinLatitude() {
        return minLatitude;
    }

    public void setMinLatitude(BigDecimal minLatitude) {
        this.minLatitude = minLatitude;
    }

    public BigDecimal getMaxLatitude() {
        return maxLatitude;
    }

    public void setMaxLatitude(BigDecimal maxLatitude) {
        this.maxLatitude = maxLatitude;
    }

    public BigDecimal getMinLongitude() {
        return minLongitude;
    }

    public void setMinLongitude(BigDecimal minLongitude) {
        this.minLongitude = minLongitude;
    }

    public BigDecimal getMaxLongitude() {
        return maxLongitude;
    }

    public void setMaxLongitude(BigDecimal maxLongitude) {
        this.maxLongitude = maxLongitude;
    }
}
    