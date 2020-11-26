package com.xmmems.domain.env;

import java.math.BigDecimal;

public class EnvWarningRuleSudden {
    private Integer id;

    private Integer siteId;

    private String siteName;

    private BigDecimal percent;

    private String isUsed;

    private Integer maxHourId;

    private String itemContent;

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

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed == null ? null : isUsed.trim();
    }

    public Integer getMaxHourId() {
        return maxHourId;
    }

    public void setMaxHourId(Integer maxHourId) {
        this.maxHourId = maxHourId;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent == null ? null : itemContent.trim();
    }
}