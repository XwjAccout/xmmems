package com.xmmems.domain.cal;

public class CalTimeseqResult {
    private Integer id;

    private String siteName;

    private String calCode;

    private String seqTime;

    private String predictionVal;

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

    public String getSeqTime() {
        return seqTime;
    }

    public void setSeqTime(String seqTime) {
        this.seqTime = seqTime == null ? null : seqTime.trim();
    }

    public String getPredictionVal() {
        return predictionVal;
    }

    public void setPredictionVal(String predictionVal) {
        this.predictionVal = predictionVal == null ? null : predictionVal.trim();
    }
}