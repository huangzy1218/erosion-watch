package cn.edu.nwafu.erosion.portal.domain.vo;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
public class ExcelDataVo {
    private List<String> colHeaders;
    private List<List<String>> data;

    public List<String> getColHeaders() {
        return colHeaders;
    }

    public void setColHeaders(List<String> colHeaders) {
        this.colHeaders = colHeaders;
    }

    public List<List<String>> getData() {
        return data;
    }

    public void setData(List<List<String>> data) {
        this.data = data;
    }
}
    