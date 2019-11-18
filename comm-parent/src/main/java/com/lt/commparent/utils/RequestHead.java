package com.lt.commparent.utils;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * <p>Title: RequestHead</p>
 * <p>Description: 请求消息头</p>
 * <p>Company: Leyou(China) Chain Store Co.,Ltd</p>
 * <p>版权所有: Copyright©1999-2016 leyou.com. All Rights Reserved</p> 
 * @author Illidan  
 * @date 2016年5月5日 下午4:21:21 
 * @version V1.0
 */
public class RequestHead extends Header{
	
	
	@JSONField(name = "app_id")
	private String appId;

    @JSONField(name = "token")
    private String token;
	
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
