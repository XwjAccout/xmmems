package com.xmmems.mapper;

import com.xmmems.domain.env.EnvHourDataLuyan;
import com.xmmems.domain.env.EnvHourDataLuyanExample;
import java.util.List;

public interface EnvHourDataLuyanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvHourDataLuyan record);

    int insertSelective(EnvHourDataLuyan record);

    List<EnvHourDataLuyan> selectByExampleWithBLOBs(EnvHourDataLuyanExample example);

    List<EnvHourDataLuyan> selectByExample(EnvHourDataLuyanExample example);

    EnvHourDataLuyan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvHourDataLuyan record);

    int updateByPrimaryKeyWithBLOBs(EnvHourDataLuyan record);

    int updateByPrimaryKey(EnvHourDataLuyan record);
}