package com.xmmems.mapper;

import com.xmmems.domain.env.EnvKnowledge;
import com.xmmems.domain.env.EnvKnowledgeExample;
import java.util.List;

public interface EnvKnowledgeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvKnowledge record);

    int insertSelective(EnvKnowledge record);

    List<EnvKnowledge> selectByExample(EnvKnowledgeExample example);

    EnvKnowledge selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvKnowledge record);

    int updateByPrimaryKey(EnvKnowledge record);
}