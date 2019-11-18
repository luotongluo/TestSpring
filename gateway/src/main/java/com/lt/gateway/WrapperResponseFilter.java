//package com.lt.gateway;
//
//import com.alibaba.fastjson.JSON;
//import org.gateway.response.Response;
//import org.reactivestreams.Publisher;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.core.io.buffer.DataBufferFactory;
//import org.springframework.core.io.buffer.DataBufferUtils;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.nio.charset.Charset;
//
///**
// * @Author: LT
// * @Date: 2019/5/21 17:02
// * @Description: 因为网关路由的接口返回报文格式各异，并且网关也有有一些限流、认证、熔断降级的返回报文，
// * 为了统一这些报文的返回格式，网关必须要对接口的返回报文进行修改，过滤器代码如下：
// * @Version 1.0
// */
//@Component
//public class WrapperResponseFilter implements GlobalFilter, Ordered {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpResponse originalResponse = exchange.getResponse();
//        DataBufferFactory bufferFactory = originalResponse.bufferFactory();
//        ServerHttpResponseDecorator decoratedResponse = new ServerHttpResponseDecorator(originalResponse) {
//            @Override
//            public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
//                if (body instanceof Flux) {
//                    Flux<? extends DataBuffer> fluxBody = (Flux<? extends DataBuffer>) body;
//                    return super.writeWith(fluxBody.map(dataBuffer -> {
//                        // probably should reuse buffers
//                        byte[] content = new byte[dataBuffer.readableByteCount()];
//                        dataBuffer.read(content);
//                        // 释放掉内存
//                        DataBufferUtils.release(dataBuffer);
//                        String rs = new String(content, Charset.forName("UTF-8"));
//                        Response response = new Response();
//                        response.setCode("1");
//                        response.setMessage("请求成功");
//                        response.setData(rs);
//
//                        byte[] newRs = JSON.toJSONString(response).getBytes(Charset.forName("UTF-8"));
//                        //如果不重新设置长度则收不到消息。
//                        originalResponse.getHeaders().setContentLength(newRs.length);
//                        return bufferFactory.wrap(newRs);
//                    }));
//                }
//                // if body is not a flux. never got there.
//                return super.writeWith(body);
//            }
//        };
//        // replace response with decorator
//        return chain.filter(exchange.mutate().response(decoratedResponse).build());
//    }
//
//    @Override
//    public int getOrder() {
//        // -1 is response write filter, must be called before that
//        return -2;
//    }
//}
