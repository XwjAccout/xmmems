package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTrendMannKendallLog;
import com.xmmems.domain.cal.CalTrendMannKendallLogExample;
import java.util.List;

public interface CalTrendMannKendallLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTrendMannKendallLog record);

    int insertSelective(CalTrendMannKendallLog record);

    List<CalTrendMannKendallLog> selectByExample(CalTrendMannKendallLogExample example);

    CalTrendMannKendallLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTrendMannKendallLog record);

    int updateByPrimaryKey(CalTrendMannKendallLog record);
}