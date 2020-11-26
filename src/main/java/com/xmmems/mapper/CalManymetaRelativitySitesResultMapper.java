package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaRelativitySitesResult;
import com.xmmems.domain.cal.CalManymetaRelativitySitesResultExample;
import java.util.List;

public interface CalManymetaRelativitySitesResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaRelativitySitesResult record);

    int insertSelective(CalManymetaRelativitySitesResult record);

    List<CalManymetaRelativitySitesResult> selectByExampleWithBLOBs(CalManymetaRelativitySitesResultExample example);

    List<CalManymetaRelativitySitesResult> selectByExample(CalManymetaRelativitySitesResultExample example);

    CalManymetaRelativitySitesResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaRelativitySitesResult record);

    int updateByPrimaryKeyWithBLOBs(CalManymetaRelativitySitesResult record);

    int updateByPrimaryKey(CalManymetaRelativitySitesResult record);
}