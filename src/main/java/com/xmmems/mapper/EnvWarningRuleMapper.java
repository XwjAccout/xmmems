package com.xmmems.mapper;

import com.xmmems.domain.env.EnvWarningRule;
import com.xmmems.domain.env.EnvWarningRuleExample;
import java.util.List;

public interface EnvWarningRuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvWarningRule record);

    int insertSelective(EnvWarningRule record);

    List<EnvWarningRule> selectByExample(EnvWarningRuleExample example);

    EnvWarningRule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvWarningRule record);

    int updateByPrimaryKey(EnvWarningRule record);
}