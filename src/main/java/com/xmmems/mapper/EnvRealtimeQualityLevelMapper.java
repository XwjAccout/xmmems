package com.xmmems.mapper;

import com.xmmems.domain.env.EnvRealtimeQualityLevel;
import com.xmmems.domain.env.EnvRealtimeQualityLevelExample;
import java.util.List;

public interface EnvRealtimeQualityLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvRealtimeQualityLevel record);

    int insertSelective(EnvRealtimeQualityLevel record);

    List<EnvRealtimeQualityLevel> selectByExample(EnvRealtimeQualityLevelExample example);

    EnvRealtimeQualityLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvRealtimeQualityLevel record);

    int updateByPrimaryKey(EnvRealtimeQualityLevel record);
}