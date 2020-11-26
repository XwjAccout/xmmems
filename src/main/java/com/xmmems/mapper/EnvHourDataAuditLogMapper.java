package com.xmmems.mapper;

import com.xmmems.domain.env.EnvHourDataAuditLog;
import com.xmmems.domain.env.EnvHourDataAuditLogExample;
import java.util.List;

public interface EnvHourDataAuditLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvHourDataAuditLog record);

    int insertSelective(EnvHourDataAuditLog record);

    List<EnvHourDataAuditLog> selectByExample(EnvHourDataAuditLogExample example);

    EnvHourDataAuditLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvHourDataAuditLog record);

    int updateByPrimaryKey(EnvHourDataAuditLog record);
}