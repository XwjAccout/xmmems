package com.xmmems.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class MenuDTO {
    private Integer id;
    private String name;  //模块名称
    private String code;  //菜单编码
    private String pcode;  //父级菜单编码
    private String url;  //请求路径
    private String level;  //等级 0 1 2
    private String icon;
    private BigDecimal rank;  //排序
}
