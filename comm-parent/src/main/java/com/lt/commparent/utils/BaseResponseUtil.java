package com.lt.commparent.utils;

/**
 * @Title: BaseResponseUtil
 * @Package: com.leyou.apollo.framework
 * @Description: 基础服务返回信息工具类
 * @author: lizhui
 * @date: 2019/2/27 11:23
 * @version: V1.0
 * <p>Company: Leyou(China) Chain Store Co.,Ltd</p>
 * <p>版权所有: Copyright©1999-2019 leyou.com. All Rights Reserved</p>
 */
public class BaseResponseUtil {

    public static <T> BaseResponse<T> getBaseResponse(T data){
         return getErrorBaseResponse(BaseResultCode.SUCCESS.getIndex(),BaseResultCode.SUCCESS.getName(),data);
    }

    public static <T> BaseResponse<T> getErrorBaseResponse(int resCode,String message,T data){
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setResCode(resCode);
        baseResponse.setMessage(message);
        baseResponse.setData(data);
        return baseResponse;
    }

    public static void main(String[] args) {

    }
}
