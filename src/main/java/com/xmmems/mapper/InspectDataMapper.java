package com.xmmems.mapper;

import com.xmmems.domain.InspectData;
import com.xmmems.domain.InspectDataExample;
import java.util.List;

public interface InspectDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InspectData record);

    int insertSelective(InspectData record);

    List<InspectData> selectByExample(InspectDataExample example);

    InspectData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InspectData record);

    int updateByPrimaryKey(InspectData record);
}