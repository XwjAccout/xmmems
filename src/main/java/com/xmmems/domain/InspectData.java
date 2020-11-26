package com.xmmems.domain;

import java.util.Date;

public class InspectData {
    private Integer id;

    private Date genTime;

    private String instrumentValue;

    private String certificateCode;

    private String solubility;

    private String errorValue;

    private String qualified;

    private String itemName;

    private Integer itemId;

    private String flag;

    private Integer siteId;

    private String siteName;

    private String claim;

    private String unit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGenTime() {
        return genTime;
    }

    public void setGenTime(Date genTime) {
        this.genTime = genTime;
    }

    public String getInstrumentValue() {
        return instrumentValue;
    }

    public void setInstrumentValue(String instrumentValue) {
        this.instrumentValue = instrumentValue == null ? null : instrumentValue.trim();
    }

    public String getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode == null ? null : certificateCode.trim();
    }

    public String getSolubility() {
        return solubility;
    }

    public void setSolubility(String solubility) {
        this.solubility = solubility == null ? null : solubility.trim();
    }

    public String getErrorValue() {
        return errorValue;
    }

    public void setErrorValue(String errorValue) {
        this.errorValue = errorValue == null ? null : errorValue.trim();
    }

    public String getQualified() {
        return qualified;
    }

    public void setQualified(String qualified) {
        this.qualified = qualified == null ? null : qualified.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
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

    public String getClaim() {
        return claim;
    }

    public void setClaim(String claim) {
        this.claim = claim == null ? null : claim.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }
}