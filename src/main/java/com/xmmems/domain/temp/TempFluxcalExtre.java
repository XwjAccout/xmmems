package com.xmmems.domain.temp;

public class TempFluxcalExtre {
    private Integer id;

    private String type;

    private String realVal;

    private String allowVal;

    private String subVal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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