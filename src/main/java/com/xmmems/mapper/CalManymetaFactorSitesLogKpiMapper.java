package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaFactorSitesLogKpi;
import com.xmmems.domain.cal.CalManymetaFactorSitesLogKpiExample;
import java.util.List;

public interface CalManymetaFactorSitesLogKpiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaFactorSitesLogKpi record);

    int insertSelective(CalManymetaFactorSitesLogKpi record);

    List<CalManymetaFactorSitesLogKpi> selectByExample(CalManymetaFactorSitesLogKpiExample example);

    CalManymetaFactorSitesLogKpi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaFactorSitesLogKpi record);

    int updateByPrimaryKey(CalManymetaFactorSitesLogKpi record);
}