package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaClusterMonthLog;
import com.xmmems.domain.cal.CalManymetaClusterMonthLogExample;
import java.util.List;

public interface CalManymetaClusterMonthLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaClusterMonthLog record);

    int insertSelective(CalManymetaClusterMonthLog record);

    List<CalManymetaClusterMonthLog> selectByExample(CalManymetaClusterMonthLogExample example);

    CalManymetaClusterMonthLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaClusterMonthLog record);

    int updateByPrimaryKey(CalManymetaClusterMonthLog record);
}