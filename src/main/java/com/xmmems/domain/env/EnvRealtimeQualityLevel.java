package com.xmmems.domain.env;

import java.util.Date;

public class EnvRealtimeQualityLevel {
    private Integer id;

    private String siteName;

    private String sectionName;

    private String areaName;

    private String goalQualityLevel;

    private String realQualityLevel;

    private String status;

    private String firstPollutant;

    private String online;

    private Date moniterTime;

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

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName == null ? null : sectionName.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getGoalQualityLevel() {
        return goalQualityLevel;
    }

    public void setGoalQualityLevel(String goalQualityLevel) {
        this.goalQualityLevel = goalQualityLevel == null ? null : goalQualityLevel.trim();
    }

    public String getRealQualityLevel() {
        return realQualityLevel;
    }

    public void setRealQualityLevel(String realQualityLevel) {
        this.realQualityLevel = realQualityLevel == null ? null : realQualityLevel.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getFirstPollutant() {
        return firstPollutant;
    }

    public void setFirstPollutant(String firstPollutant) {
        this.firstPollutant = firstPollutant == null ? null : firstPollutant.trim();
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online == null ? null : online.trim();
    }

    public Date getMoniterTime() {
        return moniterTime;
    }

    public void setMoniterTime(Date moniterTime) {
        this.moniterTime = moniterTime;
    }
}