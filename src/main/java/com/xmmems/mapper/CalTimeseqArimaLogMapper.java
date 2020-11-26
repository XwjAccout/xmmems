package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTimeseqArimaLog;
import com.xmmems.domain.cal.CalTimeseqArimaLogExample;
import java.util.List;

public interface CalTimeseqArimaLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTimeseqArimaLog record);

    int insertSelective(CalTimeseqArimaLog record);

    List<CalTimeseqArimaLog> selectByExample(CalTimeseqArimaLogExample example);

    CalTimeseqArimaLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTimeseqArimaLog record);

    int updateByPrimaryKey(CalTimeseqArimaLog record);
}