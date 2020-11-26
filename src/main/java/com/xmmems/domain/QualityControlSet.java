package com.xmmems.domain;

import java.util.Date;

public class QualityControlSet {
    private Integer id;

    private Integer itemId;

    private String itemName;

    private Integer siteId;

    private String siteName;

    private String standardValue;

    private String spanValue;

    private String zeroStandardValue;

    private String spanStandardValue;

    private String toPerson;

    private Integer isvalid;

    private Integer type;
    private Date submitTime;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
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

    public String getStandardValue() {
        return standardValue;
    }

    public void setStandardValue(String standardValue) {
        this.standardValue = standardValue == null ? null : standardValue.trim();
    }

    public String getSpanValue() {
        return spanValue;
    }

    public void setSpanValue(String spanValue) {
        this.spanValue = spanValue == null ? null : spanValue.trim();
    }

    public String getZeroStandardValue() {
        return zeroStandardValue;
    }

    public void setZeroStandardValue(String zeroStandardValue) {
        this.zeroStandardValue = zeroStandardValue == null ? null : zeroStandardValue.trim();
    }

    public String getSpanStandardValue() {
        return spanStandardValue;
    }

    public void setSpanStandardValue(String spanStandardValue) {
        this.spanStandardValue = spanStandardValue == null ? null : spanStandardValue.trim();
    }

    public String getToPerson() {
        return toPerson;
    }

    public void setToPerson(String toPerson) {
        this.toPerson = toPerson == null ? null : toPerson.trim();
    }

    public Integer getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Integer isvalid) {
        this.isvalid = isvalid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }
}