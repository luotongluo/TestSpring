package com.lt.gateway.jianshutest;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: LT
 * @Date: 2019/5/21 17:23
 * @Description:
 * @Version 1.0
 */
public class GatewayPredicateDefinition {
    /**
     * 断言对应的Name
     */
    private String name;
    /**
     * 配置的断言规则
     */
    private Map<String, String> args = new LinkedHashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getArgs() {
        return args;
    }

    public void setArgs(Map<String, String> args) {
        this.args = args;
    }
}
