package cn.edu.nwafu.erosion.portal.domain.dto;

import java.util.Date;

/**
 * @author Huang Z.Y.
 */
public class LandUseChangeHistoryDto {
    private Long areaId;

    private Date changeDate;

    private String previousLandUse;

    private String currentLandUse;

    private String changeReason;
    
    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
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

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }
}
    