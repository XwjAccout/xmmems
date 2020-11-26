package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaMainconstMonthResult;
import com.xmmems.domain.cal.CalManymetaMainconstMonthResultExample;
import java.util.List;

public interface CalManymetaMainconstMonthResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaMainconstMonthResult record);

    int insertSelective(CalManymetaMainconstMonthResult record);

    List<CalManymetaMainconstMonthResult> selectByExampleWithBLOBs(CalManymetaMainconstMonthResultExample example);

    List<CalManymetaMainconstMonthResult> selectByExample(CalManymetaMainconstMonthResultExample example);

    CalManymetaMainconstMonthResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaMainconstMonthResult record);

    int updateByPrimaryKeyWithBLOBs(CalManymetaMainconstMonthResult record);

    int updateByPrimaryKey(CalManymetaMainconstMonthResult record);
}