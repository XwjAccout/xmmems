package com.xmmems.task.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2021.01.21 14:41
 */
@Table(name = "assessment")
@Data
public class Assessment {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
    @Column(name = "uploadTime")
    private Date uploadTime;
    @Column(name = "userName")
    private String userName;
    @Column(name = "content")
    private String content;
    @Column(name = "assessFileUrl")
    private String assessFileUrl;




}
