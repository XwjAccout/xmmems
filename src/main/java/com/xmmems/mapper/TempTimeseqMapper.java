package com.xmmems.mapper;

import com.xmmems.domain.temp.TempTimeseq;
import com.xmmems.domain.temp.TempTimeseqExample;
import java.util.List;

public interface TempTimeseqMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TempTimeseq record);

    int insertSelective(TempTimeseq record);

    List<TempTimeseq> selectByExample(TempTimeseqExample example);

    TempTimeseq selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempTimeseq record);

    int updateByPrimaryKey(TempTimeseq record);
}