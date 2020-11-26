package com.xmmems.domain;

import java.util.Date;

public class EnvWarningDataLoss {
    private Integer id;

    private Integer siteId;

    private String siteName;

    private String warnHour;

    private String warnTime;

    private String isUsed;

    private Date createAt;

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

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    public String getWarnHour() {
        return warnHour;
    }

    public void setWarnHour(String warnHour) {
        this.warnHour = warnHour == null ? null : warnHour.trim();
    }

    public String getWarnTime() {
        return warnTime;
    }

    public void setWarnTime(String warnTime) {
        this.warnTime = warnTime == null ? null : warnTime.trim();
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed == null ? null : isUsed.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}