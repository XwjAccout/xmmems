package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTimeseqArLogKpi;
import com.xmmems.domain.cal.CalTimeseqArLogKpiExample;
import java.util.List;

public interface CalTimeseqArLogKpiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTimeseqArLogKpi record);

    int insertSelective(CalTimeseqArLogKpi record);

    List<CalTimeseqArLogKpi> selectByExample(CalTimeseqArLogKpiExample example);

    CalTimeseqArLogKpi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTimeseqArLogKpi record);

    int updateByPrimaryKey(CalTimeseqArLogKpi record);
}