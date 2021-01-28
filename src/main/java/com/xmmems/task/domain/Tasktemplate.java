package com.xmmems.task.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2021.01.20 16:43
 */
@Table(name = "tasktemplate")
@Data
public class Tasktemplate {

    @Id
    @Column(name = "taskName")
    private String taskName;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "createTime")
    private String createTime;
    @Column(name = "sendUser")
    private String sendUser;


}
