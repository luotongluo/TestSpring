package com.lt.congateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author luotong
 * @description UriConfiguration
 * @date 2020/4/13 11:16
 */
@ConfigurationProperties
public class UriConfiguration {
    private String httpbin = "http://httpbin.org:80";

    public String getHttpbin() {
        return httpbin;
    }

    public void setHttpbin(String httpbin) {
        this.httpbin = httpbin;
    }
}
