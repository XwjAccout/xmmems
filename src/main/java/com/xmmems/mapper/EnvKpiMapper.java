package com.xmmems.mapper;

import com.xmmems.domain.env.EnvKpi;
import com.xmmems.domain.env.EnvKpiExample;
import java.util.List;

public interface EnvKpiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvKpi record);

    int insertSelective(EnvKpi record);

    List<EnvKpi> selectByExample(EnvKpiExample example);

    EnvKpi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvKpi record);

    int updateByPrimaryKey(EnvKpi record);
}