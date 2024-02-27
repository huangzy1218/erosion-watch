package cn.edu.nwafu.erosion.portal.config;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OSS对象存储相关配置。
 *
 * @author Huang Z.Y.
 */
@Configuration
public class OssConfig {
    @Value("${aliyun.oss.access-key-secret}")
    private static String ALIYUN_OSS_ACCESS_KEY_SECRET;
    @Value("${aliyun.oss.endpoint}")
    private static String ALIYUN_OSS_ENDPOINT;
    @Value("${aliyun.oss.access-key-id}")
    private static String ALIYUN_OSS_ACCESS_KEY_ID;

    @Bean
    public OSSClient ossClient() {
        return new OSSClient(ALIYUN_OSS_ENDPOINT, ALIYUN_OSS_ACCESS_KEY_ID, ALIYUN_OSS_ACCESS_KEY_SECRET);
    }
}
    