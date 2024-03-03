package cn.edu.nwafu.erosion.portal.domain.entity;

import java.util.Date;

/**
 * @author Huang Z.Y.
 */
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
     * 文件大小（字节为单位）
     */
    private Long fileSize;
    /**
     * 创建时间
     */
    private Date createTime;

    // 构造函数
    public ExcelFile() {
    }

    // Getters 和 Setters
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

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    // toString方法
    @Override
    public String toString() {
        return "ExcelFile{" +
                "fid=" + fid +
                ", fileName='" + fileName + '\'' +
                ", author='" + author + '\'' +
                ", fileSize=" + fileSize +
                ", createTime=" + createTime +
                '}';
    }
}
    