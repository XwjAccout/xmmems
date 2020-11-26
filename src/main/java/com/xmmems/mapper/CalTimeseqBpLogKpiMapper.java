package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTimeseqBpLogKpi;
import com.xmmems.domain.cal.CalTimeseqBpLogKpiExample;
import java.util.List;

public interface CalTimeseqBpLogKpiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTimeseqBpLogKpi record);

    int insertSelective(CalTimeseqBpLogKpi record);

    List<CalTimeseqBpLogKpi> selectByExample(CalTimeseqBpLogKpiExample example);

    CalTimeseqBpLogKpi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTimeseqBpLogKpi record);

    int updateByPrimaryKey(CalTimeseqBpLogKpi record);
}