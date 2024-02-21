package cn.edu.nwafu.erosion.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SoilErosionGrade implements Serializable {
    @ApiModelProperty(value = "记录ID")
    private Long id;

    @ApiModelProperty(value = "地区ID")
    private Long areaId;

    @ApiModelProperty(value = "侵蚀类型")
    private String erosionType;

    @ApiModelProperty(value = "侵蚀等级")
    private String erosionGrade;

    @ApiModelProperty(value = "抗蚀年限（单位：年）")
    private Integer erosionYears;

    @ApiModelProperty(value = "风险等级")
    private String riskLevel;

    @ApiModelProperty(value = "侵蚀描述")
    private String erosionDescription;

    @ApiModelProperty(value = "风险评估结果")
    private String riskAssessmentResult;

    @ApiModelProperty(value = "管理措施")
    private String managementPractice;

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

    public String getErosionType() {
        return erosionType;
    }

    public void setErosionType(String erosionType) {
        this.erosionType = erosionType;
    }

    public String getErosionGrade() {
        return erosionGrade;
    }

    public void setErosionGrade(String erosionGrade) {
        this.erosionGrade = erosionGrade;
    }

    public Integer getErosionYears() {
        return erosionYears;
    }

    public void setErosionYears(Integer erosionYears) {
        this.erosionYears = erosionYears;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getErosionDescription() {
        return erosionDescription;
    }

    public void setErosionDescription(String erosionDescription) {
        this.erosionDescription = erosionDescription;
    }

    public String getRiskAssessmentResult() {
        return riskAssessmentResult;
    }

    public void setRiskAssessmentResult(String riskAssessmentResult) {
        this.riskAssessmentResult = riskAssessmentResult;
    }

    public String getManagementPractice() {
        return managementPractice;
    }

    public void setManagementPractice(String managementPractice) {
        this.managementPractice = managementPractice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", areaId=").append(areaId);
        sb.append(", erosionType=").append(erosionType);
        sb.append(", erosionGrade=").append(erosionGrade);
        sb.append(", erosionYears=").append(erosionYears);
        sb.append(", riskLevel=").append(riskLevel);
        sb.append(", erosionDescription=").append(erosionDescription);
        sb.append(", riskAssessmentResult=").append(riskAssessmentResult);
        sb.append(", managementPractice=").append(managementPractice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}