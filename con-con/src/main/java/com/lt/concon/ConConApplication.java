package com.lt.concon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class ConConApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConConApplication.class, args);
	}

	@RequestMapping("/")
	public String home(){
		return "SUCCESS";
	}
}
