package com.xmmems.mapper;

import com.xmmems.domain.base.BaseAnalysisway;
import com.xmmems.domain.base.BaseAnalysiswayExample;
import java.util.List;

public interface BaseAnalysiswayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseAnalysisway record);

    int insertSelective(BaseAnalysisway record);

    List<BaseAnalysisway> selectByExample(BaseAnalysiswayExample example);

    BaseAnalysisway selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseAnalysisway record);

    int updateByPrimaryKey(BaseAnalysisway record);
}