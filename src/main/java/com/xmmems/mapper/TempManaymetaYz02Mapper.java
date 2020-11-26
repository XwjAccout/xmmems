package com.xmmems.mapper;

import com.xmmems.domain.temp.TempManaymetaYz02;
import com.xmmems.domain.temp.TempManaymetaYz02Example;
import java.util.List;

public interface TempManaymetaYz02Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TempManaymetaYz02 record);

    int insertSelective(TempManaymetaYz02 record);

    List<TempManaymetaYz02> selectByExample(TempManaymetaYz02Example example);

    TempManaymetaYz02 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempManaymetaYz02 record);

    int updateByPrimaryKey(TempManaymetaYz02 record);
}