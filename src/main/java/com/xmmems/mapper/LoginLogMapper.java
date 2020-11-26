package com.xmmems.mapper;

import com.xmmems.domain.role.LoginLog;
import com.xmmems.domain.role.LoginLogExample;
import java.util.List;

public interface LoginLogMapper {
    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    List<LoginLog> selectByExample(LoginLogExample example);
}