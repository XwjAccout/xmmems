package com.xmmems.mapper;

import com.xmmems.domain.role.Role;
import com.xmmems.domain.role.RoleExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    @Select("select r.* from account_role ar join role r on ar.roleId = r.id where ar.accountId = #{id};")
    List<Role> findRoleByAccountId(Integer id);

    @Insert("INSERT INTO role_permission(roleId, permissionId) VALUES (#{roleId},#{permissionId}) ")
    int savePermission(@Param("roleId") Integer roleId,@Param("permissionId") Integer permissionId);

    @Delete("delete from role_permission where roleId=#{roleId} and permissionId=#{permissionId}")
    int deletePermission(@Param("roleId") Integer roleId,@Param("permissionId") Integer permissionId);

    @Insert("INSERT INTO role_menu (menuId, roleId) VALUES (#{menuId},#{roleId})")
    int saveMenu(@Param("roleId") Integer roleId,@Param("menuId") Integer menuId);

    @Delete("DELETE FROM  role_menu WHERE roleId=#{roleId} and menuId=#{menuId}")
    int deleteMenu(@Param("roleId") Integer roleId,@Param("menuId") Integer menuId);

    @Insert("insert into `role_power`(`roleId`, `otherPowerId`) values(#{roleId}, #{otherPowerId})")
    int saveotherPower(@Param("roleId") Integer roleId, @Param("otherPowerId") Integer otherPowerId);

    @Delete("delete from role_power where roleId=#{roleId} and otherPowerId=#{otherPowerId}")
    int deleteotherPower(@Param("roleId") Integer roleId,@Param("otherPowerId") Integer otherPowerId);
    @Select(" select count(1) from role_menu where menuId=#{menuId} and roleId=#{roleId}")
     int isExistmenuId(@Param("menuId") Integer menuId,@Param("roleId") Integer roleId);
}