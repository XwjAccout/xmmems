package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTimeseqBpLog;
import com.xmmems.domain.cal.CalTimeseqBpLogExample;
import java.util.List;

public interface CalTimeseqBpLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTimeseqBpLog record);

    int insertSelective(CalTimeseqBpLog record);

    List<CalTimeseqBpLog> selectByExample(CalTimeseqBpLogExample example);

    CalTimeseqBpLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTimeseqBpLog record);

    int updateByPrimaryKey(CalTimeseqBpLog record);
}