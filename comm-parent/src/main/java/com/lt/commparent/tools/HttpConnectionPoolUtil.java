package com.lt.commparent.tools;

import com.lt.commparent.http.Params;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NoHttpResponseException;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpConnectionPoolUtil {

    private static CloseableHttpClient httpClient;

    private static Logger logger = LoggerFactory.getLogger(HttpConnectionPoolUtil.class);

    static {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(2000);
        //设置并发量可以达到1000
        cm.setDefaultMaxPerRoute(1000);
        cm.setValidateAfterInactivity(2000);
        httpClient = HttpClients.custom().setConnectionManager(cm).setRetryHandler((exception, executionCount, context) -> {
            if (executionCount > 2) {
                logger.warn("Maximum tries reached for client http pool ,executionCount:{}", executionCount);
                return false;
            }
            //NoHttpResponseException 重试,连接超时重试
            if (exception instanceof NoHttpResponseException || exception instanceof ConnectTimeoutException
            ) {
                logger.warn("NoHttpResponseException on " + executionCount + " call");
                return true;
            }
            return false;
        }).build();
    }

    /**
     * 支付post接口
     *
     * @param url
     * @param reqBody
     * @return
     */
    public static String sendPost(String url, String reqBody) {
        return sendPost(url, reqBody, Params.CONNECT_TIME_OUT, Params.CONNECT_TIME_OUT + Params.SO_TIME_OUT, Params.SO_TIME_OUT);
    }

    /**
     * 设置超时参数
     *
     * @param connectTimeOut
     * @param requestTimeOut
     * @param soTimeOut
     * @return
     */
    public static RequestConfig requestConfig(int connectTimeOut, int requestTimeOut, int soTimeOut) {
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connectTimeOut).setConnectionRequestTimeout(requestTimeOut).
                setSocketTimeout(soTimeOut).build();
        return requestConfig;
    }

    /**
     * post 请求
     *
     * @param url
     * @param reqBody
     * @param soTimeOut 读取超时时间，毫秒
     */
    public static String sendPost(String url, String reqBody, int connectTimeOut, int requestTimeOut, int soTimeOut) {
        // 创建httppost
        HttpPost httpPost = new HttpPost(url);
        String resContent = null;
        CloseableHttpResponse httpResponse = null;
        try {
            StringEntity stringEntity = new StringEntity(reqBody, Params.CHARSET);
            stringEntity.setContentEncoding(Params.CHARSET);
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            //设置超时时间
            httpPost.setConfig(requestConfig(connectTimeOut, requestTimeOut, soTimeOut));
            logger.info("发送Post请求参数：{}", reqBody);
            httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            logger.info("相应状态：{}", statusCode);
            if (HttpStatus.SC_OK == statusCode) {
                resContent = EntityUtils.toString(httpResponse.getEntity(), Params.CHARSET);
                logger.info("接收到的返回参数：{}", resContent);
            }

        } catch (ClientProtocolException e) {
            logger.error("send Post ClientProtocolException ", e);
        } catch (IOException e) {
            logger.error("send Post IOException ", e);
        } finally {
            // 关闭连接,释放资源
            try {
                if (null != httpResponse) {
                    httpResponse.close();
                }
            } catch (IOException e) {
                logger.error("send Post IOException ", e);
            }
        }
        return resContent;
    }

    public static String sendGet(String url) {
        return sendGet(url, Params.CONNECT_TIME_OUT, Params.CONNECT_TIME_OUT + Params.SO_TIME_OUT, Params.SO_TIME_OUT);
    }

    public static String sendGet(String url, int connectTimeOut, int requestTimeOut, int soTimeOut) {
        String respBody = null;
        CloseableHttpResponse response = null;
        try {
            // 创建httpget.
            HttpGet httpget = new HttpGet(url);
            logger.info("发送httpGet请求参数： " + httpget.getURI());
            // 执行get请求.
            httpget.setConfig(requestConfig(connectTimeOut, requestTimeOut, soTimeOut));
            response = httpClient.execute(httpget);

            // 获取响应实体
            HttpEntity entity = response.getEntity();
            // 打印响应状态
            System.out.println(response.getStatusLine());
            if (entity != null) {
                respBody = EntityUtils.toString(entity);
                // 打印响应内容
                logger.info("接受httpGet返回参数: "
                        + respBody);
            }
        } catch (ClientProtocolException e) {
            logger.error("send Get ClientProtocolException ", e);
        } catch (ParseException e) {
            logger.error("send Get ParseException ", e);
        } catch (IOException e) {
            logger.error("send Get IOException ", e);
        } finally {
            // 关闭连接,释放资源
            try {
                if (null != response) {
                    response.close();
                }
            } catch (IOException e) {
                logger.error("send Get IOException ", e);
            }
        }
        return respBody;
    }


}
