package cn.edu.nwafu.erosion.portal.domain.dto;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
public class CommonDataDto {
    private List<String> headers;
    private List<List<Double>> data;

    public CommonDataDto(List<String> headers, List<List<Double>> data) {
        this.headers = headers;
        this.data = data;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public List<List<Double>> getData() {
        return data;
    }

    public void setData(List<List<Double>> data) {
        this.data = data;
    }
}
    