package com.xmmems.mapper;

import com.xmmems.domain.ZeroCheck;
import com.xmmems.domain.ZeroCheckExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ZeroCheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZeroCheck record);

    int insertSelective(ZeroCheck record);

    List<ZeroCheck> selectByExample(ZeroCheckExample example);

    ZeroCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZeroCheck record);

    int updateByPrimaryKey(ZeroCheck record);

    List<ZeroCheck> findGenTime(@Param("gtnTime") String gtnTime, @Param("siteId") Integer siteId,@Param("type") int type,@Param("itemId") int itemId);

    @Select("select * from zero_check where itemId=#{itemId} and  siteId=#{siteId} and type=#{type} ORDER BY  genTime desc limit 0,1 ")
    ZeroCheck findFinally(@Param("itemId") Integer itemId,@Param("siteId") Integer siteId,@Param("type")String type);

    //type 1:零点漂移 2:跨度漂移
    List<ZeroCheck> selectZeroData(@Param("start") String start,@Param("end") String end,@Param("siteId") Integer siteId,@Param("type")Integer type);

    List<Map<String, String>> selectStandardVerification(@Param("start") String start, @Param("end") String end, @Param("siteId") Integer siteId,@Param("itemId")Integer itemId);

    List<Map<String, String>> blankTest(@Param("start") String start, @Param("end") String end, @Param("siteId") Integer siteId,@Param("itemId")Integer itemId);

    //获取有零点核查跨度核查数据的站点信息
    List<Map<String, Object>> site(@Param("accountId") Integer accountId);
}