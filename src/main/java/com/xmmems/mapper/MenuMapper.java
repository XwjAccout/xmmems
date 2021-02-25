package com.xmmems.mapper;

import com.xmmems.domain.role.Menu;
import com.xmmems.domain.role.MenuExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    @Select("SELECT m.id,m.name FROM role_menu rm JOIN menu m ON rm.menuId=m.id WHERE rm.roleId=#{roleId}")
    List<Map<String, Object>> findByRoleId(Integer roleId);

    @Select("SELECT DISTINCT m.* FROM menu m JOIN role_menu rm ON m.`id`=rm.`menuId` JOIN account_role ar ON rm.`roleId`=ar.`roleId` WHERE ar.`accountId`=#{accountId} AND m.`isvalid` = '1' ORDER BY m.`rank` asc")
    List<Menu> selectByAccountId(Integer accountId);

//    @Select("SELECT * FROM menu ORDER BY rank ASC")
    List<Menu> selectAll();

    @Select("SELECT m.* FROM menu as m , role_menu as rm WHERE m.`id`=rm.`menuId` and  rm.`roleId` = #{roleId} ORDER BY m.rank,m.sort ASC")
    List<Menu> selectByRoleId(Integer roleId);

    @Select("select * from role_menu r,menu m where r.menuId=m.id and r.roleId=#{roleId} and pcode = #{pcode} and isvalid=1 ORDER BY m.sort asc")
    List<Menu> findByPid(@Param("pcode") String pcode,@Param("roleId") Integer roleId);

    List<Menu> roleById(@Param("roleId") Integer roleId);

    List<Map<Integer,Integer>> roleByAccoutId(@Param("accountId") Integer accountId);

    List<Menu> selectMenusByRoleIds(@Param("roleIds") List<Integer> roleIds);

    List<Menu> findByPidRoleids(@Param("pcode") String pcode,@Param("roleIds") List<Integer> roleIds);
}