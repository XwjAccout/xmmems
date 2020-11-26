package com.xmmems.mapper;


import com.xmmems.domain.env.EnvHourData;
import com.xmmems.domain.env.EnvHourDataExample;
import com.xmmems.dto.BaseSiteitemDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface EnvHourDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvHourData record);

    int insertSelective(EnvHourData record);

    List<EnvHourData> selectByExampleWithBLOBs(EnvHourDataExample example);

    List<EnvHourData> selectByExample(EnvHourDataExample example);

    EnvHourData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvHourData record);

    int updateByPrimaryKeyWithBLOBs(EnvHourData record);

    int updateByPrimaryKey(EnvHourData record);

    List<Map<String, Object>> monitorReportDayGetData(@Param("siteId") Integer siteId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    @Select("select * from env_hour_data where siteId=#{siteId} and genTime like #{time}")
    List<Map<String, Object>> selectWeek(@Param("siteId") Integer siteId, @Param("time") String time);

    List<Map<String, Object>> selectHistoryData(@Param("siteId") Integer siteId, @Param("startTime") String startTime, @Param("endTime") String endTime,@Param("order") String order);

    @Select("select * from env_hour_data where siteId=#{siteId} and DATE_FORMAT(genTime,'%Y-%m-%d %H:00:00')=#{mtime}")
    EnvHourData selectBySiteIdAndGenTime(@Param("siteId") Integer siteId, @Param("mtime") String mtime);

    @Select("select * from env_hour_data where siteId=#{siteId} and genTime=#{mtime}")
    EnvHourData selectBySiteIdAndGenTimeNumber(@Param("siteId") Integer siteId, @Param("mtime") String mtime);

    //注意，这里的limit 8 是因为env_hour_data 数据里面有些参数（监测因子或监测项目，如氟化物之类的是2小时测试一遍或者4小时测试一遍，但是前面的
    // 五个参数（温度，ph）是一小时测试一遍的，所以如氟化物之类的会间隔没有数据，单参数无法比较，需要多获取几条）
    @Select("select content from env_hour_data where siteName = #{siteName} order by genTime desc limit 8")
    List<String> selectContentLimitEight(String siteName);

    //按月份查询  month  2020-01
    @Select("select * from env_hour_data where siteId=#{siteId} and genTime like #{month}")
    List<Map<String, Object>> selectBySiteIdAndLikeMonth(@Param("siteId") Integer siteId, @Param("month") String month);

    List<Map<String, String>> selectContentByInSiteName(@Param("siteNameList") List<String> siteNameList);

    @Select("select * from env_hour_data where siteId=#{siteId} ORDER BY genTime desc limit 1")
    EnvHourData findLast(@Param("siteId") Integer siteId);

    //获取前一千条未存入simhourdata的数据，即handle = false
    List<EnvHourData> select1000();

    int updateHandle(int id);

    @Select("select bs.*,bi.unit from base_siteitem bs left join base_item bi on bs.itemId=bi.id where bs.siteId=#{siteId} and bs.itemId=#{itemId} order by isValid desc, sort asc")
    BaseSiteitemDTO siteItemGetItemsBySiteIdAnditemId(@Param("siteId") Integer siteId,@Param("itemId") Integer itemId);

    List<String> selectContent(@Param("siteId") Integer siteId,@Param("start") String start,@Param("end") String end);
}