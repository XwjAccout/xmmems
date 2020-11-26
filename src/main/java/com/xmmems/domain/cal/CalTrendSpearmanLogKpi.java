package com.xmmems.domain.cal;

import java.util.Date;

public class CalTrendSpearmanLogKpi {
    private Integer id;

    private String calCode;

    private Integer kpiId;

    private String kpiName;

    private String kpiShortName;

    private String kpiUnit;

    private Integer rank;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalCode() {
        return calCode;
    }

    public void setCalCode(String calCode) {
        this.calCode = calCode == null ? null : calCode.trim();
    }

    public Integer getKpiId() {
        return kpiId;
    }

    public void setKpiId(Integer kpiId) {
        this.kpiId = kpiId;
    }

    public String getKpiName() {
        return kpiName;
    }

    public void setKpiName(String kpiName) {
        this.kpiName = kpiName == null ? null : kpiName.trim();
    }

    public String getKpiShortName() {
        return kpiShortName;
    }

    public void setKpiShortName(String kpiShortName) {
        this.kpiShortName = kpiShortName == null ? null : kpiShortName.trim();
    }

    public String getKpiUnit() {
        return kpiUnit;
    }

    public void setKpiUnit(String kpiUnit) {
        this.kpiUnit = kpiUnit == null ? null : kpiUnit.trim();
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}