package com.xmmems.mapper;

import com.xmmems.domain.env.EnvEquipmentManager;
import com.xmmems.domain.env.EnvEquipmentManagerExample;
import java.util.List;

public interface EnvEquipmentManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvEquipmentManager record);

    int insertSelective(EnvEquipmentManager record);

    List<EnvEquipmentManager> selectByExample(EnvEquipmentManagerExample example);

    EnvEquipmentManager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvEquipmentManager record);

    int updateByPrimaryKey(EnvEquipmentManager record);
}