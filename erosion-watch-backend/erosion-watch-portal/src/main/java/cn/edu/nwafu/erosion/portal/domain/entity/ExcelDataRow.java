package cn.edu.nwafu.erosion.portal.domain.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据表的一行数据
 *
 * @author Huang Z.Y.
 */
public class ExcelDataRow {
    /**
     * 映射以将列标题存储为键，将单元格数据存储为值
     */
    private Map<String, Object> data;

    public ExcelDataRow() {
        this.data = new HashMap<>();
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
    
    public void addData(String key, Object value) {
        this.data.put(key, value);
    }

    @Override
    public String toString() {
        return "ExcelDataRow{" +
                "data=" + data +
                '}';
    }
}
    