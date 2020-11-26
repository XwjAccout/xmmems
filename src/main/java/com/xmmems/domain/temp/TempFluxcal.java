package com.xmmems.domain.temp;

public class TempFluxcal {
    private Integer id;

    private String seqTime;

    private String allowVal;

    private String realVal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeqTime() {
        return seqTime;
    }

    public void setSeqTime(String seqTime) {
        this.seqTime = seqTime == null ? null : seqTime.trim();
    }

    public String getAllowVal() {
        return allowVal;
    }

    public void setAllowVal(String allowVal) {
        this.allowVal = allowVal == null ? null : allowVal.trim();
    }

    public String getRealVal() {
        return realVal;
    }

    public void setRealVal(String realVal) {
        this.realVal = realVal == null ? null : realVal.trim();
    }
}