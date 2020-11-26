package com.xmmems.domain.env;

import java.util.Date;

public class EnvSmsRecord {
    private Integer id;

    private String sendStatus;

    private Date addTime;

    private Date sendTime;

    private String warnType;

    private Integer warnRecordId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus == null ? null : sendStatus.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getWarnType() {
        return warnType;
    }

    public void setWarnType(String warnType) {
        this.warnType = warnType == null ? null : warnType.trim();
    }

    public Integer getWarnRecordId() {
        return warnRecordId;
    }

    public void setWarnRecordId(Integer warnRecordId) {
        this.warnRecordId = warnRecordId;
    }
}