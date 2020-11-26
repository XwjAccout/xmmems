package com.xmmems.domain.base;

import java.util.Date;

public class BaseRiver {
    private Integer id;

    private String basinName;

    private String basinCode;

    private String riverName;

    private String riverCode;

    private Date createAt;

    private Date updateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBasinName() {
        return basinName;
    }

    public void setBasinName(String basinName) {
        this.basinName = basinName == null ? null : basinName.trim();
    }

    public String getBasinCode() {
        return basinCode;
    }

    public void setBasinCode(String basinCode) {
        this.basinCode = basinCode == null ? null : basinCode.trim();
    }

    public String getRiverName() {
        return riverName;
    }

    public void setRiverName(String riverName) {
        this.riverName = riverName == null ? null : riverName.trim();
    }

    public String getRiverCode() {
        return riverCode;
    }

    public void setRiverCode(String riverCode) {
        this.riverCode = riverCode == null ? null : riverCode.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}