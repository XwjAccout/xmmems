package com.xmmems.mapper;

import com.xmmems.domain.OperationPerson;
import com.xmmems.domain.OperationPersonExample;
import java.util.List;

public interface OperationPersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OperationPerson record);

    int insertSelective(OperationPerson record);

    List<OperationPerson> selectByExample(OperationPersonExample example);

    OperationPerson selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperationPerson record);

    int updateByPrimaryKey(OperationPerson record);
}