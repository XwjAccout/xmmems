package com.xmmems.domain.env;

public class EnvWarningRule {
    private Integer id;

    private Integer siteId;

    private String siteName;

    private Integer itemId;

    private String itemName;

    private Integer typeId;

    private String typeName;

    private Integer rangeTypeId;

    private String rangeTypeName;

    private String rangeMin;

    private String rangeMax;

    private Integer repeatNum;

    private String isUsed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getRangeTypeId() {
        return rangeTypeId;
    }

    public void setRangeTypeId(Integer rangeTypeId) {
        this.rangeTypeId = rangeTypeId;
    }

    public String getRangeTypeName() {
        return rangeTypeName;
    }

    public void setRangeTypeName(String rangeTypeName) {
        this.rangeTypeName = rangeTypeName == null ? null : rangeTypeName.trim();
    }

    public String getRangeMin() {
        return rangeMin;
    }

    public void setRangeMin(String rangeMin) {
        this.rangeMin = rangeMin == null ? null : rangeMin.trim();
    }

    public String getRangeMax() {
        return rangeMax;
    }

    public void setRangeMax(String rangeMax) {
        this.rangeMax = rangeMax == null ? null : rangeMax.trim();
    }

    public Integer getRepeatNum() {
        return repeatNum;
    }

    public void setRepeatNum(Integer repeatNum) {
        this.repeatNum = repeatNum;
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed == null ? null : isUsed.trim();
    }
}