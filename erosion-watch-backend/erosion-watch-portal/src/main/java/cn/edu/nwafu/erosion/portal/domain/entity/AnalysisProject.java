package cn.edu.nwafu.erosion.portal.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @author Huang Z.Y.
 */
@TableName("analysis_project")
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
     * 创建人
     */
    private String author;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 更新用户
     */
    private String updateUser;

    public AnalysisProject() {
    }

    public AnalysisProject(Long id, String projectName, Long fid,
                           String author, Date createTime, Date updateTime, String updateUser) {
        this.id = id;
        this.projectName = projectName;
        this.fid = fid;
        this.author = author;
        this.updateUser = updateUser;
    }
    
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return "AnalysisProject{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", fid=" + fid +
                ", author='" + author + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

    