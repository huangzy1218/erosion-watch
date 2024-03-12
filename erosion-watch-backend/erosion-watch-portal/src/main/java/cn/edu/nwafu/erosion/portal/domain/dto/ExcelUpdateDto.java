package cn.edu.nwafu.erosion.portal.domain.dto;

import java.io.Serializable;

/**
 * @author Huang Z.Y.
 */
public class ExcelUpdateDto implements Serializable {
    private String id;
    private Integer rowId;
    private Integer columnId;
    private String newVal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRowId() {
        return rowId;
    }

    public void setRowId(Integer rowId) {
        this.rowId = rowId;
    }

    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    public String getNewVal() {
        return newVal;
    }

    public void setNewVal(String newVal) {
        this.newVal = newVal;
    }

    @Override
    public String toString() {
        return "ExcelUpdateDto{" +
                "id='" + id + '\'' +
                ", rowId=" + rowId +
                ", columnId=" + columnId +
                ", newVal='" + newVal + '\'' +
                '}';
    }
}
    