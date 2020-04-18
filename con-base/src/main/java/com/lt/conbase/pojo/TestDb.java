package com.lt.conbase.pojo;

import java.util.Date;

/**
 * @author tong.luo
 * @description TestDb
 * @date 2020/4/18 17:09
 */
public class TestDb {
    private String name;
    private String doSomtthing;
    private Date createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoSomtthing() {
        return doSomtthing;
    }

    public void setDoSomtthing(String doSomtthing) {
        this.doSomtthing = doSomtthing;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
