package com.xmmems.mapper;

import com.xmmems.domain.role.RolePower;
import com.xmmems.domain.role.RolePowerExample;
import java.util.List;

public interface RolePowerMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(RolePower record);

    int insertSelective(RolePower record);

    List<RolePower> selectByExample(RolePowerExample example);

    RolePower selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(RolePower record);

    int updateByPrimaryKey(RolePower record);
}