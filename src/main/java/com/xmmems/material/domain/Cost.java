package com.xmmems.material.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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

    @Column(name = "receiveAccountName")
    String receiveAccountName;

    @Column(name = "receiveAccountId")
    Integer receiveAccountId;

    @Column(name = "noticeId")
    Integer noticeId;

    @Column(name = "receiptTime")
    Date receiptTime;

    @Column(name = "counts")
    Integer counts;

    @Column(name = "price")
    double price;
}
