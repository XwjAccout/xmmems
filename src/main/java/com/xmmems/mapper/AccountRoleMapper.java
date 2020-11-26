package com.xmmems.mapper;

import com.xmmems.domain.account.AccountRoleExample;
import com.xmmems.domain.account.AccountRoleKey;
import java.util.List;

public interface AccountRoleMapper {
    int deleteByPrimaryKey(AccountRoleKey key);

    int insert(AccountRoleKey record);

    int insertSelective(AccountRoleKey record);

    List<AccountRoleKey> selectByExample(AccountRoleExample example);
}