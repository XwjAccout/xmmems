package com.xmmems.mapper;

import com.xmmems.domain.env.EnvQualityConf;
import com.xmmems.domain.env.EnvQualityConfExample;
import com.xmmems.dto.EnvQualityConfDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EnvQualityConfMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvQualityConf record);

    int insertSelective(EnvQualityConf record);

    List<EnvQualityConf> selectByExample(EnvQualityConfExample example);

    EnvQualityConf selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvQualityConf record);

    int updateByPrimaryKey(EnvQualityConf record);

    @Select("select * from env_quality_conf where kpiName = #{itemName}")
    List<EnvQualityConf> selectByItemName(@Param("itemName") String itemName);

    @Select("select * from env_quality_conf where kpiName = #{itemName} ")
    List<EnvQualityConf> selectByItemNameAndAvg(@Param("itemName")String itemName,@Param("avg") String avg);

    List<EnvQualityConfDTO> getEnvQualityConfDTOList();
}