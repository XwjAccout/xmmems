package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaFactorMonthLogKpi;
import com.xmmems.domain.cal.CalManymetaFactorMonthLogKpiExample;
import java.util.List;

public interface CalManymetaFactorMonthLogKpiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaFactorMonthLogKpi record);

    int insertSelective(CalManymetaFactorMonthLogKpi record);

    List<CalManymetaFactorMonthLogKpi> selectByExample(CalManymetaFactorMonthLogKpiExample example);

    CalManymetaFactorMonthLogKpi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaFactorMonthLogKpi record);

    int updateByPrimaryKey(CalManymetaFactorMonthLogKpi record);
}