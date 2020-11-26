package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTimeseqLstmLog;
import com.xmmems.domain.cal.CalTimeseqLstmLogExample;
import java.util.List;

public interface CalTimeseqLstmLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTimeseqLstmLog record);

    int insertSelective(CalTimeseqLstmLog record);

    List<CalTimeseqLstmLog> selectByExample(CalTimeseqLstmLogExample example);

    CalTimeseqLstmLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTimeseqLstmLog record);

    int updateByPrimaryKey(CalTimeseqLstmLog record);
}