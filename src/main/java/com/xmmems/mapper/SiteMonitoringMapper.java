package com.xmmems.mapper;

import com.xmmems.domain.site.SiteMonitoring;
import com.xmmems.domain.site.SiteMonitoringExample;
import java.util.List;

public interface SiteMonitoringMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SiteMonitoring record);

    int insertSelective(SiteMonitoring record);

    List<SiteMonitoring> selectByExample(SiteMonitoringExample example);

    SiteMonitoring selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SiteMonitoring record);

    int updateByPrimaryKey(SiteMonitoring record);
}