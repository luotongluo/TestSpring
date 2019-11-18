//package com.lt.gateway;
//
//import com.alibaba.fastjson.JSON;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.nio.charset.StandardCharsets;
//
///**
// * @Author: LT
// * @Date: 2019/5/21 17:07
// * @Description:以下提供一个简单的认证过滤器
// * @Version 1.0
// */
//@Component
//public class AuthFilter implements GlobalFilter {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        String token = exchange.getRequest().getHeaders().getFirst("token");
//        if ("token".equals(token)) {
//            return chain.filter(exchange);
//        }
//        ServerHttpResponse response = exchange.getResponse();
//        Response data = new Response();
//        data.setCode("401");
//        data.setMessage("非法请求");
//        byte[] datas = JSON.toJSONString(data).getBytes(StandardCharsets.UTF_8);
//        DataBuffer buffer = response.bufferFactory().wrap(datas);
//        response.setStatusCode(HttpStatus.UNAUTHORIZED);
//        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
//        return response.writeWith(Mono.just(buffer));
//    }
//}
