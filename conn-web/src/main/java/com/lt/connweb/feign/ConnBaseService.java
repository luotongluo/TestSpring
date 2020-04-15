package com.lt.connweb.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author tong.luo
 * @description ConnBaseService
 * @date 2020/4/15 22:09
 */
@FeignClient("con-base")
public interface ConnBaseService {
}
