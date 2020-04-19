package com.lt.congateway.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tong.luo
 * @description TestFallBbackProvider
 * @date 2020/4/18 23:36
 */
@Component
public class TestFallBbackProvider implements FallbackProvider {
    private static Logger logger = LoggerFactory.getLogger(TestFallBbackProvider.class);

    /**
     * return - 返回fallback处理哪一个服务。返回的是服务的名称
     * 推荐 - 为指定的服务定义特性化的fallback逻辑。
     * 推荐 - 提供一个处理所有服务的fallback逻辑。
     * 好处 - 服务某个服务发生超时，那么指定的fallback逻辑执行。如果有新服务上线，未提供fallback逻辑，有一个通用的。
     */
    @Override
    public String getRoute() {
//        return "springcloud-ms-member";//指定 可熔断某个服务 服务名是配置文件中配置的各服务的serviceId
        return "*";//指定    可熔断所有服务
    }

    /**
     * 指定  熔断后返回的定制化内容
     *
     * @param route
     * @param cause
     * @return
     */
//    @Override
//    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
//        return new ClientHttpResponse() {
//            @Override
//            public HttpStatus getStatusCode() throws IOException {
//                return HttpStatus.OK;
//            }
//
//            @Override
//            public int getRawStatusCode() throws IOException {
//                return 200;
//            }
//
//            @Override
//            public String getStatusText() throws IOException {
//                return "OK";
//            }
//
//            @Override
//            public void close() {
//
//            }
//
//            /**
//             * 设置响应体
//             * @return
//             * @throws IOException
//             */
//            @Override
//            public InputStream getBody() throws IOException {
//                //TODO 此处可以做日志记录
////                UniVerResponse uniVerResponse = new UniVerResponse();
////                uniVerResponse.beFalse3(route+"服务凉凉了",UniVerResponse.ERROR_BUSINESS);
////                return new ByteArrayInputStream(JSON.toJSONString(uniVerResponse).getBytes());
//                return new ByteArrayInputStream(JSON.toJSONString("uniVerResponse").getBytes());
//            }
//
//            /**
//             * 设置响应头信息
//             * @return
//             */
//            @Override
//            public HttpHeaders getHeaders() {
//                HttpHeaders headers = new HttpHeaders();
//                headers.setContentType(MediaType.APPLICATION_JSON);//指定响应体 格式+编码方式
//                return headers;
//            }
//        };
//    }


    /**
     * fallback逻辑。在早期版本中使用。
     * Edgware版本之后，ZuulFallbackProvider接口过期，提供了新的子接口FallbackProvider
     * 子接口中提供了方法ClientHttpResponse fallbackResponse(Throwable cause)。
     * 优先调用子接口新定义的fallback处理逻辑。
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        logger.info("ClientHttpResponse fallbackResponse()");

        Map<String, Object> data = new HashMap<>();
        data.put("header", "null");
        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("code", 99999);
        bodyMap.put("msg", "服务访问超时");
        data.put("body", bodyMap);

        ObjectMapper mapper = new ObjectMapper();

        String msg = "";
        try {
            msg = mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            logger.error("JsonProcessingException", e);
            msg = "";
        }
        ClientHttpResponse clientHttpResponse = this.executeFallback(HttpStatus.OK, msg,
                "application", "json", "utf-8");
        return clientHttpResponse;
    }

    /**
     * 具体处理过程。
     *
     * @param status       容错处理后的返回状态，如200正常GET请求结果，201正常POST请求结果，404资源找不到错误等。
     *                     使用spring提供的枚举类型对象实现。HttpStatus
     * @param contentMsg   自定义的响应内容。就是反馈给客户端的数据。
     * @param mediaType    响应类型，是响应的主类型， 如： application、text、media。
     * @param subMediaType 响应类型，是响应的子类型， 如： json、stream、html、plain、jpeg、png等。
     * @param charsetName  响应结果的字符集。这里只传递字符集名称，如： utf-8、gbk、big5等。
     * @return ClientHttpResponse 就是响应的具体内容。
     * 相当于一个HttpServletResponse。
     */
    private final ClientHttpResponse executeFallback(final HttpStatus status,
                                                     String contentMsg,
                                                     String mediaType,
                                                     String subMediaType,
                                                     String charsetName) {
        return new ClientHttpResponse() {

            /**
             * 设置响应的头信息
             */
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders header = new HttpHeaders();
                MediaType mt = new MediaType(mediaType, subMediaType, Charset.forName(charsetName));
                header.setContentType(mt);
                return header;
            }

            /**
             * 设置响应体
             * zuul会将本方法返回的输入流数据读取，并通过HttpServletResponse的输出流输出到客户端。
             */
            @Override
            public InputStream getBody() throws IOException {
                String content = contentMsg;
                return new ByteArrayInputStream(content.getBytes());
            }

            /**
             * ClientHttpResponse的fallback的状态码 返回String
             */
            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            /**
             * ClientHttpResponse的fallback的状态码 返回HttpStatus
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return status;
            }

            /**
             * ClientHttpResponse的fallback的状态码 返回int
             */
            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            /**
             * 回收资源方法
             * 用于回收当前fallback逻辑开启的资源对象的。
             * 不要关闭getBody方法返回的那个输入流对象。
             */
            @Override
            public void close() {
            }
        };
    }
}
