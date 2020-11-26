package com.xmmems.mapper;

import com.xmmems.domain.RecoveryHandled;
import com.xmmems.domain.RecoveryHandledExample;

import java.util.List;

public interface RecoveryHandledMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecoveryHandled record);

    int insertSelective(RecoveryHandled record);

    List<RecoveryHandled> selectByExampleWithBLOBs(RecoveryHandledExample example);

    List<RecoveryHandled> selectByExample(RecoveryHandledExample example);

    RecoveryHandled selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecoveryHandled record);

    int updateByPrimaryKeyWithBLOBs(RecoveryHandled record);

    int updateByPrimaryKey(RecoveryHandled record);
}