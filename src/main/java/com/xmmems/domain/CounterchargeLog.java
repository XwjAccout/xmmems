package com.xmmems.domain;

public class CounterchargeLog {
    private String QN;

    private String CNName;

    private String realName;

    private String RCTime;

    private String ip;

    private Integer qnRtn;

    private Integer exrRtn;

    private String CPData;

    public String getQN() {
        return QN;
    }

    public void setQN(String QN) {
        this.QN = QN == null ? null : QN.trim();
    }

    public String getCNName() {
        return CNName;
    }

    public void setCNName(String CNName) {
        this.CNName = CNName == null ? null : CNName.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getRCTime() {
        return RCTime;
    }

    public void setRCTime(String RCTime) {
        this.RCTime = RCTime == null ? null : RCTime.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getQnRtn() {
        return qnRtn;
    }

    public void setQnRtn(Integer qnRtn) {
        this.qnRtn = qnRtn;
    }

    public Integer getExrRtn() {
        return exrRtn;
    }

    public void setExrRtn(Integer exrRtn) {
        this.exrRtn = exrRtn;
    }

    public String getCPData() {
        return CPData;
    }

    public void setCPData(String CPData) {
        this.CPData = CPData == null ? null : CPData.trim();
    }
}