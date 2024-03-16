package cn.edu.nwafu.erosion.portal.es.utils;

import cn.edu.nwafu.erosion.portal.es.EsFileObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Huang Z.Y.
 */
@Slf4j
@Component
class FileUtilsTest {
    @Test
    void uploadTest() throws IOException {
        EsFileObject object = FileUtils.readFile("D:\\Desktop\\MQ.pdf");
        FileUtils.upload(object);
    }

    @Test
    void showTest() throws IOException {
        FileUtils.show();
    }
}