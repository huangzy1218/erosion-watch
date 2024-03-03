package cn.edu.nwafu.erosion.portal.domain.entity;

import java.util.Date;

/**
 * @author Huang Z.Y.
 */
public class DataAnalysisResult {
    /**
     * 分析ID
     */
    private Long id;
    /**
     * 项目ID
     */
    private Long projectId;
    /**
     * 分析名称
     */
    private String analysisName;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 详细报告路径
     */
    private String reportPath;

    public DataAnalysisResult(Long id, Long projectId, String analysisName,
                              Date startTime, String reportPath) {
        this.id = id;
        this.projectId = projectId;
        this.analysisName = analysisName;
        this.startTime = startTime;
        this.reportPath = reportPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getAnalysisName() {
        return analysisName;
    }

    public void setAnalysisName(String analysisName) {
        this.analysisName = analysisName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    @Override
    public String toString() {
        return "DataAnalysisResult{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", analysisName='" + analysisName + '\'' +
                ", startTime=" + startTime +
                ", reportPath='" + reportPath + '\'' +
                '}';
    }
}
    