package com.xmmems.mapper;

import com.xmmems.domain.env.EnvSiteInfo;
import com.xmmems.domain.env.EnvSiteInfoExample;
import java.util.List;

public interface EnvSiteInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvSiteInfo record);

    int insertSelective(EnvSiteInfo record);

    List<EnvSiteInfo> selectByExample(EnvSiteInfoExample example);

    EnvSiteInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvSiteInfo record);

    int updateByPrimaryKey(EnvSiteInfo record);
}