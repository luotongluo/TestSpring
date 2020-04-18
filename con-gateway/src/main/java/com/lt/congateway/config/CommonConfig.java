package com.lt.congateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author tong.luo
 * @description CommonConfig
 * @date 2020/4/19 1:28
 */
@RefreshScope
@Component
public class CommonConfig {
    @Value("${server.port}")
    private Integer serverPort;

    public Integer getServerPort() {
        return serverPort;
    }
}
