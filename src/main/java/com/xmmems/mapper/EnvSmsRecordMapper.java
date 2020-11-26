package com.xmmems.mapper;

import com.xmmems.domain.env.EnvSmsRecord;
import com.xmmems.domain.env.EnvSmsRecordExample;
import com.xmmems.domain.env.EnvSmsRecordWithBLOBs;
import java.util.List;

public interface EnvSmsRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvSmsRecordWithBLOBs record);

    int insertSelective(EnvSmsRecordWithBLOBs record);

    List<EnvSmsRecordWithBLOBs> selectByExampleWithBLOBs(EnvSmsRecordExample example);

    List<EnvSmsRecord> selectByExample(EnvSmsRecordExample example);

    EnvSmsRecordWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvSmsRecordWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(EnvSmsRecordWithBLOBs record);

    int updateByPrimaryKey(EnvSmsRecord record);
}