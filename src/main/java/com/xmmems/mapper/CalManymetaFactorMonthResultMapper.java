package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaFactorMonthResult;
import com.xmmems.domain.cal.CalManymetaFactorMonthResultExample;
import java.util.List;

public interface CalManymetaFactorMonthResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaFactorMonthResult record);

    int insertSelective(CalManymetaFactorMonthResult record);

    List<CalManymetaFactorMonthResult> selectByExampleWithBLOBs(CalManymetaFactorMonthResultExample example);

    List<CalManymetaFactorMonthResult> selectByExample(CalManymetaFactorMonthResultExample example);

    CalManymetaFactorMonthResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaFactorMonthResult record);

    int updateByPrimaryKeyWithBLOBs(CalManymetaFactorMonthResult record);

    int updateByPrimaryKey(CalManymetaFactorMonthResult record);
}