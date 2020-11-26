package com.xmmems.mapper;

import com.xmmems.domain.app.AppMenu;
import com.xmmems.domain.app.AppMenuExample;
import java.util.List;

public interface AppMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppMenu record);

    int insertSelective(AppMenu record);

    List<AppMenu> selectByExample(AppMenuExample example);

    AppMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppMenu record);

    int updateByPrimaryKey(AppMenu record);
}