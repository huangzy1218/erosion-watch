package cn.edu.nwafu.erosion.portal.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

/**
 * @author Huang Z.Y.
 */
@Document
public class ExcelDocument {
    @Id
    private String id;
    private String excelName;
    /**
     * 表头
     */
    private List<String> headers;
    /**
     * 实际数据
     */
    private List<Map<Integer, String>> data;

    public ExcelDocument() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExcelName() {
        return excelName;
    }

    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public List<Map<Integer, String>> getData() {
        return data;
    }

    public void setData(List<Map<Integer, String>> data) {
        this.data = data;
    }
}
    