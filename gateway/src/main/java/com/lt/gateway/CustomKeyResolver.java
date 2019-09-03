//package com.lt.gateway;
//
//import com.alibaba.fastjson.JSON;
//import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * @Author: LT
// * @Date: 2019/5/21 17:12
// * @Description:  然后限流必须要有一个key，根据什么来进行限流，ip，接口，或者用户来进行限流，所以我们自定义一个KeyResolver
// * @Version 1.0
// */
//public class CustomKeyResolver implements KeyResolver {
//    @Override
//    public Mono<String> resolve(ServerWebExchange exchange) {
//        return Mono.just(getKey(exchange));
//    }
//
//    private Object getKey(ServerWebExchange exchange) {
//        LimitKey limitKey = new LimitKey();
//
//        limitKey.setApi(exchange.getRequest().getPath().toString());
//        limitKey.setBiz(exchange.getRequest().getQueryParams().getFirst("biz"));
//
//        return JSON.toJSONString(limitKey);
//    }
//}
