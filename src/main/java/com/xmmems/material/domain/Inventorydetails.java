package com.xmmems.material.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Table(name = "Inventorydetails")
@Data
public class Inventorydetails {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "mid")
    private Integer mid;

    @Column(name = "mName")
    private String mName;

    @Column(name = "num")
    private Integer num;

    //过期时间
    @Column(name = "expirationTime")
    private String expirationTime;
    //采购时间
    @Column(name = "storageTime")
    private String storageTime;

    @Column(name = "consume")
    private Integer consume;

    @Transient
    private Integer residue;
    /**
     * 消耗人
     */
    @Column(name = "name")
    private String name;
    /**
     * 下一次更换时间
     */
    @Column(name = "nextexpendTime")
    private String nextexpendTime;


}
