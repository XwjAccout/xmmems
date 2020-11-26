package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaClusterSitesResult;
import com.xmmems.domain.cal.CalManymetaClusterSitesResultExample;
import java.util.List;

public interface CalManymetaClusterSitesResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaClusterSitesResult record);

    int insertSelective(CalManymetaClusterSitesResult record);

    List<CalManymetaClusterSitesResult> selectByExampleWithBLOBs(CalManymetaClusterSitesResultExample example);

    List<CalManymetaClusterSitesResult> selectByExample(CalManymetaClusterSitesResultExample example);

    CalManymetaClusterSitesResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaClusterSitesResult record);

    int updateByPrimaryKeyWithBLOBs(CalManymetaClusterSitesResult record);

    int updateByPrimaryKey(CalManymetaClusterSitesResult record);
}