package com.xmmems.mapper;

import com.xmmems.domain.cal.CalTrendMannKendallResult;
import com.xmmems.domain.cal.CalTrendMannKendallResultExample;
import java.util.List;

public interface CalTrendMannKendallResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalTrendMannKendallResult record);

    int insertSelective(CalTrendMannKendallResult record);

    List<CalTrendMannKendallResult> selectByExampleWithBLOBs(CalTrendMannKendallResultExample example);

    List<CalTrendMannKendallResult> selectByExample(CalTrendMannKendallResultExample example);

    CalTrendMannKendallResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalTrendMannKendallResult record);

    int updateByPrimaryKeyWithBLOBs(CalTrendMannKendallResult record);

    int updateByPrimaryKey(CalTrendMannKendallResult record);
}