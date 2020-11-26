package com.xmmems.mapper;

import com.xmmems.domain.account.AccountSiteExample;
import com.xmmems.domain.account.AccountSiteKey;
import java.util.List;

public interface AccountSiteMapper {
    int deleteByPrimaryKey(AccountSiteKey key);

    int insert(AccountSiteKey record);

    int insertSelective(AccountSiteKey record);

    List<AccountSiteKey> selectByExample(AccountSiteExample example);
}