package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaRelativitySitesLogKpi;
import com.xmmems.domain.cal.CalManymetaRelativitySitesLogKpiExample;
import java.util.List;

public interface CalManymetaRelativitySitesLogKpiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaRelativitySitesLogKpi record);

    int insertSelective(CalManymetaRelativitySitesLogKpi record);

    List<CalManymetaRelativitySitesLogKpi> selectByExample(CalManymetaRelativitySitesLogKpiExample example);

    CalManymetaRelativitySitesLogKpi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaRelativitySitesLogKpi record);

    int updateByPrimaryKey(CalManymetaRelativitySitesLogKpi record);
}