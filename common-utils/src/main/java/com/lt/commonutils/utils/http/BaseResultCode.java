package com.lt.commonutils.utils.http;

public enum BaseResultCode {

    /**
     * 成功
     */
    SUCCESS(0, "success"),

    /**
     * 参数不能为空
     */
    PARAMETER_NOT_EMPTY(-1, "参数不能为空"),

    /**
     * 失败
     */
    ERROR(-2, "error"),
    ;

    private String name;
    private int index;

    BaseResultCode(int index, String name) {
        this.name = name;
        this.index = index;
    }


    public static String getName(int index) {
        for (BaseResultCode c : BaseResultCode.values()) {
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
