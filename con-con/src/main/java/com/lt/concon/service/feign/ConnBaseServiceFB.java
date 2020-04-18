package com.lt.concon.service.feign;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author tong.luo
 * @description ConnBaseServiceFB
 * @date 2020/4/18 18:00
 */
@Service
public class ConnBaseServiceFB implements ConnBaseService {
    @Override
    public Map test() {
        System.out.println("test-fb");
        return null;
    }

    @Override
    public Map add() {
        System.out.println("add-fb");
        return null;
    }
}
