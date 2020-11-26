package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTimeseqArimaResult;
import com.xmmems.domain.cal.CalTimeseqArimaResultExample;
import java.util.List;

public interface CalTimeseqArimaResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTimeseqArimaResult record);

    int insertSelective(CalTimeseqArimaResult record);

    List<CalTimeseqArimaResult> selectByExampleWithBLOBs(CalTimeseqArimaResultExample example);

    List<CalTimeseqArimaResult> selectByExample(CalTimeseqArimaResultExample example);

    CalTimeseqArimaResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTimeseqArimaResult record);

    int updateByPrimaryKeyWithBLOBs(CalTimeseqArimaResult record);

    int updateByPrimaryKey(CalTimeseqArimaResult record);
}