package com.lt.commparent.utils;

public class BaseResponseUtil {

    public static <T> BaseResponse<T> getBaseResponse(T data) {
        return getErrorBaseResponse(BaseResultCode.SUCCESS.getIndex(), BaseResultCode.SUCCESS.getName(), data);
    }

    public static <T> BaseResponse<T> getErrorBaseResponse(int resCode, String message, T data) {
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setResCode(resCode);
        baseResponse.setMessage(message);
        baseResponse.setData(data);
        return baseResponse;
    }

    public static void main(String[] args) {

    }
}
