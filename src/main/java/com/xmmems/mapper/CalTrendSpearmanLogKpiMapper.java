package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTrendSpearmanLogKpi;
import com.xmmems.domain.cal.CalTrendSpearmanLogKpiExample;
import java.util.List;

public interface CalTrendSpearmanLogKpiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTrendSpearmanLogKpi record);

    int insertSelective(CalTrendSpearmanLogKpi record);

    List<CalTrendSpearmanLogKpi> selectByExample(CalTrendSpearmanLogKpiExample example);

    CalTrendSpearmanLogKpi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTrendSpearmanLogKpi record);

    int updateByPrimaryKey(CalTrendSpearmanLogKpi record);
}