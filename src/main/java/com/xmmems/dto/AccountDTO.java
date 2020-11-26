package com.xmmems.dto;

import com.xmmems.domain.base.BaseSite;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class AccountDTO {
    private Integer id;
    private String nickName;
    private String userName;
    private Integer status;
    private Date createAt;
    //角色信息
    private List<RoleDTO> roleDTOS;

    //站点信息
    List<Map<String, Object>> sites;

}
