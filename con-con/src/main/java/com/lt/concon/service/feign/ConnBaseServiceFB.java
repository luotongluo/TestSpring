package com.lt.concon.service.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author tong.luo
 * @description ConnBaseServiceFB
 * @date 2020/4/18 18:00
 */
@Service
public class ConnBaseServiceFB implements ConnBaseService {
    private static Logger logger = LoggerFactory.getLogger(ConnBaseServiceFB.class);

    @Override
    public Map test() {
        logger.info("test-fb");
        return null;
    }

    @Override
    public Map add() {
        logger.info("add-fb");
        return null;
    }
}
