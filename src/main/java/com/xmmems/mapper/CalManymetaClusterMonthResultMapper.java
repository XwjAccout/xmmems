package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaClusterMonthResult;
import com.xmmems.domain.cal.CalManymetaClusterMonthResultExample;
import java.util.List;

public interface CalManymetaClusterMonthResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaClusterMonthResult record);

    int insertSelective(CalManymetaClusterMonthResult record);

    List<CalManymetaClusterMonthResult> selectByExampleWithBLOBs(CalManymetaClusterMonthResultExample example);

    List<CalManymetaClusterMonthResult> selectByExample(CalManymetaClusterMonthResultExample example);

    CalManymetaClusterMonthResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaClusterMonthResult record);

    int updateByPrimaryKeyWithBLOBs(CalManymetaClusterMonthResult record);

    int updateByPrimaryKey(CalManymetaClusterMonthResult record);
}