package com.xmmems.mapper;

import com.xmmems.domain.ZeroCheckHandled;
import com.xmmems.domain.ZeroCheckHandledExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ZeroCheckHandledMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZeroCheckHandled record);

    int insertSelective(ZeroCheckHandled record);

    List<ZeroCheckHandled> selectByExampleWithBLOBs(ZeroCheckHandledExample example);

    List<ZeroCheckHandled> selectByExample(ZeroCheckHandledExample example);

    ZeroCheckHandled selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZeroCheckHandled record);

    int updateByPrimaryKeyWithBLOBs(ZeroCheckHandled record);

    int updateByPrimaryKey(ZeroCheckHandled record);

    @Select("select * from zero_check_handled order by receiveId asc ")
    List<ZeroCheckHandled> selectAll();

    List<ZeroCheckHandled> findGenTime(@Param("gtnTime") String gtnTime, @Param("receiveId") Integer receiveId,@Param("siteId") Integer siteId );

    @Select("select * from zero_check_handled where  receiveId=#{receiveId} and siteId=#{siteId} ORDER BY  genTime desc limit 0,2 ")
    List<ZeroCheckHandled> findFinally( @Param("receiveId") Integer receiveId,@Param("siteId") Integer siteId);

    //receiveId = 2 代表跨度
    @Select("SELECT content,DATE_FORMAT(genTime,'%Y-%m-%d %H:%i:00') genTime FROM zero_check_handled WHERE receiveId = 2 AND siteId = #{siteId} AND genTime >= #{start} AND genTime < #{end} ORDER BY genTime DESC")
    List<Map<String, String>> selectStandardVerification(@Param("start") String start, @Param("end") String end, @Param("siteId") Integer siteId);
}