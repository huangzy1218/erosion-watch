package cn.edu.nwafu.erosion.portal.domain.vo;

import java.util.Date;

/**
 * @author Huang Z.Y.
 */
public class ExcelFileVo {
    private Long fid;
    private String fileName;
    private String author;
    private Date createTime;

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
}
    