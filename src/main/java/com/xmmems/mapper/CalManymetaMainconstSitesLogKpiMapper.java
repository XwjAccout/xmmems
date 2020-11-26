package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaMainconstSitesLogKpi;
import com.xmmems.domain.cal.CalManymetaMainconstSitesLogKpiExample;
import java.util.List;

public interface CalManymetaMainconstSitesLogKpiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaMainconstSitesLogKpi record);

    int insertSelective(CalManymetaMainconstSitesLogKpi record);

    List<CalManymetaMainconstSitesLogKpi> selectByExample(CalManymetaMainconstSitesLogKpiExample example);

    CalManymetaMainconstSitesLogKpi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaMainconstSitesLogKpi record);

    int updateByPrimaryKey(CalManymetaMainconstSitesLogKpi record);
}