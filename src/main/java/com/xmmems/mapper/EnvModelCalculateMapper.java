package com.xmmems.mapper;

import com.xmmems.domain.env.EnvModelCalculate;
import com.xmmems.domain.env.EnvModelCalculateExample;
import com.xmmems.domain.env.EnvModelCalculateWithBLOBs;
import java.util.List;

public interface EnvModelCalculateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvModelCalculateWithBLOBs record);

    int insertSelective(EnvModelCalculateWithBLOBs record);

    List<EnvModelCalculateWithBLOBs> selectByExampleWithBLOBs(EnvModelCalculateExample example);

    List<EnvModelCalculate> selectByExample(EnvModelCalculateExample example);

    EnvModelCalculateWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvModelCalculateWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(EnvModelCalculateWithBLOBs record);

    int updateByPrimaryKey(EnvModelCalculate record);
}