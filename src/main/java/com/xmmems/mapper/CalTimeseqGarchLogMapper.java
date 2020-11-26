package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTimeseqGarchLog;
import com.xmmems.domain.cal.CalTimeseqGarchLogExample;
import java.util.List;

public interface CalTimeseqGarchLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTimeseqGarchLog record);

    int insertSelective(CalTimeseqGarchLog record);

    List<CalTimeseqGarchLog> selectByExample(CalTimeseqGarchLogExample example);

    CalTimeseqGarchLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTimeseqGarchLog record);

    int updateByPrimaryKey(CalTimeseqGarchLog record);
}