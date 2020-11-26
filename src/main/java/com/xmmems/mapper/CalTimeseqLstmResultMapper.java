package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTimeseqLstmResult;
import com.xmmems.domain.cal.CalTimeseqLstmResultExample;
import java.util.List;

public interface CalTimeseqLstmResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTimeseqLstmResult record);

    int insertSelective(CalTimeseqLstmResult record);

    List<CalTimeseqLstmResult> selectByExampleWithBLOBs(CalTimeseqLstmResultExample example);

    List<CalTimeseqLstmResult> selectByExample(CalTimeseqLstmResultExample example);

    CalTimeseqLstmResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTimeseqLstmResult record);

    int updateByPrimaryKeyWithBLOBs(CalTimeseqLstmResult record);

    int updateByPrimaryKey(CalTimeseqLstmResult record);
}