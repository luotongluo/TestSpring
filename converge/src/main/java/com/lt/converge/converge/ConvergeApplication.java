package com.lt.converge.converge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
//@EnableHystrix
@SpringBootApplication
public class ConvergeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvergeApplication.class, args);
	}

}
