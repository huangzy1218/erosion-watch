package cn.edu.nwafu.common.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.listener.PageReadListener;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Huang Z.Y.
 */
public class ExcelUtil {
    /**
     * 将MultipartFile类型的Excel文件转换为CSV格式的File
     *
     * @param multipartFile 上传的Excel文件
     * @return 转换后的CSV文件
     * @throws IOException 文件读写异常
     */
    public static File convertMultipartFileToCsv(MultipartFile multipartFile) throws IOException {
        // 创建临时文件以写入CSV数据
        File csvFile = File.createTempFile("converted", ".csv");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            // 读取Excel文件并处理每行数据
            EasyExcel.read(multipartFile.getInputStream(), new PageReadListener<List<String>>(dataList -> {
                for (List<String> rowData : dataList) {
                    try {
                        String csvRow = String.join(",", rowData);
                        writer.write(csvRow);
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            })).sheet().doRead();
        }
        return csvFile;
    }

    public static ExcelReadResult readExcel(MultipartFile multipartFile) throws IOException {
        final List<String> headers = new ArrayList<>();
        final List<List<String>> rowsData = new ArrayList<>();
        AnalysisEventListener<Map<Integer, String>> listener = new AnalysisEventListener<>() {
            boolean isHeader = true;

            @Override
            public void invoke(Map<Integer, String> data, AnalysisContext context) {
                if (isHeader) {
                    // 第1行作为表头
                    headers.addAll(data.values());
                    isHeader = false;
                } else {
                    rowsData.add(new HashMap<>(data).values().stream().toList());
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
            }
        };

        EasyExcel.read(multipartFile.getInputStream(), listener).sheet().doRead();
        return new ExcelReadResult(headers, rowsData);
    }

    public static void main(String[] args) {
        String filePath = "D:\\Documents\\Tencent Files\\2691386627\\FileRecv\\USLE - 副本.xlsx";
        //ExcelReadResult result = readExcel(filePath);
        //System.out.println(result);
    }

    public static class ExcelReadResult {
        private List<String> headers;
        private List<List<String>> rows;

        public ExcelReadResult(List<String> headers, List<List<String>> rows) {
            this.headers = headers;
            this.rows = rows;
        }

        public List<String> getHeaders() {
            return headers;
        }

        public void setHeaders(List<String> headers) {
            this.headers = headers;
        }

        public List<List<String>> getRows() {
            return rows;
        }

        public void setRows(List<List<String>> rows) {
            this.rows = rows;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("ExcelReadResult{\n");
            sb.append("headers=").append(headers).append(",\n");
            sb.append("rows=[\n");
            for (List<String> row : rows) {
                String rowString = row.toString();
                sb.append("   {").append(rowString).append("},\n");
            }
            sb.append("]\n}");
            return sb.toString();
        }
    }
}
    