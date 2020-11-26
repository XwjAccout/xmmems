package com.xmmems.mapper;

import com.xmmems.domain.Session;
import com.xmmems.domain.SessionExample;
import java.util.List;

public interface SessionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Session record);

    int insertSelective(Session record);

    List<Session> selectByExample(SessionExample example);

    Session selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Session record);

    int updateByPrimaryKey(Session record);
}