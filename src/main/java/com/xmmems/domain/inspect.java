package com.xmmems.domain;

import java.util.Date;

public class inspect {

    /**
     * 测试结果
     */
    private String nowResult;
    /**
     * 标液
     */
    private String solution;

    /**
     * 绝对
     */
    private String absoluteError;
    /**
     * 上一次
     */
    private String lastResult;
    /**
     * 里程值
     */
    private String rangev;
    /**
     * 相对
     */
    private String relativeError;
    /**
     * 是否合格1
     */
    private String qualified1;
    /**
     * 是否合格2
     */
    private String qualified2;

    private String itemName;

    private Integer itemId;
    /**
     * 保存合格范围1
     */
    private String title1;
    /**
     * 保存合格范围2
     */
    private String title2;
    //单位
    private String unit;


    public String getNowResult() {
        return nowResult;
    }

    public void setNowResult(String nowResult) {
        this.nowResult = nowResult == null ? null : nowResult.trim();
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution == null ? null : solution.trim();
    }

    public String getAbsoluteError() {
        return absoluteError;
    }

    public void setAbsoluteError(String absoluteError) {
        this.absoluteError = absoluteError == null ? null : absoluteError.trim();
    }

    public String getLastResult() {
        return lastResult;
    }

    public void setLastResult(String lastResult) {
        this.lastResult = lastResult == null ? null : lastResult.trim();
    }

    public String getRangev() {
        return rangev;
    }

    public void setRangev(String rangev) {
        this.rangev = rangev == null ? null : rangev.trim();
    }

    public String getRelativeError() {
        return relativeError;
    }

    public void setRelativeError(String relativeError) {
        this.relativeError = relativeError == null ? null : relativeError.trim();
    }

    public String getQualified1() {
        return qualified1;
    }

    public void setQualified1(String qualified1) {
        this.qualified1 = qualified1 == null ? null : qualified1.trim();
    }

    public String getQualified2() {
        return qualified2;
    }

    public void setQualified2(String qualified2) {
        this.qualified2 = qualified2 == null ? null : qualified2.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }


    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}