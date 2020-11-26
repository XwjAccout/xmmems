package com.xmmems.domain.env;

import java.util.Date;

public class EnvRealtimeData {
    private Integer id;

    private Integer siteId;

    private String siteName;

    private Date moniterTime;

    private String content;

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

    public Date getMoniterTime() {
        return moniterTime;
    }

    public void setMoniterTime(Date moniterTime) {
        this.moniterTime = moniterTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

}