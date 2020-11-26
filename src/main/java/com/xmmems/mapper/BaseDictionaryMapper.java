package com.xmmems.mapper;

import com.xmmems.domain.base.BaseDictionary;
import com.xmmems.domain.base.BaseDictionaryExample;
import com.xmmems.domain.base.BaseDictionaryWithBLOBs;
import java.util.List;

public interface BaseDictionaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseDictionaryWithBLOBs record);

    int insertSelective(BaseDictionaryWithBLOBs record);

    List<BaseDictionaryWithBLOBs> selectByExampleWithBLOBs(BaseDictionaryExample example);

    List<BaseDictionary> selectByExample(BaseDictionaryExample example);

    BaseDictionaryWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseDictionaryWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BaseDictionaryWithBLOBs record);

    int updateByPrimaryKey(BaseDictionary record);
}