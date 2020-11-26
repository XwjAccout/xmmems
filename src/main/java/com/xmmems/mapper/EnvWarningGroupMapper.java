package com.xmmems.mapper;

import com.xmmems.domain.env.EnvWarningGroup;
import com.xmmems.domain.env.EnvWarningGroupExample;
import com.xmmems.domain.env.EnvWarningGroupWithBLOBs;
import java.util.List;

public interface EnvWarningGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvWarningGroupWithBLOBs record);

    int insertSelective(EnvWarningGroupWithBLOBs record);

    List<EnvWarningGroupWithBLOBs> selectByExampleWithBLOBs(EnvWarningGroupExample example);

    List<EnvWarningGroup> selectByExample(EnvWarningGroupExample example);

    EnvWarningGroupWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvWarningGroupWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(EnvWarningGroupWithBLOBs record);

    int updateByPrimaryKey(EnvWarningGroup record);
}