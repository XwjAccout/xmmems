package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTimeseqArResult;
import com.xmmems.domain.cal.CalTimeseqArResultExample;
import java.util.List;

public interface CalTimeseqArResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTimeseqArResult record);

    int insertSelective(CalTimeseqArResult record);

    List<CalTimeseqArResult> selectByExampleWithBLOBs(CalTimeseqArResultExample example);

    List<CalTimeseqArResult> selectByExample(CalTimeseqArResultExample example);

    CalTimeseqArResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTimeseqArResult record);

    int updateByPrimaryKeyWithBLOBs(CalTimeseqArResult record);

    int updateByPrimaryKey(CalTimeseqArResult record);
}