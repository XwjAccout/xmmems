package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaRelativityMonthLog;
import com.xmmems.domain.cal.CalManymetaRelativityMonthLogExample;
import java.util.List;

public interface CalManymetaRelativityMonthLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaRelativityMonthLog record);

    int insertSelective(CalManymetaRelativityMonthLog record);

    List<CalManymetaRelativityMonthLog> selectByExample(CalManymetaRelativityMonthLogExample example);

    CalManymetaRelativityMonthLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaRelativityMonthLog record);

    int updateByPrimaryKey(CalManymetaRelativityMonthLog record);
}