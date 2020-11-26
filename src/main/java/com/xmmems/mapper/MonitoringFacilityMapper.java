package com.xmmems.mapper;

import com.xmmems.domain.MonitoringFacility;
import com.xmmems.domain.MonitoringFacilityExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MonitoringFacilityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MonitoringFacility record);

    int insertSelective(MonitoringFacility record);

    List<MonitoringFacility> selectByExample(MonitoringFacilityExample example);

    MonitoringFacility selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MonitoringFacility record);

    int updateByPrimaryKey(MonitoringFacility record);

    @Select("select * from monitoring_facility where unitID=#{unitId}")
    List<MonitoringFacility> selectByUnitId(@Param("unitId") Integer unitId);
}