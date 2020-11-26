package com.xmmems.mapper;

import com.xmmems.domain.Otherpower;
import com.xmmems.domain.OtherpowerExample;
import java.util.List;

public interface OtherpowerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Otherpower record);

    int insertSelective(Otherpower record);

    List<Otherpower> selectByExample(OtherpowerExample example);

    Otherpower selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Otherpower record);

    int updateByPrimaryKey(Otherpower record);
}