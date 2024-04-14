package cn.edu.nwafu.common.util;


import cn.edu.nwafu.common.vo.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Huang Z.Y.
 */
public class GptUtil {
    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();
    private static String clientId = "tUcmo4ePV3iyoXZUbFYjtmff";
    private static String clientSecret = "f3a3YiGQbGwd677AEQBrkrQxBKK7ssq8";

    public static String getAccessToken(String clientId, String clientSecret) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/oauth/2.0/token?client_id=" + clientId + "&client_secret=" + clientSecret + "&grant_type=client_credentials")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        try (Response response = HTTP_CLIENT.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            String responseBody = response.body().string();
            JSONObject jsonObject = JSON.parseObject(responseBody);
            return jsonObject.getString("access_token");
        }
    }

    public static HttpResponse sendChatRequest(String content) throws IOException {
        String encodedContent = URLEncoder.encode(content, "UTF-8");
        String url = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/eb-instant?access_token="
                + getAccessToken(clientId, clientSecret);
        HashMap<String, String> msg = new HashMap<>();
        msg.put("role", "user");
        msg.put("content", content);
        ArrayList<HashMap<String, String>> messages = new ArrayList<>();
        messages.add(msg);
        HashMap<String, Object> requestBody = new HashMap<>();
        requestBody.put("messages", messages);
        String outputStr = JSON.toJSONString(requestBody);
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, outputStr);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();
        try (Response response = HTTP_CLIENT.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            String responseBody = response.body().string();
            return JSON.parseObject(responseBody, HttpResponse.class);
        }
    }
}
    