package com.xmmems.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2020.11.24 16:00
 */
@Table(name = "excelfile")
@Data
public class ExcelFile {

    @Id
    @Column(name = "timeStr")
    private String timeStr;
    @Id
    @Column(name = "siteId")
    private Integer siteId;
    @Id
    @Column(name = "type")
    private String type;
    @Column(name = "excelUrl")
    private String excelUrl;



}
