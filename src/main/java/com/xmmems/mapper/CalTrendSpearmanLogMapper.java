package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTrendSpearmanLog;
import com.xmmems.domain.cal.CalTrendSpearmanLogExample;
import java.util.List;

public interface CalTrendSpearmanLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTrendSpearmanLog record);

    int insertSelective(CalTrendSpearmanLog record);

    List<CalTrendSpearmanLog> selectByExample(CalTrendSpearmanLogExample example);

    CalTrendSpearmanLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTrendSpearmanLog record);

    int updateByPrimaryKey(CalTrendSpearmanLog record);
}