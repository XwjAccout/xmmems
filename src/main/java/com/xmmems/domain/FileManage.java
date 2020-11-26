package com.xmmems.domain;

import java.util.Date;

public class FileManage {
    private Integer id;

    private Integer isvalid;

    private String name;

    private String type;

    private String filePath;

    private Integer rank;

    private Date createRecordTime;

    private Date updateRecordTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Integer isvalid) {
        this.isvalid = isvalid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Date getCreateRecordTime() {
        return createRecordTime;
    }

    public void setCreateRecordTime(Date createRecordTime) {
        this.createRecordTime = createRecordTime;
    }

    public Date getUpdateRecordTime() {
        return updateRecordTime;
    }

    public void setUpdateRecordTime(Date updateRecordTime) {
        this.updateRecordTime = updateRecordTime;
    }
}