package com.xmmems.mapper;

import com.xmmems.domain.role.RolePermissionExample;
import com.xmmems.domain.role.RolePermissionKey;
import java.util.List;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(RolePermissionKey key);

    int insert(RolePermissionKey record);

    int insertSelective(RolePermissionKey record);

    List<RolePermissionKey> selectByExample(RolePermissionExample example);
}