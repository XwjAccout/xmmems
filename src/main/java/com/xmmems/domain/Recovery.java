package com.xmmems.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Recovery {
    private Integer itemId;
    private String itemName;
    private String after;//加标后样品测定结果
    private String last;//加标前样品测定结果
    private String solution;// 加标液浓度
    private String plusScalar;//加标体积
    private String waterVolume;//样品体积
    private String qualification;//合格情况
    private String recoveryRate;//加标回收率
    private Date waterTime;//加标前水样测试数据时间
}
