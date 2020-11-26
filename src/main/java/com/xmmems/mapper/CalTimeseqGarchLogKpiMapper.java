package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTimeseqGarchLogKpi;
import com.xmmems.domain.cal.CalTimeseqGarchLogKpiExample;
import java.util.List;

public interface CalTimeseqGarchLogKpiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTimeseqGarchLogKpi record);

    int insertSelective(CalTimeseqGarchLogKpi record);

    List<CalTimeseqGarchLogKpi> selectByExample(CalTimeseqGarchLogKpiExample example);

    CalTimeseqGarchLogKpi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTimeseqGarchLogKpi record);

    int updateByPrimaryKey(CalTimeseqGarchLogKpi record);
}