package com.xmmems.mapper;

import com.xmmems.domain.base.BaseItem;
import com.xmmems.domain.base.BaseItemExample;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BaseItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseItem record);

    int insertSelective(BaseItem record);

    List<BaseItem> selectByExample(BaseItemExample example);

    BaseItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseItem record);

    int updateByPrimaryKey(BaseItem record);

    @Select("select `name`,digits from base_item")
    List<Map<String, Object>> selectNameAndDigits();

    @Select("select * from base_item where isvalid = 1 and name = #{itemName} LIMIT 1")
    BaseItem selectByName(String itemName);

    @Select("select id,`code`,`name` from base_item  where isvalid = 1 and often = #{often}")
    List<Map<String, Object>> findAllByOftaa(String often);

    @Select("select rank from base_item where id =#{itemId}")
    String selectRankByItemId(Integer itemId);

    @Select("SELECT digits FROM base_item WHERE id =#{itemId}")
    Integer selectScale(Integer itemId);
}