package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaClusterSitesLog;
import com.xmmems.domain.cal.CalManymetaClusterSitesLogExample;
import java.util.List;

public interface CalManymetaClusterSitesLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaClusterSitesLog record);

    int insertSelective(CalManymetaClusterSitesLog record);

    List<CalManymetaClusterSitesLog> selectByExample(CalManymetaClusterSitesLogExample example);

    CalManymetaClusterSitesLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaClusterSitesLog record);

    int updateByPrimaryKey(CalManymetaClusterSitesLog record);
}