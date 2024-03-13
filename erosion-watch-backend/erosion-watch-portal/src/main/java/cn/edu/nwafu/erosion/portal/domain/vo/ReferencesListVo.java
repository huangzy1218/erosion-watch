package cn.edu.nwafu.erosion.portal.domain.vo;

import cn.edu.nwafu.erosion.portal.domain.entity.ReferenceItem;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
public class ReferencesListVo {
    private List<ReferenceItem> nodes;

    public ReferencesListVo(List<ReferenceItem> nodes) {
        this.nodes = nodes;
    }

    public ReferencesListVo() {
        // noop
    }

    public List<ReferenceItem> getNodes() {
        return nodes;
    }

    public void setNodes(List<ReferenceItem> nodes) {
        this.nodes = nodes;
    }


}
    