package com.xmmems.domain.base;

import java.util.Date;

public class BaseItem {
    private Integer id;

    private String code;

    private String name;

    private String typeName;

    private Integer typeId;

    private String shortName;

    private String inteShortName;

    private String validUpperLimit;

    private String validLowerLimit;

    private String outUpperLimit;

    private String outLowerLimit;

    private String unit;

    private Integer digits;

    private String maxRange;

    private String minRange;

    private Date createTime;

    private Date updateTime;

    private Integer rank;

    private String isvalid;

    private Integer zeroSolution;

    private Integer spanSolution;

    private Integer zeroSpan;

    private Integer spanSpan;

    private Double zeroAbsError;

    private Double zeroRelaError;

    private Double spanRelaError1;

    private Double spanRelaError2;

    private String often;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public String getInteShortName() {
        return inteShortName;
    }

    public void setInteShortName(String inteShortName) {
        this.inteShortName = inteShortName == null ? null : inteShortName.trim();
    }

    public String getValidUpperLimit() {
        return validUpperLimit;
    }

    public void setValidUpperLimit(String validUpperLimit) {
        this.validUpperLimit = validUpperLimit == null ? null : validUpperLimit.trim();
    }

    public String getValidLowerLimit() {
        return validLowerLimit;
    }

    public void setValidLowerLimit(String validLowerLimit) {
        this.validLowerLimit = validLowerLimit == null ? null : validLowerLimit.trim();
    }

    public String getOutUpperLimit() {
        return outUpperLimit;
    }

    public void setOutUpperLimit(String outUpperLimit) {
        this.outUpperLimit = outUpperLimit == null ? null : outUpperLimit.trim();
    }

    public String getOutLowerLimit() {
        return outLowerLimit;
    }

    public void setOutLowerLimit(String outLowerLimit) {
        this.outLowerLimit = outLowerLimit == null ? null : outLowerLimit.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Integer getDigits() {
        return digits;
    }

    public void setDigits(Integer digits) {
        this.digits = digits;
    }

    public String getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(String maxRange) {
        this.maxRange = maxRange == null ? null : maxRange.trim();
    }

    public String getMinRange() {
        return minRange;
    }

    public void setMinRange(String minRange) {
        this.minRange = minRange == null ? null : minRange.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(String isvalid) {
        this.isvalid = isvalid == null ? null : isvalid.trim();
    }

    public Integer getZeroSolution() {
        return zeroSolution;
    }

    public void setZeroSolution(Integer zeroSolution) {
        this.zeroSolution = zeroSolution;
    }

    public Integer getSpanSolution() {
        return spanSolution;
    }

    public void setSpanSolution(Integer spanSolution) {
        this.spanSolution = spanSolution;
    }

    public Integer getZeroSpan() {
        return zeroSpan;
    }

    public void setZeroSpan(Integer zeroSpan) {
        this.zeroSpan = zeroSpan;
    }

    public Integer getSpanSpan() {
        return spanSpan;
    }

    public void setSpanSpan(Integer spanSpan) {
        this.spanSpan = spanSpan;
    }

    public Double getZeroAbsError() {
        return zeroAbsError;
    }

    public void setZeroAbsError(Double zeroAbsError) {
        this.zeroAbsError = zeroAbsError;
    }

    public Double getZeroRelaError() {
        return zeroRelaError;
    }

    public void setZeroRelaError(Double zeroRelaError) {
        this.zeroRelaError = zeroRelaError;
    }

    public Double getSpanRelaError1() {
        return spanRelaError1;
    }

    public void setSpanRelaError1(Double spanRelaError1) {
        this.spanRelaError1 = spanRelaError1;
    }

    public Double getSpanRelaError2() {
        return spanRelaError2;
    }

    public void setSpanRelaError2(Double spanRelaError2) {
        this.spanRelaError2 = spanRelaError2;
    }

    public String getOften() {
        return often;
    }

    public void setOften(String often) {
        this.often = often == null ? null : often.trim();
    }
}