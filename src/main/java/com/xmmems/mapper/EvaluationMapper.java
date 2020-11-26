package com.xmmems.mapper;

import com.xmmems.domain.Evaluation;
import com.xmmems.domain.EvaluationExample;
import java.util.List;

public interface EvaluationMapper {
    int insert(Evaluation record);

    int insertSelective(Evaluation record);

    List<Evaluation> selectByExample(EvaluationExample example);
}