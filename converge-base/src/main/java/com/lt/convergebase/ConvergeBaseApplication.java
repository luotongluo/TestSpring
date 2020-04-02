package com.lt.convergebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ConvergeBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvergeBaseApplication.class, args);
	}

}
