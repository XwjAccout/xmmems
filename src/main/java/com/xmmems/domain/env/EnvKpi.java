package com.xmmems.domain.env;

public class EnvKpi {
    private Integer id;

    private String name;

    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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
}