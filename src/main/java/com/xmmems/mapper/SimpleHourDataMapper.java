package com.xmmems.mapper;

import com.xmmems.analyze.dto.ClusterHourDto;
import com.xmmems.domain.SimpleHourData;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SimpleHourDataMapper extends Mapper<SimpleHourData> {

    List<Map<String, String>> select50(@Param("siteId") Integer siteId, @Param("itemId") Integer itemId);

    List<Map<String, String>> selectPreValue(@Param("siteId") Integer siteId, @Param("itemId") Integer itemId, @Param("start") String start, @Param("end") String end);

    List<ClusterHourDto> selectCluster(@Param("start") String start, @Param("end") String end, @Param("siteId") Integer siteId, @Param("itemIds") List<Integer> itemIds);

    List<String> selectValues(@Param("siteId") Integer siteId, @Param("itemId") Integer itemId, @Param("start") String start, @Param("end") String end, @Param("space") Integer space, @Param("count") Integer count);

    Integer selectValuesCount(@Param("siteId") Integer siteId, @Param("itemId") Integer itemId, @Param("start") String start, @Param("end") String end);

    List<Map<String, String>> selectPreValue1(@Param("siteId") Integer siteId, @Param("itemId") Integer itemId, @Param("start") String start, @Param("end") String end);

    List<Map<String, String>> selectPreValue2(@Param("siteId") Integer siteId, @Param("itemId") Integer itemId, @Param("start") String start, @Param("end") String end);

    List<Map<String, String>> selectPreValue3(@Param("siteId") Integer siteId, @Param("itemId") Integer itemId, @Param("start") String start, @Param("end") String end);

    List<Map<String, String>> selectValue(@Param("siteId") Integer siteId, @Param("itemId") Integer itemId, @Param("start") String start, @Param("end") String end);

    List<Map<String, String>> selectByItemName(@Param("siteIds") List<Integer> siteIds, @Param("itemName") String itemName);

    Map<String,String> selectLastValueBySiteIdAndItemId(@Param("siteId") Integer siteId, @Param("itemId") String itemId, @Param("timeStr") String timeStr);

    List<Map<String, Object>> selectBySiteIdsLength(@Param("time") String time);

    List<Map<String, Integer>> selectValidSiteIdAndItems(Integer loginId);
}
