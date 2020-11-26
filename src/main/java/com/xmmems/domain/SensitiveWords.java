package com.xmmems.domain;

public class SensitiveWords {
    private Integer id;

    private String word;

    private Byte status;

    private String word_pinyin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word == null ? null : word.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getWord_pinyin() {
        return word_pinyin;
    }

    public void setWord_pinyin(String word_pinyin) {
        this.word_pinyin = word_pinyin == null ? null : word_pinyin.trim();
    }
}