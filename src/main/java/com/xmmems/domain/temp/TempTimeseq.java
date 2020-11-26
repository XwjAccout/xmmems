package com.xmmems.domain.temp;

import java.util.Date;

public class TempTimeseq {
    private Integer id;

    private String code;

    private Date seqTime;

    private String seqVal;

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

    public Date getSeqTime() {
        return seqTime;
    }

    public void setSeqTime(Date seqTime) {
        this.seqTime = seqTime;
    }

    public String getSeqVal() {
        return seqVal;
    }

    public void setSeqVal(String seqVal) {
        this.seqVal = seqVal == null ? null : seqVal.trim();
    }
}