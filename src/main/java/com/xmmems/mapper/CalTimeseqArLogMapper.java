package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTimeseqArLog;
import com.xmmems.domain.cal.CalTimeseqArLogExample;
import java.util.List;

public interface CalTimeseqArLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTimeseqArLog record);

    int insertSelective(CalTimeseqArLog record);

    List<CalTimeseqArLog> selectByExample(CalTimeseqArLogExample example);

    CalTimeseqArLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTimeseqArLog record);

    int updateByPrimaryKey(CalTimeseqArLog record);
}