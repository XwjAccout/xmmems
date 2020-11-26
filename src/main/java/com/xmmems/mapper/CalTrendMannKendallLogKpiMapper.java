package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTrendMannKendallLogKpi;
import com.xmmems.domain.cal.CalTrendMannKendallLogKpiExample;
import java.util.List;

public interface CalTrendMannKendallLogKpiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTrendMannKendallLogKpi record);

    int insertSelective(CalTrendMannKendallLogKpi record);

    List<CalTrendMannKendallLogKpi> selectByExample(CalTrendMannKendallLogKpiExample example);

    CalTrendMannKendallLogKpi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTrendMannKendallLogKpi record);

    int updateByPrimaryKey(CalTrendMannKendallLogKpi record);
}