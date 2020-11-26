package com.xmmems.mapper;

import com.xmmems.domain.env.EnvWarnRecord;
import com.xmmems.domain.env.EnvWarnRecordExample;
import java.util.List;

public interface EnvWarnRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvWarnRecord record);

    int insertSelective(EnvWarnRecord record);

    List<EnvWarnRecord> selectByExampleWithBLOBs(EnvWarnRecordExample example);

    List<EnvWarnRecord> selectByExample(EnvWarnRecordExample example);

    EnvWarnRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvWarnRecord record);

    int updateByPrimaryKeyWithBLOBs(EnvWarnRecord record);

    int updateByPrimaryKey(EnvWarnRecord record);
}