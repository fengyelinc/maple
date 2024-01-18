package com.cc.backend.common.utils;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.StringJoiner;

@Component
public class FileUploadUtils {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadUtils.class);

    /**
     * cookie转换
     *
     * @param cookie
     * @param delimiter 分隔符
     * @return
     */
    public String convertCookie(String cookie, String delimiter) {
        JSONArray jsonArray = JSONUtil.parseArray(cookie);
        StringJoiner joiner = new StringJoiner(delimiter);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String concat = jsonObject.getStr("name").concat("=").concat(jsonObject.getStr("value"));
            joiner.add(concat);
        }
        return joiner.toString();
    }

    /**
     * 发送文件并获取返回结果（form-date）
     * @param file 要发送的文件
     * @return 返回结果列表
     * @throws IOException 如果发生IO异常
     */
    public JSONObject send(MultipartFile file) throws IOException {
        // 创建HttpClient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
            // 设置请求目标URL
            String targetUrl = "http://localhost:9090/api/padddleOcr";
            logger.info("ORC请求url:{}", targetUrl);

            // 准备要上传的文件
            // 将MultipartFile转存为临时文件，因为HttpClient需要一个File对象
            File tempFile = File.createTempFile("tempfile", null);
            file.transferTo(tempFile);

            // 检查文件是否存在
            if (tempFile.exists() && tempFile.isFile()) {
                // 创建HttpPost对象
                HttpPost httpPost = new HttpPost(targetUrl);

                // 构建Multipart/form-data实体
                HttpEntity multipart = MultipartEntityBuilder.create()
                        .addPart("file", new FileBody(tempFile, ContentType.DEFAULT_BINARY))  // 添加文件部分
                        .build();

                // 设置请求实体
                httpPost.setEntity(multipart);

                // 执行POST请求
                CloseableHttpResponse response = httpClient.execute(httpPost);

                try {
                    // 处理响应
                    logger.info("请求结果状态码:{}", response.getStatusLine().getStatusCode());
                    HttpEntity entity = response.getEntity();
                    String str = EntityUtils.toString(entity);
                    logger.info("请求结果:{}", str);

                    // 解析返回结果
                    JSONObject jsonObject = JSONUtil.parseObj(str);
                    return jsonObject;

                } finally {
                    // 关闭响应
                    response.close();
                }
            } else {
                logger.info("File not found or is not a regular file.");
                return null;
            }
        } finally {
            // 关闭HttpClient连接管理器
            httpClient.close();
        }
    }

    /**
     * 发送get请求
     * @param params
     * @return
     */
    private boolean sendGet(String  params) {
        boolean flag = false;
        String convertCookie = convertCookie(params, ";");
        try {
            String result = HttpRequest.get("https://snail.cls.cn/snailapi/article?status=&pageNum=1&pageSize=10")
                    .header("Cookie", convertCookie)
                    .execute().body();
            JSONObject entries = JSONUtil.parseObj(result);
            if (entries != null) {
                flag =   entries.containsKey("count");
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 发送post请求
     * @param params
     * @return
     */
    public JSONObject sendPost(String params){
        String convertCookie = convertCookie(params, ";");

        JSONObject param = JSONUtil.createObj();
        param.set("text", "test");
        param.set("textType", 4);


        String body = HttpRequest.post("https://www.ximalaya.com/reform-upload/common/textCheck/standard")
                .header("Cookie", convertCookie)
                .header("Referer", "https://www.ximalaya.com/reform-upload/page/webCenter/upload")
                .body(param.toString())
                .execute().body();
        JSONObject entries = JSONUtil.parseObj(body);

        return entries;
    }



}

