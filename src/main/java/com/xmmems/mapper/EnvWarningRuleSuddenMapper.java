package com.xmmems.mapper;

import com.xmmems.domain.env.EnvWarningRuleSudden;
import com.xmmems.domain.env.EnvWarningRuleSuddenExample;
import java.util.List;

public interface EnvWarningRuleSuddenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvWarningRuleSudden record);

    int insertSelective(EnvWarningRuleSudden record);

    List<EnvWarningRuleSudden> selectByExampleWithBLOBs(EnvWarningRuleSuddenExample example);

    List<EnvWarningRuleSudden> selectByExample(EnvWarningRuleSuddenExample example);

    EnvWarningRuleSudden selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvWarningRuleSudden record);

    int updateByPrimaryKeyWithBLOBs(EnvWarningRuleSudden record);

    int updateByPrimaryKey(EnvWarningRuleSudden record);
}