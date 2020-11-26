package com.xmmems.mapper;

import com.xmmems.domain.SystemLog;
import com.xmmems.domain.SystemLogExample;

import java.util.List;

public interface SystemLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemLog record);

    int insertSelective(SystemLog record);

    List<SystemLog> selectByExampleWithBLOBs(SystemLogExample example);

    List<SystemLog> selectByExample(SystemLogExample example);

    SystemLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemLog record);

    int updateByPrimaryKeyWithBLOBs(SystemLog record);

    int updateByPrimaryKey(SystemLog record);
}