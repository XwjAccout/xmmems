package com.xmmems.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Integer id;//
    private String nickName;//
    private String username;//需要
    private String password;//
    private Integer status;

    //角色
    private List<RoleDTO> roles;

}
