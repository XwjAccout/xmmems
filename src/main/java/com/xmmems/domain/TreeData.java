package com.xmmems.domain;

import lombok.Data;

import java.util.Map;

@Data
public class TreeData {

    private String id;
    private String pId;
    private String text;
    private String state;
    private String checked;
    private String iconCls;
    private String attributes;

    private Map<String,Object> attributeMap;
}
