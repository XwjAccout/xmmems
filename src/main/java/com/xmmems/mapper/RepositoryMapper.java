package com.xmmems.mapper;

import com.xmmems.domain.Repository;
import com.xmmems.domain.RepositoryExample;
import java.util.List;

public interface RepositoryMapper {
    int insert(Repository record);

    int insertSelective(Repository record);

    List<Repository> selectByExample(RepositoryExample example);
}