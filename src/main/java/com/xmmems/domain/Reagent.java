package com.xmmems.domain;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "reagent")
@Data
public class Reagent {
    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "id")
    private  Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "unit")
    private  String unit;
    @Column(name = "price")
    private  double price;
}
