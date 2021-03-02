package com.xmmems.material.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2021.03.01 15:55
 */
@Table(name = "cost")
@Data
public class Cost {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Double price;

    @Column(name = "pid")
    private Integer pid;


}
