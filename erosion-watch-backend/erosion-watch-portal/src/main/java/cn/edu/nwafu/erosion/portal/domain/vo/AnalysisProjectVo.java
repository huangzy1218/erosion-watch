package cn.edu.nwafu.erosion.portal.domain.vo;

import java.util.Date;

/**
 * @author Huang Z.Y.
 */
public class AnalysisProjectVo {
    private Long id;
    private Long fid;
    private String projectName;
    private String fileName;
    private Date updateTime;

    public AnalysisProjectVo(Long id, String projectName, String fileName, Date updateTime) {
        this.id = id;
        this.projectName = projectName;
        this.fileName = fileName;
        this.updateTime = updateTime;
    }

    public AnalysisProjectVo() {
        // noop
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
    