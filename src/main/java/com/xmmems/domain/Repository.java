package com.xmmems.domain;

import java.util.Date;

public class Repository {
    private String essayClass;

    private String essayTitle;

    private String author;

    private Date createTime;

    private Integer type;

    public String getEssayClass() {
        return essayClass;
    }

    public void setEssayClass(String essayClass) {
        this.essayClass = essayClass == null ? null : essayClass.trim();
    }

    public String getEssayTitle() {
        return essayTitle;
    }

    public void setEssayTitle(String essayTitle) {
        this.essayTitle = essayTitle == null ? null : essayTitle.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}