package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaMainconstSitesResult;
import com.xmmems.domain.cal.CalManymetaMainconstSitesResultExample;
import java.util.List;

public interface CalManymetaMainconstSitesResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaMainconstSitesResult record);

    int insertSelective(CalManymetaMainconstSitesResult record);

    List<CalManymetaMainconstSitesResult> selectByExampleWithBLOBs(CalManymetaMainconstSitesResultExample example);

    List<CalManymetaMainconstSitesResult> selectByExample(CalManymetaMainconstSitesResultExample example);

    CalManymetaMainconstSitesResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaMainconstSitesResult record);

    int updateByPrimaryKeyWithBLOBs(CalManymetaMainconstSitesResult record);

    int updateByPrimaryKey(CalManymetaMainconstSitesResult record);
}