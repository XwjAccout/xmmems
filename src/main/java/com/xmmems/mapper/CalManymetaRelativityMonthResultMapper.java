package com.xmmems.mapper;

import com.xmmems.domain.cal.CalManymetaRelativityMonthResult;
import com.xmmems.domain.cal.CalManymetaRelativityMonthResultExample;
import java.util.List;

public interface CalManymetaRelativityMonthResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalManymetaRelativityMonthResult record);

    int insertSelective(CalManymetaRelativityMonthResult record);

    List<CalManymetaRelativityMonthResult> selectByExampleWithBLOBs(CalManymetaRelativityMonthResultExample example);

    List<CalManymetaRelativityMonthResult> selectByExample(CalManymetaRelativityMonthResultExample example);

    CalManymetaRelativityMonthResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalManymetaRelativityMonthResult record);

    int updateByPrimaryKeyWithBLOBs(CalManymetaRelativityMonthResult record);

    int updateByPrimaryKey(CalManymetaRelativityMonthResult record);
}