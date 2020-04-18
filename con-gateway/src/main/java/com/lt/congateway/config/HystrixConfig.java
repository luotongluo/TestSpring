package com.lt.congateway.config;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author tong.luo
 * @description HystrixConfig
 * @date 2020/4/19 1:29
 */
@Component
@RequestMapping
public class HystrixConfig {
    @Resource
    private CommonConfig commonConfig;

    @RequestMapping("/sayHello")
    @HystrixCommand(fallbackMethod = "sayHelloFallback")
    public String home(@RequestParam String name) {
        return "hello, " + name + " from port:" + commonConfig.getServerPort();
    }

    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
