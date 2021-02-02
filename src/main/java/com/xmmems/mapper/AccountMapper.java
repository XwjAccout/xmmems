package com.xmmems.mapper;

import com.xmmems.domain.account.Account;
import com.xmmems.domain.account.AccountExample;
import com.xmmems.domain.base.BaseSite;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    List<Account> selectByExample(AccountExample example);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    @Select("SELECT * FROM account WHERE username = #{username}")
    Account findByName(String username);

    @Insert("insert into account_role(accountId, roleId) values(#{accountId}, #{roleId})")
    int insertAccountIdAndRoleId(@Param("accountId") Integer accountId,@Param("roleId") Integer roleId);

    @Delete("delete from account_role where accountId=#{accountId} and roleId=#{roleId}")
    int deleteAccountIdAndRoleId(@Param("accountId") Integer accountId,@Param("roleId") Integer roleId);

    @Insert("insert into account_site(accountId, siteId) values(#{accountId}, #{siteId})")
    int insertAccountIdAndSiteId(@Param("accountId") Integer accountId,@Param("siteId") Integer siteId);

    @Delete("delete from account_site where accountId=#{accountId} and siteId=#{siteId}")
    int deleteAccountIdAndSiteId(@Param("accountId") Integer accountId,@Param("siteId") Integer siteId);
    @Update("update account set  password =#{password} , userName=#{userName} where id=#{id} ")
    int updatePassword(@Param("password") String password,@Param("userName") String userName, @Param("id") Integer id);

    @Select("SELECT * FROM `account` WHERE id = #{id}")
    Account selectById(Integer id);
    @Select(" SELECT * from base_site b,account a where b.id=a.centerSiteId and a.id=#{id}")
    BaseSite findBycenterSiteId(@Param("id") Integer id);
}