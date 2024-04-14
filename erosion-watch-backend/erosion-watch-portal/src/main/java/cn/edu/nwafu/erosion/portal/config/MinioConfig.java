package cn.edu.nwafu.erosion.portal.config;

import cn.edu.nwafu.common.service.CustomMinioClient;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Huang Z.Y.
 */
@Configuration
public class MinioConfig {
    @Value("${minio.endpoint}")
    private String ENDPOINT;
    @Value("${minio.access-key}")
    private String ACCESS_KEY;
    @Value("${minio.secret-key}")
    private String SECRET_KEY;

    @Bean
    public CustomMinioClient customMinioClient() {
        // 创建一个MinIO的Java客户端
        MinioClient minioClient = MinioClient.builder()
                .endpoint(ENDPOINT)
                .credentials(ACCESS_KEY, SECRET_KEY)
                .build();
        return new CustomMinioClient(minioClient);
    }
}
    