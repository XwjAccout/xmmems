package com.xmmems.mapper;

import com.xmmems.domain.EnvWarningMsg;
import com.xmmems.domain.EnvWarningMsgExample;
import java.util.List;

public interface EnvWarningMsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvWarningMsg record);

    int insertSelective(EnvWarningMsg record);

    List<EnvWarningMsg> selectByExample(EnvWarningMsgExample example);

    EnvWarningMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvWarningMsg record);

    int updateByPrimaryKey(EnvWarningMsg record);
}