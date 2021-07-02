package com.xmmems.mapper;

import com.xmmems.domain.base.BaseSiteitem;
import com.xmmems.domain.base.BaseSiteitemExample;
import com.xmmems.dto.BaseSiteitemDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BaseSiteitemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseSiteitem record);

    int insertSelective(BaseSiteitem record);

    List<BaseSiteitem> selectByExample(BaseSiteitemExample example);

    BaseSiteitem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseSiteitem record);

    int updateByPrimaryKey(BaseSiteitem record);

    @Select("select bs.*,bi.unit from base_siteitem bs left join base_item bi on bs.itemId=bi.id where bs.siteId=#{siteId} order by isValid desc, sort asc")
    List<BaseSiteitemDTO> siteItemGetItemsBySiteId(Integer siteId);

    @Select("select bs.*,bi.unit,bi.code from base_siteitem bs left join base_item bi on bs.itemId=bi.id where bs.isValid=1 and bs.siteId=#{siteId} order by sort asc")
    List<BaseSiteitemDTO> getColumns(Integer siteId);

    @Select("select bs.*,bi.unit,bi.code from base_siteitem bs left join base_item bi on bs.itemId=bi.id where bs.isValid=1 order by sort asc")
    List<BaseSiteitemDTO> getAllColumns();

    @Select("select bs.*,bi.unit from base_siteitem bs left join base_item bi on bs.itemId=bi.id where bs.isValid=1 and siteId in(${siteidlist})  GROUP BY bs.itemName  order by sort asc")
    List<BaseSiteitemDTO> getColumnsAll(@Param("siteidlist") String siteidlist);

    @Select("select * from base_siteitem t where t.siteId = #{siteId} and t.isValid='1' order by sort asc")
    List<BaseSiteitem> getSiteItem(Integer siteId);

    List<Map<String, String>> getSiteItemAll(@Param("ids") List<Object> ids);

    @Select("select * from base_siteitem where siteId=#{siteId} and sort=#{sort} ORDER BY sort")
    BaseSiteitem getSiteItemsort(@Param("siteId") Integer siteId, @Param("sort") Integer sort);

    @Delete("delete from `base_siteitem` where siteId=#{siteId} and itemId=#{itemId}")
    int delItem(@Param("siteId") Integer siteId, @Param("itemId") Integer itemId);

    @Select("SELECT number FROM `base_siteitem` WHERE siteId = #{siteId} AND itemName = #{itemName}")
    Integer selectBySiteIdAndItemName(@Param("siteId") Integer siteId, @Param("itemName") String itemName);

    @Select("SELECT cast(itemId as char) as itemId ,itemName,cast(number as char) as number FROM `base_siteitem` WHERE siteId = #{siteId}")
    List<Map<String, String>> selectBySiteId(Integer siteId);

    int insertBaseSiteItem(@Param("siteId") Integer siteId, @Param("itemId") Integer itemId, @Param("siteName") String siteName, @Param("itemName") String itemName);

    @Select("select cast(itemId as char) as itemId , limitNum from base_siteitem where siteId = #{siteId}")
    List<Map<String, String>> getDetectionLimit(Integer siteId);

    int updateDetectionLimit(@Param("siteId") Integer siteId, @Param("itemId") Integer itemId, @Param("limit") String limit);

    int updateSort(@Param("siteId") Integer siteId, @Param("itemId") Integer itemId, @Param("sort") Double sort);

    int updateNumber(@Param("siteId") Integer siteId, @Param("itemId") Integer itemId, @Param("number") Integer number);

    //获取所有站点id，项目id中间表数据
    List<Map<String, Integer>> getValidSiteIdItemId();

    @Select("select * from base_siteitem where itemId=27")
    List<BaseSiteitem> selectBysite();

    List<Map<String, String>> selectByAccountId(Integer loginId);

    Integer selectNumber(@Param("siteId") Integer siteId,@Param("itemId") Integer itemId);
}