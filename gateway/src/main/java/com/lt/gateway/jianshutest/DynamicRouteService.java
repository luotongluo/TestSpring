package com.lt.gateway.jianshutest;

import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

/**
 * @Author: LT
 * @Date: 2019/5/21 17:26
 * @Description:
 * @Version 1.0
 */
public interface DynamicRouteService extends ApplicationEventPublisherAware {
    @Override
    /**
     * 重写方法
     */
    void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher);

    /**
     * 增加路由
     */
    String add(RouteDefinition definition);

    /**
     * 更新路由
     */
    String update(RouteDefinition definition);

    /**
     * 删除路由
     */
    Mono<ResponseEntity<Object>> delete(String id);
}
