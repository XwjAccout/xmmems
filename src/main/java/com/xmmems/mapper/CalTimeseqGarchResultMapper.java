package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTimeseqGarchResult;
import com.xmmems.domain.cal.CalTimeseqGarchResultExample;
import java.util.List;

public interface CalTimeseqGarchResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTimeseqGarchResult record);

    int insertSelective(CalTimeseqGarchResult record);

    List<CalTimeseqGarchResult> selectByExampleWithBLOBs(CalTimeseqGarchResultExample example);

    List<CalTimeseqGarchResult> selectByExample(CalTimeseqGarchResultExample example);

    CalTimeseqGarchResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTimeseqGarchResult record);

    int updateByPrimaryKeyWithBLOBs(CalTimeseqGarchResult record);

    int updateByPrimaryKey(CalTimeseqGarchResult record);
}