package com.xmmems.domain.env;

public class EnvAuditDataWithBLOBs extends EnvAuditData {
    private String content;

    private String afterContent;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAfterContent() {
        return afterContent;
    }

    public void setAfterContent(String afterContent) {
        this.afterContent = afterContent == null ? null : afterContent.trim();
    }
}