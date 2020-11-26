package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaMainconstSitesLog;
import com.xmmems.domain.cal.CalManymetaMainconstSitesLogExample;
import java.util.List;

public interface CalManymetaMainconstSitesLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaMainconstSitesLog record);

    int insertSelective(CalManymetaMainconstSitesLog record);

    List<CalManymetaMainconstSitesLog> selectByExample(CalManymetaMainconstSitesLogExample example);

    CalManymetaMainconstSitesLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaMainconstSitesLog record);

    int updateByPrimaryKey(CalManymetaMainconstSitesLog record);
}