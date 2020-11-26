package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTimeseqArimaLogKpi;
import com.xmmems.domain.cal.CalTimeseqArimaLogKpiExample;
import java.util.List;

public interface CalTimeseqArimaLogKpiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTimeseqArimaLogKpi record);

    int insertSelective(CalTimeseqArimaLogKpi record);

    List<CalTimeseqArimaLogKpi> selectByExample(CalTimeseqArimaLogKpiExample example);

    CalTimeseqArimaLogKpi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTimeseqArimaLogKpi record);

    int updateByPrimaryKey(CalTimeseqArimaLogKpi record);
}