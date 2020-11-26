package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaFactorSitesResult;
import com.xmmems.domain.cal.CalManymetaFactorSitesResultExample;
import java.util.List;

public interface CalManymetaFactorSitesResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaFactorSitesResult record);

    int insertSelective(CalManymetaFactorSitesResult record);

    List<CalManymetaFactorSitesResult> selectByExampleWithBLOBs(CalManymetaFactorSitesResultExample example);

    List<CalManymetaFactorSitesResult> selectByExample(CalManymetaFactorSitesResultExample example);

    CalManymetaFactorSitesResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaFactorSitesResult record);

    int updateByPrimaryKeyWithBLOBs(CalManymetaFactorSitesResult record);

    int updateByPrimaryKey(CalManymetaFactorSitesResult record);
}