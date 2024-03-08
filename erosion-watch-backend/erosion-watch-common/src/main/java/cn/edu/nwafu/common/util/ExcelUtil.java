package cn.edu.nwafu.common.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
}
    