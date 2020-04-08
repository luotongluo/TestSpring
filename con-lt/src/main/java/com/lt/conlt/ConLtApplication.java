package com.lt.conlt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ConLtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConLtApplication.class, args);
	}

}
