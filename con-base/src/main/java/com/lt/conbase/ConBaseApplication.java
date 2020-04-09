package com.lt.conbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConBaseApplication.class, args);
	}

}
