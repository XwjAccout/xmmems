package com.xmmems.domain.cal;

public class CalFluxcalResultExtre {
    private Integer id;

    private String siteName;

    private String calCode;

    private String realVal;

    private String allowVal;

    private String subVal;

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

    public String getCalCode() {
        return calCode;
    }

    public void setCalCode(String calCode) {
        this.calCode = calCode == null ? null : calCode.trim();
    }

    public String getRealVal() {
        return realVal;
    }

    public void setRealVal(String realVal) {
        this.realVal = realVal == null ? null : realVal.trim();
    }

    public String getAllowVal() {
        return allowVal;
    }

    public void setAllowVal(String allowVal) {
        this.allowVal = allowVal == null ? null : allowVal.trim();
    }

    public String getSubVal() {
        return subVal;
    }

    public void setSubVal(String subVal) {
        this.subVal = subVal == null ? null : subVal.trim();
    }
}