package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaClusterMonthLogKpi;
import com.xmmems.domain.cal.CalManymetaClusterMonthLogKpiExample;
import java.util.List;

public interface CalManymetaClusterMonthLogKpiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaClusterMonthLogKpi record);

    int insertSelective(CalManymetaClusterMonthLogKpi record);

    List<CalManymetaClusterMonthLogKpi> selectByExample(CalManymetaClusterMonthLogKpiExample example);

    CalManymetaClusterMonthLogKpi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaClusterMonthLogKpi record);

    int updateByPrimaryKey(CalManymetaClusterMonthLogKpi record);
}