package com.xmmems.mapper;

import com.xmmems.domain.role.Permission;
import com.xmmems.domain.role.PermissionExample;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    @Select("select * from permission order by controller asc")
    List<Permission> findAllByControllerAsc();

    @Select("SELECT p.* FROM role_permission rp  JOIN permission p ON rp.`permissionId`=p.`id` WHERE rp.`roleId`=#{roleId}")
    List<Permission> findByRoleId(Integer roleId);

    @Select("select * from role_power where roleId = #{roleId}")
    List<Map<String, Object>> findotherPowerByRoleId(Integer roleId);
}