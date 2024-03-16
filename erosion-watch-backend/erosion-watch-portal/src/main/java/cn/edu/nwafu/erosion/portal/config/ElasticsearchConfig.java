package cn.edu.nwafu.erosion.portal.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Huang Z.Y.
 */
@Slf4j
@Configuration
@Component
public class ElasticsearchConfig {
    @Value("${virtual-host}")
    private String host;

    @Bean(destroyMethod = "close")
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = null;
        try {
            // 创建Client连接对象
            String ip = host + ":9200";
            String[] ips = {ip};
            HttpHost[] httpHosts = new HttpHost[ips.length];
            for (int i = 0; i < ips.length; i++) {
                httpHosts[i] = HttpHost.create(ips[i]);
            }
            RestClientBuilder builder = RestClient.builder(httpHosts);
            client = new RestHighLevelClient(builder);
        } catch (Exception e) {
            log.error("Failed to create RestHighLevelClient: {}", e.getMessage(), e);
        }
        return client;
    }
}
    