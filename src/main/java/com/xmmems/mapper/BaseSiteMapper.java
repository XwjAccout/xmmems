package com.xmmems.mapper;

import com.xmmems.domain.base.BaseSite;
import com.xmmems.domain.base.BaseSiteExample;
import com.xmmems.dto.BaseSiteDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BaseSiteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseSite record);

    int insertSelective(BaseSite record);

    List<BaseSite> selectByExample(BaseSiteExample example);

    BaseSite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseSite record);

    int updateByPrimaryKey(BaseSite record);

    List<BaseSite> selectByExampleByAccountId(
            @Param("accountId") Integer accountId,
            @Param("siteName") String siteName, @Param("siteType") String siteType);

    @Select("select * from account_site asite,base_site bsite where asite.accountId = #{accountId} and bsite.id = asite.siteId and bsite.isvalid = 1 order by bsite.sort")
    List<BaseSiteDTO> getSites(Integer accountId);

    @Select("select * from base_site where isvalid = 1")
    List<BaseSite> getBaseSites();

    List<Map<String, Object>> getSiteIdAndNameByAccountId(
            @Param("accountId") Integer accountId, @Param("siteType") String siteType);

    @Select("select distinct z.siteId,z.siteName from zero_check z,account_site a where z.`siteId` = a.`siteId` and a.`accountId` = #{accountId} ")
    List<Map<String, Object>> getSiteIdAndNameExcludeZeroCheck(Integer accountId);

}