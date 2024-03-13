package cn.edu.nwafu.erosion.portal.domain.entity;

import java.util.Date;
import java.util.List;

/**
 * @author Huang Z.Y.
 */
public class ReferencePdf {
    /**
     * 文献的唯一标识
     */
    private Long id;
    /**
     * 文献题目
     */
    private String label;
    /**
     * 相应PDF文档的链接
     */
    private String pdfUrl;
    /**
     * 文献的作者
     */
    private String author;
    /**
     * 发布年份
     */
    private Integer year;
    /**
     * 文献摘要
     */
    private String abstractText;
    /**
     * 子文献列表
     */
    private List<ReferencePdf> children;
    private Date createTime;


    // 示例构造函数
    public ReferencePdf(Long id, String label, String pdfUrl,
                        String author, Integer year, String abstractText,
                        Date createTime) {
        this.id = id;
        this.label = label;
        this.pdfUrl = pdfUrl;
        this.author = author;
        this.year = year;
        this.abstractText = abstractText;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public List<ReferencePdf> getChildren() {
        return children;
    }

    public void setChildren(List<ReferencePdf> children) {
        this.children = children;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
    