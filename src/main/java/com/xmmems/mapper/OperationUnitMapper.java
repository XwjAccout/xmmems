package com.xmmems.mapper;

import com.xmmems.domain.OperationUnit;
import com.xmmems.domain.OperationUnitExample;
import java.util.List;

public interface OperationUnitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OperationUnit record);

    int insertSelective(OperationUnit record);

    List<OperationUnit> selectByExample(OperationUnitExample example);

    OperationUnit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperationUnit record);

    int updateByPrimaryKey(OperationUnit record);
}