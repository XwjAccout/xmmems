package com.xmmems.common.auth.domain;

import lombok.Data;

import java.util.Date;


@Data
public class Payload<T> {
    private String id;//token的id
    private T userInfo;//当前token中的用户信息
    private Date expiration;//过期时间
}