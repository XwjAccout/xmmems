package com.xmmems.domain.env;

public class EnvWarningGroup {
    private Integer id;

    private String groupName;

    private Integer resendNum;

    private String remark;

    private String isvalid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Integer getResendNum() {
        return resendNum;
    }

    public void setResendNum(Integer resendNum) {
        this.resendNum = resendNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(String isvalid) {
        this.isvalid = isvalid == null ? null : isvalid.trim();
    }
}