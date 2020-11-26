package com.xmmems.mapper;

import com.xmmems.domain.base.BaseSection;
import com.xmmems.domain.base.BaseSectionExample;
import java.util.List;

public interface BaseSectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseSection record);

    int insertSelective(BaseSection record);

    List<BaseSection> selectByExample(BaseSectionExample example);

    BaseSection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseSection record);

    int updateByPrimaryKey(BaseSection record);
}