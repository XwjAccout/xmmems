package com.xmmems.domain.env;

public class EnvSmsRecordWithBLOBs extends EnvSmsRecord {
    private String content;

    private String receiveTel;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getReceiveTel() {
        return receiveTel;
    }

    public void setReceiveTel(String receiveTel) {
        this.receiveTel = receiveTel == null ? null : receiveTel.trim();
    }
}