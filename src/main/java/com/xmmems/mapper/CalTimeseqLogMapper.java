package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTimeseqLog;
import com.xmmems.domain.cal.CalTimeseqLogExample;
import java.util.List;

public interface CalTimeseqLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTimeseqLog record);

    int insertSelective(CalTimeseqLog record);

    List<CalTimeseqLog> selectByExample(CalTimeseqLogExample example);

    CalTimeseqLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTimeseqLog record);

    int updateByPrimaryKey(CalTimeseqLog record);
}