package com.xmmems.mapper;

import com.xmmems.domain.app.AppRoleMenuExample;
import com.xmmems.domain.app.AppRoleMenuKey;
import java.util.List;

public interface AppRoleMenuMapper {
    int deleteByPrimaryKey(AppRoleMenuKey key);

    int insert(AppRoleMenuKey record);

    int insertSelective(AppRoleMenuKey record);

    List<AppRoleMenuKey> selectByExample(AppRoleMenuExample example);
}