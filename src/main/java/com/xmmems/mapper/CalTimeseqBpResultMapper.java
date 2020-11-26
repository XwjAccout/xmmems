package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTimeseqBpResult;
import com.xmmems.domain.cal.CalTimeseqBpResultExample;
import java.util.List;

public interface CalTimeseqBpResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTimeseqBpResult record);

    int insertSelective(CalTimeseqBpResult record);

    List<CalTimeseqBpResult> selectByExampleWithBLOBs(CalTimeseqBpResultExample example);

    List<CalTimeseqBpResult> selectByExample(CalTimeseqBpResultExample example);

    CalTimeseqBpResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTimeseqBpResult record);

    int updateByPrimaryKeyWithBLOBs(CalTimeseqBpResult record);

    int updateByPrimaryKey(CalTimeseqBpResult record);
}