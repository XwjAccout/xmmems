package com.xmmems.dto;

import lombok.Data;

//具体数据零点核查数据
@Data
public class Specific{
    private String nowResult;
    private String solution;
    private String absoluteError;
    private String lastResult;
    private String rangev;
    private String relativeError;
    private String qualified1;
    private String qualified2;
    private String itemName;
    private Integer itemId;
    private String title1;
    private String title2;
    private String unit;
}