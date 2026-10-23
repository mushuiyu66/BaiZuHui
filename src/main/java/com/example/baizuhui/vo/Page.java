package com.example.baizuhui.vo;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer total;
    private List<T> data;

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
