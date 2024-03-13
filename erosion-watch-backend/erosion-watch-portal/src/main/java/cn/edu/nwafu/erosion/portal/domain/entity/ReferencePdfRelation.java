package cn.edu.nwafu.erosion.portal.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author Huang Z.Y.
 */
@TableName("reference_pdf_relation")
public class ReferencePdfRelation {
    private Long parentId;
    private Long childId;

    public ReferencePdfRelation(Long parentId, Long childId) {
        this.parentId = parentId;
        this.childId = childId;
    }

    public ReferencePdfRelation() {
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }
}
    