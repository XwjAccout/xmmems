package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTimeseqResult;
import com.xmmems.domain.cal.CalTimeseqResultExample;
import java.util.List;

public interface CalTimeseqResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTimeseqResult record);

    int insertSelective(CalTimeseqResult record);

    List<CalTimeseqResult> selectByExample(CalTimeseqResultExample example);

    CalTimeseqResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTimeseqResult record);

    int updateByPrimaryKey(CalTimeseqResult record);
}