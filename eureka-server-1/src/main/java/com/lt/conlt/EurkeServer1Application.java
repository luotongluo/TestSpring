package com.lt.conlt;

//import com.lt.commparent.http.ResultCode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurkeServer1Application {

    //	static{
//		System.out.println(ResultCode.ERROR.getIndex());
//	}
    public static void main(String[] args) {
        SpringApplication.run(EurkeServer1Application.class, args);
    }

}
