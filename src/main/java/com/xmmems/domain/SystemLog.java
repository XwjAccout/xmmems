package com.xmmems.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SystemLog {
    private Integer id;

    private String requestip;

    private String type;

    private String userid;

    private String description;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date actiondate;

    private String exceptioncode;

    private String actionmethod;

    private String params;

    private String exceptiondetail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequestip() {
        return requestip;
    }

    public void setRequestip(String requestip) {
        this.requestip = requestip == null ? null : requestip.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getActiondate() {
        return actiondate;
    }

    public void setActiondate(Date actiondate) {
        this.actiondate = actiondate;
    }

    public String getExceptioncode() {
        return exceptioncode;
    }

    public void setExceptioncode(String exceptioncode) {
        this.exceptioncode = exceptioncode == null ? null : exceptioncode.trim();
    }

    public String getActionmethod() {
        return actionmethod;
    }

    public void setActionmethod(String actionmethod) {
        this.actionmethod = actionmethod == null ? null : actionmethod.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public String getExceptiondetail() {
        return exceptiondetail;
    }

    public void setExceptiondetail(String exceptiondetail) {
        this.exceptiondetail = exceptiondetail == null ? null : exceptiondetail.trim();
    }

    @Override
    public String toString() {
        return "SystemLog{" +
                "id=" + id +
                ", requestip='" + requestip + '\'' +
                ", type='" + type + '\'' +
                ", userid='" + userid + '\'' +
                ", description='" + description + '\'' +
                ", actiondate=" + actiondate +
                ", exceptioncode='" + exceptioncode + '\'' +
                ", actionmethod='" + actionmethod + '\'' +
                ", params='" + params + '\'' +
                ", exceptiondetail='" + exceptiondetail + '\'' +
                '}';
    }
}