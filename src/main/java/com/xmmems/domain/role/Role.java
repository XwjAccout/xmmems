package com.xmmems.domain.role;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Role {
    private Integer id;

    private String name;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createAt;

    private List<Permission> permissions;//权限列表，非逆向工程生成
    private List<Map<String,Object>> menus;//菜单列表，非逆向工程生成
    private List<Map<String,Object>> otherPower;//其他权限列表，非逆向工程生成

    public List<Map<String,Object>> getMenus() {
        return menus;
    }

    public void setMenus(List<Map<String,Object>> menus) {
        this.menus = menus;
    }

    public List<Map<String,Object>> getOtherPower() {
        return otherPower;
    }

    public void setOtherPower(List<Map<String,Object>> otherPower) {
        this.otherPower = otherPower;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}