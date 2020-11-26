package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaFactorSitesLog;
import com.xmmems.domain.cal.CalManymetaFactorSitesLogExample;
import java.util.List;

public interface CalManymetaFactorSitesLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaFactorSitesLog record);

    int insertSelective(CalManymetaFactorSitesLog record);

    List<CalManymetaFactorSitesLog> selectByExample(CalManymetaFactorSitesLogExample example);

    CalManymetaFactorSitesLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaFactorSitesLog record);

    int updateByPrimaryKey(CalManymetaFactorSitesLog record);
}