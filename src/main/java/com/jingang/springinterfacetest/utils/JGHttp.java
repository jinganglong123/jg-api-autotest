package com.jingang.springinterfacetest.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: JGHttp
 * @description: 封装的http类常用工具类方法
 * @author: LiuGang
 * @create: 2020/5/12-21:40
 **/
@Slf4j
public class JGHttp {

    /**
     * @Description: 普通Get请求（url, param, headers）
     * @Param: [url, param, headers]
     * @return: com.jingang.springinterfacetest.utils.JGhttpresult
     * @Author: LiuGang
     * @Date: 2019/8/2
     */
    public static JGHttpResult doGet(String url, Map<String, String> param, Map<String, String> headers) {
        // 创建 Httpclient 对象
//        CloseableHttpClient httpClient = null;
//        if (url.substring(0,4).equals("https")){
//            httpClient = getHttpsClient();
//        }else {
//            httpClient = HttpClients.createDefault();
//        }
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JGHttpResult jghttpresult = new JGHttpResult();
        String resultString = "";
        CloseableHttpResponse response = null;
        log.info("********开始执行doGet********");


        try {
            log.info("请求路径：" + url);
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
                log.info("入参：" + param.toString());
            }

            URI uri = builder.build();

            // 创建http Get 请求
            HttpGet httpGet = new HttpGet(uri);

            // 设置请求头
            if (headers != null) {
                for (String key : headers.keySet()) {
                    httpGet.setHeader(key, headers.get(key));
                }
            }
            for (Header header:httpGet.getAllHeaders()){
                log.info("请求头(全部)：" + header.getName() + ":" + header.getValue());
            }
            log.info("请求参数：" + builder.getQueryParams().toString());


            // 设置连接超时时间
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(10000).setConnectionRequestTimeout(1000).setSocketTimeout(10000).build();
            httpGet.setConfig(requestConfig);
            // 实现自定义DNS


            // 执行请求
            response = httpClient.execute(httpGet);


            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
            log.info("响应码：" + response.getStatusLine().getStatusCode());
            for (Header header : response.getAllHeaders()) {
                log.info("响应头：" + header.getName() + ":" + header.getValue());
            }

            log.info("响应正文：" + resultString);

            // 设置响应正文
            jghttpresult.setResponseBody(resultString);
            // 设置响应码
            jghttpresult.setResponseCode(response.getStatusLine().getStatusCode());
            // 设置响应头信息
            Header[] resultHeaders = response.getAllHeaders();
            jghttpresult.setResponseHeaders(resultHeaders);
//            log.info("##接口响应数据汇总打印：" + jghttpresult);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("=========执行doGet结束=========");
        return jghttpresult;


    }

    /**
     * @Description: 普通Get请求（url）
     * @Param: [url]
     * @return: com.jingang.springinterfacetest.utils.JGhttpresult
     * @Author: LiuGang
     * @Date: 2019/8/2
     */
    public static JGHttpResult doGet(String url) {
        return doGet(url, null, null);
    }

    /**
     * @Description: 普通Get请求（url, param）
     * @Param: [url, param]
     * @return: com.jingang.springinterfacetest.utils.JGhttpresult
     * @Author: LiuGang
     * @Date: 2019/8/2
     */
    public static JGHttpResult doGet(String url, Map<String, String> param) {
        return doGet(url, param, null);
    }

    /**
     * @Description: 普通Post请求（url, param, headers）
     * @Param: [url, param, headers]
     * @return: com.jingang.springinterfacetest.utils.JGhttpresult
     * @Author: LiuGang
     * @Date: 2019/8/2
     */
    public static JGHttpResult doPost(String url, Map<String, String> param, Map<String, String> headers) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        JGHttpResult jghttpresult = new JGHttpResult();
        log.info("********开始执行doPost********");

        try {
            // 创建Http Post 请求
            HttpPost httpPost = new HttpPost(url);
            log.info("请求路径：" + url);
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }

                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                httpPost.setEntity(entity);

            }

            // 设置请求头
            if (headers != null) {
                for (String key : headers.keySet()) {
                    httpPost.setHeader(key, headers.get(key));
                }
            }
            for (Header header : httpPost.getAllHeaders()) {
                log.info("请求头(全部)：" + header.getName() + ":" + header.getValue());
            }
            if (param != null) {
                log.info("请求正文(概括)：" + httpPost.getEntity().toString());
                log.info("请求正文(内容)：" + EntityUtils.toString(httpPost.getEntity()));

            }

            // 执行http请求
            response = httpClient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
            log.info("响应码：" + response.getStatusLine().getStatusCode());
            for (Header header : response.getAllHeaders()) {
                log.info("响应头：" + header.getName() + ":" + header.getValue());
            }
            log.info("响应正文：" + resultString);

            // 设置响应正文
            jghttpresult.setResponseBody(resultString);
            // 设置响应码
            jghttpresult.setResponseCode(response.getStatusLine().getStatusCode());
            // 设置响应头信息
            Header[] resultHeaders = response.getAllHeaders();
            jghttpresult.setResponseHeaders(resultHeaders);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("=========执行doPost结束=========");
        return jghttpresult;

    }

    /**
     * @Description: 普通Post请求(url)
     * @Param: [url]
     * @return: com.jingang.springinterfacetest.utils.JGhttpresult
     * @Author: LiuGang
     * @Date: 2019/8/2
     */
    public static JGHttpResult doPost(String url) {
        return doPost(url, null, null);
    }

    /**
     * @Description: 普通Post请求, key-value入参（url, param）
     * @Param: [url, param]
     * @return: com.jingang.springinterfacetest.utils.JGhttpresult
     * @Author: LiuGang
     * @Date: 2019/8/2
     */
    public static JGHttpResult doPost(String url, Map<String, String> param) {
        return doPost(url, param, null);
    }

    /**
     * @Description: 普通Post请求，JSON格式入参（url, json, headers）
     * @Param: [url, json, headers]
     * @return: com.jingang.springinterfacetest.utils.JGhttpresult
     * @Author: LiuGang
     * @Date: 2019/8/2
     */
    public static JGHttpResult doPostJson(String url, String json, Map<String, String> headers) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        JGHttpResult jghttpresult = new JGHttpResult();
        log.info("********开始执行doPostJson********");


        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            log.info("请求路径：" + url);
            // 设置请求头信息
            if (headers != null) {
                for (String key : headers.keySet()) {
                    httpPost.setHeader(key, headers.get(key));
                }
                log.info("请求头(手工设置)：" + headers.toString());
            }


            // 创建请求内容
//            StringEntity entity = new StringEntity(json);
//            HttpEntity entity = new StringEntity()
//            entity.setContentType("application/x-www-form-urlencoded");
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);


            // 执行http请求
            response = httpClient.execute(httpPost);

            for (Header header : httpPost.getAllHeaders()) {
                log.info("请求头(全部)：" + header.getName() + ":" + header.getValue());
            }
            log.info("请求正文(概括)：" + httpPost.getEntity().toString());
            log.info("请求正文(内容)：" + EntityUtils.toString(httpPost.getEntity()));

            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "utf-8");
            }
            // 获取响应码
            jghttpresult.setResponseCode(response.getStatusLine().getStatusCode());
            // 获取响应正文
            jghttpresult.setResponseBody(resultString);
            // 获取响应头信息
            jghttpresult.setResponseHeaders(response.getAllHeaders());

            Header[] responeHeaders = jghttpresult.getResponseHeaders();

            log.info("响应码：" + jghttpresult.getResponseCode());
            for (Header header : responeHeaders) {
                log.info("响应头：" + header.getName() + ":" + header.getValue());
            }
            log.info("响应正文：" + resultString);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        log.info("=========执行doPostJson结束=========");
        return jghttpresult;
    }

    /**
     * @Description: 普通Post请求，JSON格式入参（url, json）
     * @Param: [url, json]
     * @return: com.jingang.springinterfacetest.utils.JGhttpresult
     * @Author: LiuGang
     * @Date: 2019/8/2
     */
    public static JGHttpResult doPostJson(String url, String json) {
        return doPostJson(url, json, null);
    }

    /**
     * @Description: 普通Post请求，JSON格式入参（url, json, headers）
     * @Param: [url, json, headers]
     * @return: com.jingang.springinterfacetest.utils.JGhttpresult
     * @Author: LiuGang
     * @Date: 2019/8/6
     */
    public static JGHttpResult doPutJson(String url, String json, Map<String, String> headers) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        JGHttpResult jghttpresult = new JGHttpResult();
        log.info("********开始执行doPutJson********");


        try {
            // 创建Http Put请求
//            HttpPost httpPost = new HttpPost(url);
            HttpPut httpPut = new HttpPut(url);
            log.info("请求路径：" + url);
            // 设置请求头信息
            if (headers != null) {
                for (String key : headers.keySet()) {
                    httpPut.setHeader(key, headers.get(key));
                }
                log.info("请求头(手工设置)：" + headers.toString());
            }


            // 创建请求内容
//            StringEntity entity = new StringEntity(json);
//            HttpEntity entity = new StringEntity()
//            entity.setContentType("application/x-www-form-urlencoded");
            if (json != null) {
                StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
                httpPut.setEntity(entity);
            }


            // 执行http请求
            response = httpClient.execute(httpPut);

            for (Header header : httpPut.getAllHeaders()) {
                log.info("请求头(全部)：" + header.getName() + ":" + header.getValue());
            }
            if (json != null) {
                log.info("请求正文(概括)：" + httpPut.getEntity().toString());
                log.info("请求正文(内容)：" + EntityUtils.toString(httpPut.getEntity()));
            }


            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "utf-8");
            }
            // 获取响应码
            jghttpresult.setResponseCode(response.getStatusLine().getStatusCode());
            // 获取响应正文
            jghttpresult.setResponseBody(resultString);
            // 获取响应头信息
            jghttpresult.setResponseHeaders(response.getAllHeaders());

            Header[] responeHeaders = jghttpresult.getResponseHeaders();

            log.info("响应码：" + jghttpresult.getResponseCode());
            for (Header header : responeHeaders) {
                log.info("响应头：" + header.getName() + ":" + header.getValue());
            }
            log.info("响应正文：" + resultString);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        log.info("=========执行doPutJson结束=========");
        return jghttpresult;

    }

    public static JGHttpResult doPatchJson(String url, String json, Map<String, String> headers) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        JGHttpResult jghttpresult = new JGHttpResult();
        log.info("********开始执行doPatchJson********");


        try {
            // 创建Http Patch请求
//            HttpPost httpPost = new HttpPost(url);
            HttpPatch httpPatch = new HttpPatch(url);
            log.info("请求路径：" + url);
            // 设置请求头信息
            if (headers != null) {
                for (String key : headers.keySet()) {
                    httpPatch.setHeader(key, headers.get(key));
                }
                log.info("请求头(手工设置)：" + headers.toString());
            }


            // 创建请求内容
//            StringEntity entity = new StringEntity(json);
//            HttpEntity entity = new StringEntity()
//            entity.setContentType("application/x-www-form-urlencoded");
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPatch.setEntity(entity);


            // 执行http请求
            response = httpClient.execute(httpPatch);

            for (Header header : httpPatch.getAllHeaders()) {
                log.info("请求头(全部)：" + header.getName() + ":" + header.getValue());
            }
            log.info("请求正文(概括)：" + httpPatch.getEntity().toString());
            log.info("请求正文(内容)：" + EntityUtils.toString(httpPatch.getEntity()));

            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "utf-8");
            }
            // 获取响应码
            jghttpresult.setResponseCode(response.getStatusLine().getStatusCode());
            // 获取响应正文
            jghttpresult.setResponseBody(resultString);
            // 获取响应头信息
            jghttpresult.setResponseHeaders(response.getAllHeaders());

            Header[] responeHeaders = jghttpresult.getResponseHeaders();

            log.info("响应码：" + jghttpresult.getResponseCode());
            for (Header header : responeHeaders) {
                log.info("响应头：" + header.getName() + ":" + header.getValue());
            }
            log.info("响应正文：" + resultString);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        log.info("=========执行doPatchJson结束=========");
        return jghttpresult;

    }


    public static JGHttpResult doDelete(String url, Map<String, String> param, Map<String, String> headers) {
        // 创建 Httpclient 对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        JGHttpResult jghttpresult = new JGHttpResult();
        String resultString = "";
        CloseableHttpResponse response = null;
        log.info("********开始执行doDelete********");


        try {
            log.info("请求路径：" + url);
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();

            // 创建http Del 请求
            HttpDelete httpDelete = new HttpDelete(uri);

            // 设置请求头
            if (headers != null) {
                for (String key : headers.keySet()) {
                    httpDelete.setHeader(key, headers.get(key));
                }
            }
//            for (Header header:httpGet.getAllHeaders()){
//                log.info("请求头(全部)：" + header.getName() + ":" + header.getValue());
//            }
//            log.info("请求参数：" + builder.getQueryParams().toString());


            // 设置连接超时时间
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(10000).setConnectionRequestTimeout(1000).setSocketTimeout(10000).build();
            httpDelete.setConfig(requestConfig);


            // 执行请求
            response = httpClient.execute(httpDelete);


            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
            log.info("响应码：" + response.getStatusLine().getStatusCode());
            for (Header header : response.getAllHeaders()) {
                log.info("响应头：" + header.getName() + ":" + header.getValue());
            }

            log.info("响应正文：" + resultString);

            // 设置响应正文
            jghttpresult.setResponseBody(resultString);
            // 设置响应码
            jghttpresult.setResponseCode(response.getStatusLine().getStatusCode());
            // 设置响应头信息
            Header[] resultHeaders = response.getAllHeaders();
            jghttpresult.setResponseHeaders(resultHeaders);
//            log.info("##接口响应数据汇总打印：" + jghttpresult);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("=========执行doDelete结束=========");
        return jghttpresult;


    }

    public static JGHttpResult doDelete(String url, Map<String, String> headers) {
        return doDelete(url, null, headers);
    }


    /**
     * 获取https连接（不验证证书）
     *
     * @return
     */
    private static CloseableHttpClient getHttpsClient(){
        try {
            SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            }).build();
            //创建httpClient
            CloseableHttpClient client = HttpClients.custom().setSSLContext(sslContext).
                    setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
            return client;
        }catch (Exception e){
            log.info(e.toString());
        }
        return null;



    }

}
