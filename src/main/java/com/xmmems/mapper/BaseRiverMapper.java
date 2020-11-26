package com.xmmems.mapper;

import com.xmmems.domain.base.BaseRiver;
import com.xmmems.domain.base.BaseRiverExample;
import java.util.List;

public interface BaseRiverMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseRiver record);

    int insertSelective(BaseRiver record);

    List<BaseRiver> selectByExample(BaseRiverExample example);

    BaseRiver selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseRiver record);

    int updateByPrimaryKey(BaseRiver record);
}