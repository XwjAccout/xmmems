package com.xmmems.mapper;

import com.xmmems.domain.SpanCheckHandled;
import com.xmmems.domain.SpanCheckHandledExample;

import java.util.List;

public interface SpanCheckHandledMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SpanCheckHandled record);

    int insertSelective(SpanCheckHandled record);

    List<SpanCheckHandled> selectByExampleWithBLOBs(SpanCheckHandledExample example);

    List<SpanCheckHandled> selectByExample(SpanCheckHandledExample example);

    SpanCheckHandled selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SpanCheckHandled record);

    int updateByPrimaryKeyWithBLOBs(SpanCheckHandled record);

    int updateByPrimaryKey(SpanCheckHandled record);
}