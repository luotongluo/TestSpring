package com.lt.commparent.http;

/**
 * @Title: ResultCode
 * @Package: com.leyou.enums
 * @Description: 全局错误码
 * @author: lizhui
 * @date: 2018/11/22 9:47 
 * @version: V1.0
 * <p>Company: Leyou(China) Chain Store Co.,Ltd</p>
 * <p>版权所有: Copyright©1999-2019 leyou.com. All Rights Reserved</p> 
 */
public enum ResultCode {

    /** 成功 */
    SUCCESS(0, "success"),

    /** JSON解析错误 */
    JSON_ANALYZE_ERROR(900002, "JSON解析错误"),

    /** messageID错误 */
    MESSAGE_ID_ERROR(900003, "messageID错误"),

    /** timeStamp错误 */
    TIMESTAMP_ERROR(900004, "timeStamp错误"),

    /** transactionType错误 */
    TRANSACTION_TYPE_ERROR(900005, "transactionType错误"),

    /** sign校验不通过 */
    SIGN_ERROR(900006, "sign校验不通过"),

    /** 数据库异常 */
    DATABASS_ERROR(900007, "数据库异常"),

    /** 请求数据不能为空 */
    INTERFACE_DATA_EMPTY(900008, "请求数据不能为空"),

    /** 渠道错误 */
    CHANAEL_ERROR(900009, "访问服务器失败"),

    /** 系统处理未知异常 */
    ERROR(999999, "error");

    private String name;
    private int index;

    ResultCode(int index, String name) {
        this.name = name;
        this.index = index;
    }


    public static String getName(int index) {
        for (ResultCode c : ResultCode.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
