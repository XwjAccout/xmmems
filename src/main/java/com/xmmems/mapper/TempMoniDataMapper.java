package com.xmmems.mapper;

import com.xmmems.domain.temp.TempMoniData;
import com.xmmems.domain.temp.TempMoniDataExample;
import java.util.List;

public interface TempMoniDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TempMoniData record);

    int insertSelective(TempMoniData record);

    List<TempMoniData> selectByExample(TempMoniDataExample example);

    TempMoniData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempMoniData record);

    int updateByPrimaryKey(TempMoniData record);
}