package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTimeseqLstmLogKpi;
import com.xmmems.domain.cal.CalTimeseqLstmLogKpiExample;
import java.util.List;

public interface CalTimeseqLstmLogKpiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTimeseqLstmLogKpi record);

    int insertSelective(CalTimeseqLstmLogKpi record);

    List<CalTimeseqLstmLogKpi> selectByExample(CalTimeseqLstmLogKpiExample example);

    CalTimeseqLstmLogKpi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTimeseqLstmLogKpi record);

    int updateByPrimaryKey(CalTimeseqLstmLogKpi record);
}