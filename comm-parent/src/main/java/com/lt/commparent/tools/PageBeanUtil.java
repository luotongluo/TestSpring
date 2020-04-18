package com.lt.commparent.tools;

import java.io.Serializable;
import java.util.Collection;

public class PageBeanUtil<Z> implements Serializable {

    /**
     * 当前页
     */
    private Integer pageIndex;

    /**
     * 每页数据量
     */
    private Integer pageSize;

    /**
     * 总数据量
     */
    private Integer pageCount;

    /**
     * 分页数据
     */
    private Collection<Z> data;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Collection<Z> getData() {
        return data;
    }

    public void setData(Collection<Z> data) {
        this.data = data;
    }
}
