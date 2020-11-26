package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaFactorMonthLog;
import com.xmmems.domain.cal.CalManymetaFactorMonthLogExample;
import java.util.List;

public interface CalManymetaFactorMonthLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaFactorMonthLog record);

    int insertSelective(CalManymetaFactorMonthLog record);

    List<CalManymetaFactorMonthLog> selectByExample(CalManymetaFactorMonthLogExample example);

    CalManymetaFactorMonthLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaFactorMonthLog record);

    int updateByPrimaryKey(CalManymetaFactorMonthLog record);
}