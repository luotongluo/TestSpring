package com.lt.commparent.http;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @Title: ResponseHeader
 * @Package: com.leyou.entity
 * @Description: 接口返回消息头类
 * @author: lizhui
 * @date: 2018/11/22 9:12
 * @version: V1.0
 * <p>Company: Leyou(China) Chain Store Co.,Ltd</p>
 * <p>版权所有: Copyright©1999-2019 leyou.com. All Rights Reserved</p>
 */
public class ResponseHeader extends Header implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 响应编码
	 */
	@JSONField(name="res_code")
	private Integer resCode;
	
	/**
	 * 响应消息
	 */
	@JSONField(name="message")
	private String message;
	
	public ResponseHeader(){}

	public ResponseHeader(Integer resCode, String message) {
		super();
		this.resCode = resCode;
		this.message = message;
	}

	public Integer getResCode() {
		return resCode;
	}

	public void setResCode(Integer resCode) {
		this.resCode = resCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
