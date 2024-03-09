package cn.edu.nwafu.erosion.portal.domain.entity;

import lombok.Builder;

import java.util.Date;

/**
 * @author Huang Z.Y.
 */
@Builder
public class ExcelFile {
    /**
     * 文件ID
     */
    private Long fid;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 作者
     */
    private String author;
    /**
     * 创建时间
     */
    private Date createTime;
    private Date updateTime;
    private String updateUser;
    private String urlPath;
    private String mongoId;

    public ExcelFile() {
    }

    public ExcelFile(Long fid, String fileName,
                     String author, Date createTime,
                     Date updateTime, String updateUser,
                     String urlPath, String mongoId) {
        this.fid = fid;
        this.fileName = fileName;
        this.author = author;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
        this.urlPath = urlPath;
        this.mongoId = mongoId;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getMongoId() {
        return mongoId;
    }

    public void setMongoId(String mongoId) {
        this.mongoId = mongoId;
    }

    @Override
    public String toString() {
        return "ExcelFile{" +
                "fid=" + fid +
                ", fileName='" + fileName + '\'' +
                ", author='" + author + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", updateUser='" + updateUser + '\'' +
                ", urlPath='" + urlPath + '\'' +
                ", mongoId='" + mongoId + '\'' +
                '}';
    }
}
    