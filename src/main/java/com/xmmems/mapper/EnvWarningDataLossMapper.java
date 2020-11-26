package com.xmmems.mapper;

import com.xmmems.domain.EnvWarningDataLoss;
import com.xmmems.domain.EnvWarningDataLossExample;
import java.util.List;

public interface EnvWarningDataLossMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvWarningDataLoss record);

    int insertSelective(EnvWarningDataLoss record);

    List<EnvWarningDataLoss> selectByExample(EnvWarningDataLossExample example);

    EnvWarningDataLoss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvWarningDataLoss record);

    int updateByPrimaryKey(EnvWarningDataLoss record);
}