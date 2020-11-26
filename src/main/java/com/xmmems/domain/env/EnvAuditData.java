package com.xmmems.domain.env;

import java.util.Date;

public class EnvAuditData {
    private Integer id;

    private String stationName;

    private Date moniterTime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    public Date getMoniterTime() {
        return moniterTime;
    }

    public void setMoniterTime(Date moniterTime) {
        this.moniterTime = moniterTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}