package com.xmmems.common.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserToken {
    private Integer id;
    private String username;
    private List<String> roles;
    private String nickName;
}
