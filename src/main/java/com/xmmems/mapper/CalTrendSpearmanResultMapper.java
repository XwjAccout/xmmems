package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTrendSpearmanResult;
import com.xmmems.domain.cal.CalTrendSpearmanResultExample;
import java.util.List;

public interface CalTrendSpearmanResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTrendSpearmanResult record);

    int insertSelective(CalTrendSpearmanResult record);

    List<CalTrendSpearmanResult> selectByExampleWithBLOBs(CalTrendSpearmanResultExample example);

    List<CalTrendSpearmanResult> selectByExample(CalTrendSpearmanResultExample example);

    CalTrendSpearmanResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTrendSpearmanResult record);

    int updateByPrimaryKeyWithBLOBs(CalTrendSpearmanResult record);

    int updateByPrimaryKey(CalTrendSpearmanResult record);
}