package com.xmmems.mapper;

import com.xmmems.domain.OperationVehicle;
import com.xmmems.domain.OperationVehicleExample;
import java.util.List;

public interface OperationVehicleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OperationVehicle record);

    int insertSelective(OperationVehicle record);

    List<OperationVehicle> selectByExample(OperationVehicleExample example);

    OperationVehicle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperationVehicle record);

    int updateByPrimaryKey(OperationVehicle record);
}