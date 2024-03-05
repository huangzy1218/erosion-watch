package cn.edu.nwafu.erosion.portal.domain.dto;

import java.util.Date;

/**
 * @author Huang Z.Y.
 */
public class LandUseChangeHistorySearchDto {
    private Long areaId;
    private Date startDate;
    private Date endDate;
    private String previousLandUse;
    private String currentLandUse;

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

    public String getPreviousLandUse() {
        return previousLandUse;
    }

    public void setPreviousLandUse(String previousLandUse) {
        this.previousLandUse = previousLandUse;
    }

    public String getCurrentLandUse() {
        return currentLandUse;
    }

    public void setCurrentLandUse(String currentLandUse) {
        this.currentLandUse = currentLandUse;
    }
}
    