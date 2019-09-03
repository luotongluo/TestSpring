//package com.lt.gateway;
//
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//import java.util.Map;
//import java.util.function.Consumer;
//
//import org.gateway.response.Response;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
//import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
//import org.springframework.cloud.gateway.route.Route;
//import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//
//import com.alibaba.fastjson.JSON;
//
//import reactor.core.publisher.Mono;
///**
// * @Author: LT
// * @Date: 2019/5/21 17:09
// * @Description: springcloud gateway 为我们提供了限流过滤器RequestRateLimiterGatewayFilterFactory，
// * 和限流的实现类RedisRateLimiter使用令牌桶限流。
// * 但是官方的不一定满足我们的需求，所以我们重新写一个过滤器（基本和官方一致），只是将官方的返回报文改了
// * @Version 1.0
// */
//public class RateLimiterGatewayFilterFactory extends AbstractGatewayFilterFactory<RateLimiterGatewayFilterFactory.Config>  {
//    public static final String KEY_RESOLVER_KEY = "keyResolver";
//
//    private final RateLimiter defaultRateLimiter;
//    private final KeyResolver defaultKeyResolver;
//
//    public RateLimiterGatewayFilterFactory(RateLimiter defaultRateLimiter,
//                                           KeyResolver defaultKeyResolver) {
//        super(Config.class);
//        this.defaultRateLimiter = defaultRateLimiter;
//        this.defaultKeyResolver = defaultKeyResolver;
//    }
//
//    public KeyResolver getDefaultKeyResolver() {
//        return defaultKeyResolver;
//    }
//
//    public RateLimiter getDefaultRateLimiter() {
//        return defaultRateLimiter;
//    }
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public GatewayFilter apply(Config config) {
//        KeyResolver resolver = (config.keyResolver == null) ? defaultKeyResolver : config.keyResolver;
//        RateLimiter<Object> limiter = (config.rateLimiter == null) ? defaultRateLimiter : config.rateLimiter;
//
//        return (exchange, chain) -> {
//            Route route = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
//
//            return resolver.resolve(exchange).flatMap(key ->
//                    // TODO: if key is empty?
//                    limiter.isAllowed(route.getId(), key).flatMap(response -> {
//
//                        for (Map.Entry<String, String> header : response.getHeaders().entrySet()) {
//                            exchange.getResponse().getHeaders().add(header.getKey(), header.getValue());
//                        }
//
//                        if (response.isAllowed()) {
//                            return chain.filter(exchange);
//                        }
//                        ServerHttpResponse rs = exchange.getResponse();
//                        Response data = new Response();
//                        data.setCode("101");
//                        data.setMessage("访问过快");
//                        byte[] datas = JSON.toJSONString(data).getBytes(StandardCharsets.UTF_8);
//                        DataBuffer buffer = rs.bufferFactory().wrap(datas);
//                        rs.setStatusCode(HttpStatus.UNAUTHORIZED);
//                        rs.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
//                        return rs.writeWith(Mono.just(buffer));
//                    }));
//        };
//    }
//
//    public static class Config {
//        private KeyResolver keyResolver;
//        private RateLimiter rateLimiter;
//        private HttpStatus statusCode = HttpStatus.TOO_MANY_REQUESTS;
//
//        public KeyResolver getKeyResolver() {
//            return keyResolver;
//        }
//
//        public Config setKeyResolver(KeyResolver keyResolver) {
//            this.keyResolver = keyResolver;
//            return this;
//        }
//        public RateLimiter getRateLimiter() {
//            return rateLimiter;
//        }
//
//        public Config setRateLimiter(RateLimiter rateLimiter) {
//            this.rateLimiter = rateLimiter;
//            return this;
//        }
//
//        public HttpStatus getStatusCode() {
//            return statusCode;
//        }
//
//        public Config setStatusCode(HttpStatus statusCode) {
//            this.statusCode = statusCode;
//            return this;
//        }
//    }
//}
