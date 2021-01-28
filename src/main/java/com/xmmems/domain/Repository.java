package com.xmmems.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "repository")
@Data
public class Repository {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "essayClass")
    private String essayClass;
    @Column(name = "essayTitle")
    private String essayTitle;
    @Column(name = "author")
    private String author;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "createTime")
    private Date createTime;
    @Column(name = "type")
    private Integer type;
    @Column(name = "url")
    private String url;


}