package com.xmmems.mapper;

import com.xmmems.domain.base.BaseArea;
import com.xmmems.domain.base.BaseAreaExample;
import java.util.List;

public interface BaseAreaMapper {
    int deleteByPrimaryKey(Long idx);

    int insert(BaseArea record);

    int insertSelective(BaseArea record);

    List<BaseArea> selectByExample(BaseAreaExample example);

    BaseArea selectByPrimaryKey(Long idx);

    int updateByPrimaryKeySelective(BaseArea record);

    int updateByPrimaryKey(BaseArea record);
}