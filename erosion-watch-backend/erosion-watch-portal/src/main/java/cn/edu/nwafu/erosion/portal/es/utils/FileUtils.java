package cn.edu.nwafu.erosion.portal.es.utils;

import cn.edu.nwafu.erosion.portal.es.EsFileObject;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


/**
 * @author Huang Z.Y.
 */
@Slf4j
@Component
public class FileUtils {
    private static RestHighLevelClient client;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Value("${virtual-host}")
    private String host;

    public static void setClient() {
        try {
            // 创建Client连接对象
            String ip = "8.140.22.169" + ":9200";
            String[] ips = {ip};
            HttpHost[] httpHosts = new HttpHost[ips.length];
            for (int i = 0; i < ips.length; i++) {
                httpHosts[i] = HttpHost.create(ips[i]);
            }
            RestClientBuilder builder = RestClient.builder(httpHosts);
            CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("elastic", "e5nTeAjoHTTPg--WgM49")); //用户名和密码
            builder.setHttpClientConfigCallback((HttpAsyncClientBuilder httpAsyncClientBuilder) -> httpAsyncClientBuilder.setDefaultCredentialsProvider(credentialsProvider));
            client = new RestHighLevelClient(builder);
        } catch (Exception e) {
            log.error("Failed to create RestHighLevelClient: {}", e.getMessage(), e);
        }
    }

    public static byte[] getContent(File file) throws IOException {
        Path filePath = file.toPath();
        return Files.readAllBytes(filePath);
    }

    public static EsFileObject readFile(String path) throws IOException {
        // 读文件
        File file = new File(path);

        EsFileObject fileObj = new EsFileObject();
        fileObj.setName(file.getName());
        fileObj.setType(file.getName().substring(file.getName().lastIndexOf(".") + 1));

        byte[] bytes = getContent(file);

        //将文件内容转化为base64编码
        String base64 = Base64.getEncoder().encodeToString(bytes);
        fileObj.setContent(base64);

        return fileObj;
    }

    public static void upload(EsFileObject file) throws IOException {
        if (client == null) {
            setClient();
        }
        IndexRequest indexRequest = new IndexRequest("mq");

        // 上传同时，使用attachment pipline 进行提取文件
        indexRequest.source(JSON.toJSONString(file), XContentType.JSON);
        indexRequest.setPipeline("attachment");
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse);
    }

    public static List<String> searchDocumentsByKeyword(String keyword) throws IOException {
        if (client == null) {
            setClient();
        }
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder srb = new SearchSourceBuilder();
        srb.query(QueryBuilders.matchQuery("attachment.content", keyword).analyzer("ik_smart"));
        searchRequest.source(srb);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();
        Iterator<SearchHit> iterator = hits.iterator();
        Set<String> fileSet = new HashSet<>();
        while (iterator.hasNext()) {
            SearchHit hit = iterator.next();
            String documentName = hit.getSourceAsMap().get("name").toString();
            fileSet.add(documentName);
            System.out.println("Document Name: " + documentName);
        }
        return fileSet.stream().toList();
    }

    public static void show() throws IOException {
        if (client == null) {
            setClient();
        }
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder srb = new SearchSourceBuilder();
        srb.query(QueryBuilders.matchQuery("attachment.content", "那如果 C 系统现在不需要了呢").analyzer("ik_smart"));
        searchRequest.source(srb);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();
        Iterator<SearchHit> iterator = hits.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            SearchHit hit = iterator.next();
            String documentName = hit.getSourceAsMap().get("name").toString();
            log.info("Document Name: " + documentName);
        }
    }
}
    