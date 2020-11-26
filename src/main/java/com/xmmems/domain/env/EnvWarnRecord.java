package com.xmmems.domain.env;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class EnvWarnRecord {
    private Integer id;

    private Integer siteId;

    private Integer excepRecordId;

    private String siteName;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date excepTime;

    private Integer excepItemId;

    private String excepItemName;

    private String excepItemValue;

    private String warnType;

    private String excepDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getExcepRecordId() {
        return excepRecordId;
    }

    public void setExcepRecordId(Integer excepRecordId) {
        this.excepRecordId = excepRecordId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    public Date getExcepTime() {
        return excepTime;
    }

    public void setExcepTime(Date excepTime) {
        this.excepTime = excepTime;
    }

    public Integer getExcepItemId() {
        return excepItemId;
    }

    public void setExcepItemId(Integer excepItemId) {
        this.excepItemId = excepItemId;
    }

    public String getExcepItemName() {
        return excepItemName;
    }

    public void setExcepItemName(String excepItemName) {
        this.excepItemName = excepItemName == null ? null : excepItemName.trim();
    }

    public String getExcepItemValue() {
        return excepItemValue;
    }

    public void setExcepItemValue(String excepItemValue) {
        this.excepItemValue = excepItemValue == null ? null : excepItemValue.trim();
    }

    public String getWarnType() {
        return warnType;
    }

    public void setWarnType(String warnType) {
        this.warnType = warnType == null ? null : warnType.trim();
    }


    public String getExcepDesc() {
        return excepDesc;
    }

    public void setExcepDesc(String excepDesc) {
        this.excepDesc = excepDesc;
    }
}