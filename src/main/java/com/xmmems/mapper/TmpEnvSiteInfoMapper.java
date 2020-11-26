 package com.xmmems.mapper;

import com.xmmems.domain.tmp.TmpEnvSiteInfo;
import com.xmmems.domain.tmp.TmpEnvSiteInfoExample;
import java.util.List;

public interface TmpEnvSiteInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TmpEnvSiteInfo record);

    int insertSelective(TmpEnvSiteInfo record);

    List<TmpEnvSiteInfo> selectByExample(TmpEnvSiteInfoExample example);

    TmpEnvSiteInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TmpEnvSiteInfo record);

    int updateByPrimaryKey(TmpEnvSiteInfo record);
}