package cn.edu.nwafu.erosion.portal.domain.entity;

import java.util.Date;
import java.util.List;

/**
 * @author Huang Z.Y.
 */
public class AnalysisProject {
    private Long id;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 文件ID
     */
    private Long fid;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 分析结果列表
     */
    private List<Long> analysisResults;

    // 构造方法
    public AnalysisProject() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Long> getAnalysisResults() {
        return analysisResults;
    }

    public void setAnalysisResults(List<Long> analysisResults) {
        this.analysisResults = analysisResults;
    }

    // toString方法，用于输出项目信息
    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", createTime=" + createTime +
                ", analysisResults=" + analysisResults +
                '}';
    }

}

    