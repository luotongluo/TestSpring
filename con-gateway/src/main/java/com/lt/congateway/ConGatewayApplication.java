package com.lt.congateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableHystrixDashboard//展示熔断器仪表盘
@EnableCircuitBreaker    //Hystrix Dashboard必须加
@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
public class ConGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConGatewayApplication.class, args);
    }
}
