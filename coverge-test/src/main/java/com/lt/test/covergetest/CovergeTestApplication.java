package com.lt.test.covergetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEurekaClient
@SpringBootApplication
//@EnableDiscoveryClient
public class CovergeTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovergeTestApplication.class, args);
	}

}
