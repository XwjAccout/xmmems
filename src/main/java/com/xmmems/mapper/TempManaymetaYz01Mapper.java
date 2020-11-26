package com.xmmems.mapper;

import com.xmmems.domain.temp.TempManaymetaYz01;
import com.xmmems.domain.temp.TempManaymetaYz01Example;
import java.util.List;

public interface TempManaymetaYz01Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TempManaymetaYz01 record);

    int insertSelective(TempManaymetaYz01 record);

    List<TempManaymetaYz01> selectByExample(TempManaymetaYz01Example example);

    TempManaymetaYz01 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempManaymetaYz01 record);

    int updateByPrimaryKey(TempManaymetaYz01 record);
}