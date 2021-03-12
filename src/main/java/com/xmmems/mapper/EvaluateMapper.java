package com.xmmems.mapper;

import com.xmmems.domain.Evaluate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EvaluateMapper {
    @Select("select * from evaluate where uId=#{uId}")
    Evaluate findbyUid(@Param("uId")Integer uId);

    int  add(Evaluate evaluate);
}
