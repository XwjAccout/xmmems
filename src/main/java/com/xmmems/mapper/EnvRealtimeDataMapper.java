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

    //@Select("select * from env_realtime_data rd,account_site mas where mas.accountId = #{accountId} and rd.siteId = mas.siteId")
    @Select("SELECT r.siteId,b.siteName,b.levelStandard,moniterTime,content FROM account_site a,base_site b,env_realtime_data r WHERE a.accountId = #{accountId} AND a.siteId=b.id AND r.siteId = a.siteId ")
    List<Map<String, Object>> getRealTimeData(@Param("accountId") Integer accountId);

    @Select("select * from env_realtime_data ")
    List<EnvRealtimeData> getRealTimeDataNoaccountId(@Param("order") String order);
}