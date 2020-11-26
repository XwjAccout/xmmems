package com.xmmems.mapper;

import com.xmmems.domain.SensitiveWords;
import com.xmmems.domain.SensitiveWordsExample;
import java.util.List;

public interface SensitiveWordsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SensitiveWords record);

    int insertSelective(SensitiveWords record);

    List<SensitiveWords> selectByExample(SensitiveWordsExample example);

    SensitiveWords selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SensitiveWords record);

    int updateByPrimaryKey(SensitiveWords record);
}