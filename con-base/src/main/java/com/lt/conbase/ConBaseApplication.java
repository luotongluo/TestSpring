package com.lt.conbase;

import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableHasor()
@EnableHasorWeb()
@SpringBootApplication(scanBasePackages = {"com.lt.conbase"})
@EnableDiscoveryClient
public class ConBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConBaseApplication.class, args);
    }

}
