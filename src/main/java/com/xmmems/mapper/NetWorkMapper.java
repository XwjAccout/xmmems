package com.xmmems.mapper;

import com.xmmems.domain.NetWork;
import com.xmmems.domain.NetWorkExample;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NetWorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NetWork record);

    int insertSelective(NetWork record);

    List<NetWork> selectByExample(NetWorkExample example);

    NetWork selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NetWork record);

    int updateByPrimaryKey(NetWork record);

    @Select("SELECT * FROM network WHERE siteId = #{siteId} ORDER BY `date` DESC LIMIT 1")
    NetWork selectLastOneBySiteId(String siteId);

    @Select("select * from account_site as a,network as s where a.siteId=s.siteId and a.accountId=#{accountId} and date =#{date} GROUP BY s.siteId")
    List<NetWork> selectByExampleByAccountId(Integer accountId ,String date);
}