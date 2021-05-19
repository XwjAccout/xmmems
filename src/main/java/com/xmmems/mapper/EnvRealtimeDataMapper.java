package com.xmmems.mapper;

import com.xmmems.domain.env.EnvRealtimeData;
import com.xmmems.domain.env.EnvRealtimeDataExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface EnvRealtimeDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvRealtimeData record);

    int insertSelective(EnvRealtimeData record);

    List<EnvRealtimeData> selectByExampleWithBLOBs(EnvRealtimeDataExample example);

    List<EnvRealtimeData> selectByExample(EnvRealtimeDataExample example);

    EnvRealtimeData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvRealtimeData record);

    int updateByPrimaryKeyWithBLOBs(EnvRealtimeData record);

    int updateByPrimaryKey(EnvRealtimeData record);

    @Select("select count(1) from env_realtime_data where siteId = #{siteId}")
    Integer getSiteId(@Param("siteId") Integer siteId);

    List<Map<String, Object>> getRealTimeData(@Param("accountId") Integer accountId,@Param("siteType") String siteType);

    @Select("select * from env_realtime_data ")
    List<EnvRealtimeData> getRealTimeDataNoaccountId(@Param("order") String order);
}