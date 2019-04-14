package com.lt.comsumor.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Lt
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class TestConnApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestConnApplication.class, args);
    }

}
