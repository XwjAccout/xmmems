package com.xmmems.domain;

public class Evaluation {
    private String siteName;

    private Integer siteId;

    private String waterQualityLevel;

    private String levelStandard;

    private String mainPollutant;

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getWaterQualityLevel() {
        return waterQualityLevel;
    }

    public void setWaterQualityLevel(String waterQualityLevel) {
        this.waterQualityLevel = waterQualityLevel == null ? null : waterQualityLevel.trim();
    }

    public String getLevelStandard() {
        return levelStandard;
    }

    public void setLevelStandard(String levelStandard) {
        this.levelStandard = levelStandard == null ? null : levelStandard.trim();
    }

    public String getMainPollutant() {
        return mainPollutant;
    }

    public void setMainPollutant(String mainPollutant) {
        this.mainPollutant = mainPollutant == null ? null : mainPollutant.trim();
    }
}