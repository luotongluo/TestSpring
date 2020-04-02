package com.lt.eurke;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LT
 * @date 2019.4.14
 */
@SpringBootApplication
@EnableEurekaServer
@RestController
public class EurkeApplication {
    private static Logger logger = LoggerFactory.getLogger(EurkeApplication.class);

    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }


    public static void main(String[] args) {
        logger.info("com.lt.eurke.EurkeApplication.main{}", args);
        SpringApplication.run(EurkeApplication.class, args);
    }

}
