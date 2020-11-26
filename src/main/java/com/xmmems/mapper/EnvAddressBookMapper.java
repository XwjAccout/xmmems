package com.xmmems.mapper;

import com.xmmems.domain.env.EnvAddressBook;
import com.xmmems.domain.env.EnvAddressBookExample;
import java.util.List;

public interface EnvAddressBookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvAddressBook record);

    int insertSelective(EnvAddressBook record);

    List<EnvAddressBook> selectByExample(EnvAddressBookExample example);

    EnvAddressBook selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvAddressBook record);

    int updateByPrimaryKey(EnvAddressBook record);
}