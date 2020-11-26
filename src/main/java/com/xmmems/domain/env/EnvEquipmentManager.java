package com.xmmems.domain.env;

public class EnvEquipmentManager {
    private Integer id;

    private String name;

    private String displayName;

    private String stationName;

    private Integer stationId;

    private Integer type;

    private String directive;

    private String doubleSeq;

    private String bitSeq;

    private String status;

    private String controlFlag;

    private String warnLevel;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDirective() {
        return directive;
    }

    public void setDirective(String directive) {
        this.directive = directive == null ? null : directive.trim();
    }

    public String getDoubleSeq() {
        return doubleSeq;
    }

    public void setDoubleSeq(String doubleSeq) {
        this.doubleSeq = doubleSeq == null ? null : doubleSeq.trim();
    }

    public String getBitSeq() {
        return bitSeq;
    }

    public void setBitSeq(String bitSeq) {
        this.bitSeq = bitSeq == null ? null : bitSeq.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getControlFlag() {
        return controlFlag;
    }

    public void setControlFlag(String controlFlag) {
        this.controlFlag = controlFlag == null ? null : controlFlag.trim();
    }

    public String getWarnLevel() {
        return warnLevel;
    }

    public void setWarnLevel(String warnLevel) {
        this.warnLevel = warnLevel == null ? null : warnLevel.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}