package com.xmmems.task.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2021.01.20 10:37
 */
@Table(name = "sendnotice")
@Data
public class Sendnotice {

    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "noticeId")
    private Integer noticeId;
    @Column(name = "sendAccountId")
    private Integer sendAccountId;
    @Column(name = "sendAccountName")
    private String sendAccountName;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
    @Column(name = "createTime")
    private Date createTime;
    @Column(name = "siteId")
    private Integer siteId;
    @Column(name = "siteName")
    private String siteName;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
    @Column(name = "sendTime")
    private Date sendTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
    @Column(name = "receiptTime")
    private Date receiptTime;
    @Column(name = "annexUrl")
    private String annexUrl;
    @Column(name = "opinion")
    private String opinion;
    @Column(name = "receiveAccountId")
    private Integer receiveAccountId;
    @Column(name = "receiveAccountName")
    private String receiveAccountName;
    @Column(name = "readType")
    private String readType;


}
