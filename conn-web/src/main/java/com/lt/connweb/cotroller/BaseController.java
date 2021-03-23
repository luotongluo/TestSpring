package com.lt.connweb.cotroller;

import com.lt.connweb.service.BaseService;
import com.lt.connweb.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tong.luo
 * @description BaseController
 * @date 2020/4/15 22:08
 */
@Controller
public class BaseController {
    @Autowired
    private BaseService baseService;

    @RequestMapping("getdruide")
    @ResponseBody
    public Map getdruide() {
        String url = "http://localhost:9101/druid";
        HashMap<String, Object> retMap = new HashMap<>();
        retMap.put("rescode", 0);
        retMap.put("resMsg", "Success");
        String request = HttpUtils.getRequest(url);

        retMap.put("msg", request);
        return retMap;
    }
}
