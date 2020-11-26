package com.xmmems.mapper;

import com.xmmems.domain.env.EnvKpiType;
import com.xmmems.domain.env.EnvKpiTypeExample;
import java.util.List;

public interface EnvKpiTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvKpiType record);

    int insertSelective(EnvKpiType record);

    List<EnvKpiType> selectByExample(EnvKpiTypeExample example);

    EnvKpiType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvKpiType record);

    int updateByPrimaryKey(EnvKpiType record);
}