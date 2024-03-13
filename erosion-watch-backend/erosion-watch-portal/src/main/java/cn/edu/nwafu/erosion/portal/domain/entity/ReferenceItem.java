package cn.edu.nwafu.erosion.portal.domain.entity;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
public class ReferenceItem {
    private Long id;
    private String label;
    private String pdfUrl;
    private List<ReferenceItem> children;

    public ReferenceItem(Long id, String label,
                         String pdfUrl, List<ReferenceItem> children) {
        this.id = id;
        this.label = label;
        this.pdfUrl = pdfUrl;
        this.children = children;
    }

    public ReferenceItem() {
        // noop
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

    public List<ReferenceItem> getChildren() {
        return children;
    }

    public void setChildren(List<ReferenceItem> children) {
        this.children = children;
    }
}
    