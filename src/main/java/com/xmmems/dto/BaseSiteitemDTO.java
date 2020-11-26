package com.xmmems.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BaseSiteitemDTO {
    private Integer id;
    private Integer siteId;
    private Integer itemId;
    private String siteName;
    private String itemName;
    private Date createTime;
    private Date updateTime;
    private BigDecimal sort;
    private String isValid;
    private String minValue;
    private String maxValue;
    private String isAutoTag;
    private Integer number; //一天测几次
    private String limitNum;//检出限

    //以上代码与BaseSiteitem属性一致，以下字段自己添加的
    private String unit;  //监测项目标准单位
    private String code;  //监测项目代码

}