package com.xmmems.mapper;

import com.xmmems.domain.env.EnvSiteKpi;
import com.xmmems.domain.env.EnvSiteKpiExample;
import java.util.List;

public interface EnvSiteKpiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvSiteKpi record);

    int insertSelective(EnvSiteKpi record);

    List<EnvSiteKpi> selectByExample(EnvSiteKpiExample example);

    EnvSiteKpi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvSiteKpi record);

    int updateByPrimaryKey(EnvSiteKpi record);
}