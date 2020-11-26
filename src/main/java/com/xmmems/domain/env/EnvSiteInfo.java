package com.xmmems.domain.env;

import java.util.Date;

public class EnvSiteInfo {
    private Integer id;

    private String siteName;

    private String siteMName;

    private String operCompany;

    private String basinCode;

    private String basinName;

    private String riverCode;

    private String riverName;

    private String sectionCode;

    private String sectionName;

    private String areaCode;

    private String areaName;

    private String status;

    private String stationType;

    private String longitude;

    private String latitude;

    private Integer reportNum;

    private String reportTels;

    private Date createStationDate;

    private String levelStandard;

    private String introduction;

    private String remark;

    private String code;

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

    public String getSiteMName() {
        return siteMName;
    }

    public void setSiteMName(String siteMName) {
        this.siteMName = siteMName == null ? null : siteMName.trim();
    }

    public String getOperCompany() {
        return operCompany;
    }

    public void setOperCompany(String operCompany) {
        this.operCompany = operCompany == null ? null : operCompany.trim();
    }

    public String getBasinCode() {
        return basinCode;
    }

    public void setBasinCode(String basinCode) {
        this.basinCode = basinCode == null ? null : basinCode.trim();
    }

    public String getBasinName() {
        return basinName;
    }

    public void setBasinName(String basinName) {
        this.basinName = basinName == null ? null : basinName.trim();
    }

    public String getRiverCode() {
        return riverCode;
    }

    public void setRiverCode(String riverCode) {
        this.riverCode = riverCode == null ? null : riverCode.trim();
    }

    public String getRiverName() {
        return riverName;
    }

    public void setRiverName(String riverName) {
        this.riverName = riverName == null ? null : riverName.trim();
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode == null ? null : sectionCode.trim();
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName == null ? null : sectionName.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType == null ? null : stationType.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public Integer getReportNum() {
        return reportNum;
    }

    public void setReportNum(Integer reportNum) {
        this.reportNum = reportNum;
    }

    public String getReportTels() {
        return reportTels;
    }

    public void setReportTels(String reportTels) {
        this.reportTels = reportTels == null ? null : reportTels.trim();
    }

    public Date getCreateStationDate() {
        return createStationDate;
    }

    public void setCreateStationDate(Date createStationDate) {
        this.createStationDate = createStationDate;
    }

    public String getLevelStandard() {
        return levelStandard;
    }

    public void setLevelStandard(String levelStandard) {
        this.levelStandard = levelStandard == null ? null : levelStandard.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}