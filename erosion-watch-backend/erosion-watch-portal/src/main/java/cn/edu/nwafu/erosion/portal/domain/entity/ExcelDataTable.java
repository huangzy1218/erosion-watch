package cn.edu.nwafu.erosion.portal.domain.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huang Z.Y.
 */
public class ExcelDataTable {
    private Long id;
    /**
     * 表的名称
     */
    private String name;
    /**
     * 存储多行数据的列表
     */
    private List<ExcelDataRow> rows;
    
    public ExcelDataTable() {
        this.rows = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExcelDataRow> getRows() {
        return rows;
    }

    public void setRows(List<ExcelDataRow> rows) {
        this.rows = rows;
    }

    // 添加行数据
    public void addRow(ExcelDataRow row) {
        this.rows.add(row);
    }

    @Override
    public String toString() {
        return "ExcelDataTable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rows=" + rows +
                '}';
    }
}
    