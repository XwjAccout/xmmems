package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaClusterSitesLogKpi;
import com.xmmems.domain.cal.CalManymetaClusterSitesLogKpiExample;
import java.util.List;

public interface CalManymetaClusterSitesLogKpiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaClusterSitesLogKpi record);

    int insertSelective(CalManymetaClusterSitesLogKpi record);

    List<CalManymetaClusterSitesLogKpi> selectByExample(CalManymetaClusterSitesLogKpiExample example);

    CalManymetaClusterSitesLogKpi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaClusterSitesLogKpi record);

    int updateByPrimaryKey(CalManymetaClusterSitesLogKpi record);
}