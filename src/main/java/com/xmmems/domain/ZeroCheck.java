package com.xmmems.domain;

import java.util.Date;

public class ZeroCheck {
    private Integer id;

    private Date genTime;

    private Integer siteId;

    private String siteName;

    private String concentration;

    private String spanvalues;

    private String checkdata;

    private String itemName;

    private Integer itemId;

    private Integer type;
    private String  unit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGenTime() {
        return genTime;
    }

    public void setGenTime(Date genTime) {
        this.genTime = genTime;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    public String getConcentration() {
        return concentration;
    }

    public void setConcentration(String concentration) {
        this.concentration = concentration == null ? null : concentration.trim();
    }

    public String getSpanvalues() {
        return spanvalues;
    }

    public void setSpanvalues(String spanvalues) {
        this.spanvalues = spanvalues == null ? null : spanvalues.trim();
    }

    public String getCheck() {
        return checkdata;
    }

    public void setCheck(String check) {
        this.checkdata = check == null ? null : check.trim();
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "ZeroCheck{" +
                "id=" + id +
                ", genTime=" + genTime +
                ", siteId=" + siteId +
                ", siteName='" + siteName + '\'' +
                ", concentration='" + concentration + '\'' +
                ", spanvalues='" + spanvalues + '\'' +
                ", checkdata='" + checkdata + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemId=" + itemId +
                ", type=" + type +
                ", unit='" + unit + '\'' +
                '}';
    }
}