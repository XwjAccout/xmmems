package com.xmmems.material.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2021.02.23 09:42
 */
@Data
@Table(name = "material_management")
public class MaterialManagement {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "warnCount")
    private Integer warnCount;
    @Column(name = "unit")
    private String unit;
    @Column(name = "siteId")
    private Integer siteId;
    @Column(name = "siteName")
    private String siteName;
    @Column(name = "remarks")
    private String remarks;

    //    保存未预警、预警状态)
    @Transient
    private String warnType;
    @Transient
    private Integer num;

//类型
    @Column(name = "type")
    private String type;
    @Column(name = "fId")
    private Integer fId;
    @Column(name = "rId")
    private Integer rId;




}
