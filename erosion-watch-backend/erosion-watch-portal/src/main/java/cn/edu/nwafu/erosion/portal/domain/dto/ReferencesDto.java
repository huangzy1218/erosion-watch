package cn.edu.nwafu.erosion.portal.domain.dto;

/**
 * @author Huang Z.Y.
 */
public class ReferencesDto {
    /**
     * 标题
     */
    private String label;
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
    private Long parentId;

    public ReferencesDto(String label, String author,
                         Integer year, String abstractText, Long parentId) {
        this.label = label;
        this.author = author;
        this.year = year;
        this.abstractText = abstractText;
        this.parentId = parentId;
    }

    public ReferencesDto() {
        // noop
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
    