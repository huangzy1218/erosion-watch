package cn.edu.nwafu.erosion.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LandManagementPlans implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "记录ID")
    private Long id;
    @ApiModelProperty(value = "地区ID")
    private Long areaId;
    @ApiModelProperty(value = "计划日期")
    private Date planDate;
    @ApiModelProperty(value = "计划类型（规划/项目）")
    private String planType;
    @ApiModelProperty(value = "责任单位")
    private String responsibleUnit;
    @ApiModelProperty(value = "实施日期")
    private Date implementationDate;
    @ApiModelProperty(value = "计划内容")
    private String planContent;

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

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getResponsibleUnit() {
        return responsibleUnit;
    }

    public void setResponsibleUnit(String responsibleUnit) {
        this.responsibleUnit = responsibleUnit;
    }

    public Date getImplementationDate() {
        return implementationDate;
    }

    public void setImplementationDate(Date implementationDate) {
        this.implementationDate = implementationDate;
    }

    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", areaId=").append(areaId);
        sb.append(", planDate=").append(planDate);
        sb.append(", planType=").append(planType);
        sb.append(", responsibleUnit=").append(responsibleUnit);
        sb.append(", implementationDate=").append(implementationDate);
        sb.append(", planContent=").append(planContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}