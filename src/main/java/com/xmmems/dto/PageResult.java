package com.xmmems.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private Long total;// 总条数
    private Integer totalPage;// 总页数
    private Boolean lastPage;
    private Boolean firstPage;
    private Integer pageNumber;
    private Integer pageSize;
    private List<T> rows;// 当前页数据

    public PageResult() {
    }

 /*   public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }*/

    public PageResult(Integer pageSize,Integer pageNumber, Long total, Integer totalPage, List<T> rows) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.total = total;
        this.totalPage = totalPage;
        this.rows = rows;
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