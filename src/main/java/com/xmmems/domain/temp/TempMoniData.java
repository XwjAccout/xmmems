package com.xmmems.domain.temp;

import java.util.Date;

public class TempMoniData {
    private Integer id;

    private String siteName;

    private String status;

    private Date moniTime;

    private String sw;

    private String ph;

    private String rjy;

    private String ddl;

    private String zd;

    private String gmsy;

    private String zl;

    private String ad;

    private String xd;

    private String fhw;

    private String qhw;

    private String cd;

    private String pb;

    private String cu;

    private String zn;

    private String flow;

    private String delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getMoniTime() {
        return moniTime;
    }

    public void setMoniTime(Date moniTime) {
        this.moniTime = moniTime;
    }

    public String getSw() {
        return sw;
    }

    public void setSw(String sw) {
        this.sw = sw == null ? null : sw.trim();
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph == null ? null : ph.trim();
    }

    public String getRjy() {
        return rjy;
    }

    public void setRjy(String rjy) {
        this.rjy = rjy == null ? null : rjy.trim();
    }

    public String getDdl() {
        return ddl;
    }

    public void setDdl(String ddl) {
        this.ddl = ddl == null ? null : ddl.trim();
    }

    public String getZd() {
        return zd;
    }

    public void setZd(String zd) {
        this.zd = zd == null ? null : zd.trim();
    }

    public String getGmsy() {
        return gmsy;
    }

    public void setGmsy(String gmsy) {
        this.gmsy = gmsy == null ? null : gmsy.trim();
    }

    public String getZl() {
        return zl;
    }

    public void setZl(String zl) {
        this.zl = zl == null ? null : zl.trim();
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad == null ? null : ad.trim();
    }

    public String getXd() {
        return xd;
    }

    public void setXd(String xd) {
        this.xd = xd == null ? null : xd.trim();
    }

    public String getFhw() {
        return fhw;
    }

    public void setFhw(String fhw) {
        this.fhw = fhw == null ? null : fhw.trim();
    }

    public String getQhw() {
        return qhw;
    }

    public void setQhw(String qhw) {
        this.qhw = qhw == null ? null : qhw.trim();
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd == null ? null : cd.trim();
    }

    public String getPb() {
        return pb;
    }

    public void setPb(String pb) {
        this.pb = pb == null ? null : pb.trim();
    }

    public String getCu() {
        return cu;
    }

    public void setCu(String cu) {
        this.cu = cu == null ? null : cu.trim();
    }

    public String getZn() {
        return zn;
    }

    public void setZn(String zn) {
        this.zn = zn == null ? null : zn.trim();
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow == null ? null : flow.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}