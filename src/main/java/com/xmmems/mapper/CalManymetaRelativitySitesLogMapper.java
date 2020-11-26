package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaRelativitySitesLog;
import com.xmmems.domain.cal.CalManymetaRelativitySitesLogExample;
import java.util.List;

public interface CalManymetaRelativitySitesLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaRelativitySitesLog record);

    int insertSelective(CalManymetaRelativitySitesLog record);

    List<CalManymetaRelativitySitesLog> selectByExample(CalManymetaRelativitySitesLogExample example);

    CalManymetaRelativitySitesLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaRelativitySitesLog record);

    int updateByPrimaryKey(CalManymetaRelativitySitesLog record);
}