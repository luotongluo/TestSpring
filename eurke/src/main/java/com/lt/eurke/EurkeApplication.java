package com.lt.eurke;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lt
 */
@SpringBootApplication
@EnableEurekaServer
public class EurkeApplication {
    private static Logger logger = LoggerFactory.getLogger(EurkeApplication.class);

    public static void main(String[] args) {
        logger.info("com.lt.eurke.EurkeApplication.main{}", args);
        SpringApplication.run(EurkeApplication.class, args);
    }

}
