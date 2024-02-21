package cn.edu.nwafu.erosion.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class LandUseChangeHistory implements Serializable {
    @ApiModelProperty(value = "记录ID")
    private Long id;

    @ApiModelProperty(value = "地区ID")
    private Long areaId;

    @ApiModelProperty(value = "变更日期")
    private Date changeDate;

    @ApiModelProperty(value = "之前的土地利用情况")
    private String previousLandUse;

    @ApiModelProperty(value = "当前的土地利用情况")
    private String currentLandUse;

    @ApiModelProperty(value = "变更原因")
    private String changeReason;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", areaId=").append(areaId);
        sb.append(", changeDate=").append(changeDate);
        sb.append(", previousLandUse=").append(previousLandUse);
        sb.append(", currentLandUse=").append(currentLandUse);
        sb.append(", changeReason=").append(changeReason);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}