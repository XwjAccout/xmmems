package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaRelativityMonthLogKpi;
import com.xmmems.domain.cal.CalManymetaRelativityMonthLogKpiExample;
import java.util.List;

public interface CalManymetaRelativityMonthLogKpiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaRelativityMonthLogKpi record);

    int insertSelective(CalManymetaRelativityMonthLogKpi record);

    List<CalManymetaRelativityMonthLogKpi> selectByExample(CalManymetaRelativityMonthLogKpiExample example);

    CalManymetaRelativityMonthLogKpi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaRelativityMonthLogKpi record);

    int updateByPrimaryKey(CalManymetaRelativityMonthLogKpi record);
}