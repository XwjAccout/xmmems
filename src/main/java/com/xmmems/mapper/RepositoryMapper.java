package com.xmmems.mapper;

import com.xmmems.domain.Repository;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface RepositoryMapper extends Mapper<Repository> {
    @Update("UPDATE `repository` SET `url` = #{url} WHERE `id` = #{id} ")
    Integer updateUrl(@Param("id") Integer id, @Param("url") String url);
}