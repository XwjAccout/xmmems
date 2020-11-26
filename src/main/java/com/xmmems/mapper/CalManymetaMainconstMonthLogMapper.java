package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaMainconstMonthLog;
import com.xmmems.domain.cal.CalManymetaMainconstMonthLogExample;
import java.util.List;

public interface CalManymetaMainconstMonthLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaMainconstMonthLog record);

    int insertSelective(CalManymetaMainconstMonthLog record);

    List<CalManymetaMainconstMonthLog> selectByExample(CalManymetaMainconstMonthLogExample example);

    CalManymetaMainconstMonthLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaMainconstMonthLog record);

    int updateByPrimaryKey(CalManymetaMainconstMonthLog record);
}