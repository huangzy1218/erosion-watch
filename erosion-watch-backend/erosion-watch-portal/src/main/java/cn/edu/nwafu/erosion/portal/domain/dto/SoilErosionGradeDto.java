package cn.edu.nwafu.erosion.portal.domain.dto;

/**
 * @author Huang Z.Y.
 */
public class SoilErosionGradeDto {
    private Long areaId;

    private String erosionType;

    private String erosionGrade;

    private Integer erosionYears;

    private String riskLevel;

    private String erosionDescription;

    private String riskAssessmentResult;

    private String managementPractice;

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
}
    