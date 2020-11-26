package com.xmmems.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@ToString
@Table(name = "simhourdata")
public class SimpleHourData {

    @Id
    @Column(name = "time")
    private Date time;              //时间
    @Id
    @Column(name = "siteId")
    private Integer siteId;              //站点id
    @Id
    @Column(name = "itemId")
    private Integer itemId;              //指标id
    @Column(name = "timeStr")
    private String timeStr;              //时间字符串
    @Column(name = "siteName")
    private String siteName;              //站点名称
    @Column(name = "itemName")
    private String itemName;              //指标名称
    @Column(name = "value")
    private String value;              //值
    @Column(name = "originValue")
    private String originValue;              //值
    @Column(name = "troubleCode")
    private String troubleCode;              //标识
    @Column(name = "troubleName")
    private String troubleName;              //标识中文意义
    @Column(name = "code")
    private String code;              //国标代码
    @Column(name = "number")
    private Integer number;              //一天测几次
    @Column(name = "preValue")
    private String preValue;              //arima预测值
    @Column(name = "preValue1")
    private String preValue1;              //算数平均预测值
    @Column(name = "preValue2")
    private String preValue2;              //加权平局预测值
    @Column(name = "preValue3")
    private String preValue3;              //一次指数平滑预测值
    @Column(name = "preValue4")
    private String preValue4;              //ar预测值
    @Column(name = "preValue5")
    private String preValue5;              //arima预测值
    @Column(name = "preValue6")
    private String preValue6;              //arima预测值
    @Column(name = "preValue7")
    private String preValue7;              //arima预测值
    @Column(name = "preValue8")
    private String preValue8;              //arima预测值
    @Column(name = "preValue9")
    private String preValue9;              //arima预测值
    @Column(name = "preValue10")
    private String preValue10;              //arima预测值
    @Column(name = "trend")
    private Integer trend;             //数据变化趋势
    @Column(name = "valueUnchanged")
    private Integer valueUnchanged;     //数据不变次数

}
