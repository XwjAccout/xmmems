package com.xmmems.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageResult1<T> {
    private Long total;// 总条数
    private Integer totalPage;// 总页数
    private Boolean lastPage;
    private Boolean firstPage;
    private Integer pageNumber;
    private Integer pageSize;
    private List<T> data;// 当前页数据
    private Integer code;
    private String msg;
    public PageResult1() {
    }

 /*   public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }*/

    public PageResult1(Integer pageSize, Integer pageNumber, Long total, Integer totalPage, List<T> data) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.total = total;
        this.totalPage = totalPage;
        this.data = data;
        if (pageNumber == 1) {
            this.firstPage = true;
        } else {
            this.firstPage = false;
        }
        if (pageNumber == totalPage) {
            this.lastPage = true;
        } else {
            this.lastPage = false;
        }
    }
}