package com.xmmems.mapper;

import com.xmmems.domain.env.EnvAuditData;
import com.xmmems.domain.env.EnvAuditDataExample;
import com.xmmems.domain.env.EnvAuditDataWithBLOBs;
import java.util.List;

public interface EnvAuditDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvAuditDataWithBLOBs record);

    int insertSelective(EnvAuditDataWithBLOBs record);

    List<EnvAuditDataWithBLOBs> selectByExampleWithBLOBs(EnvAuditDataExample example);

    List<EnvAuditData> selectByExample(EnvAuditDataExample example);

    EnvAuditDataWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvAuditDataWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(EnvAuditDataWithBLOBs record);

    int updateByPrimaryKey(EnvAuditData record);
}