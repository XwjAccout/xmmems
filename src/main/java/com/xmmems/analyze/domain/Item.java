package com.xmmems.analyze.domain;

import lombok.Data;

/**
 * 跟历史数据里面成content字段监测项目数据一一对应
 */
@Data
public class Item {
    private String itemId;
    private String itemName;
    private String troubleCode;
    private String value;
    private String originValue;
    private String troubleName;
    private String code;
}