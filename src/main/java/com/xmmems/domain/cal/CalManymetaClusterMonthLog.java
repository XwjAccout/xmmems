package com.xmmems.domain.cal;

import java.util.Date;

public class CalManymetaClusterMonthLog {
    private Integer id;

    private String siteName;

    private String calTime;

    private String kpiName;

    private String calCode;

    private Date startTime;

    private Date endTime;

    private String handleUser;

    private String filePath;

    private Integer qnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    public String getCalTime() {
        return calTime;
    }

    public void setCalTime(String calTime) {
        this.calTime = calTime == null ? null : calTime.trim();
    }

    public String getKpiName() {
        return kpiName;
    }

    public void setKpiName(String kpiName) {
        this.kpiName = kpiName == null ? null : kpiName.trim();
    }

    public String getCalCode() {
        return calCode;
    }

    public void setCalCode(String calCode) {
        this.calCode = calCode == null ? null : calCode.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getHandleUser() {
        return handleUser;
    }

    public void setHandleUser(String handleUser) {
        this.handleUser = handleUser == null ? null : handleUser.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public Integer getQnum() {
        return qnum;
    }

    public void setQnum(Integer qnum) {
        this.qnum = qnum;
    }
}