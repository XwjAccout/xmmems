package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaMainconstMonthLogKpi;
import com.xmmems.domain.cal.CalManymetaMainconstMonthLogKpiExample;
import java.util.List;

public interface CalManymetaMainconstMonthLogKpiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaMainconstMonthLogKpi record);

    int insertSelective(CalManymetaMainconstMonthLogKpi record);

    List<CalManymetaMainconstMonthLogKpi> selectByExample(CalManymetaMainconstMonthLogKpiExample example);

    CalManymetaMainconstMonthLogKpi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaMainconstMonthLogKpi record);

    int updateByPrimaryKey(CalManymetaMainconstMonthLogKpi record);
}