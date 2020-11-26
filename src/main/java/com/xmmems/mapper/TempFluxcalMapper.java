package com.xmmems.mapper;

import com.xmmems.domain.temp.TempFluxcal;
import com.xmmems.domain.temp.TempFluxcalExample;
import java.util.List;

public interface TempFluxcalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TempFluxcal record);

    int insertSelective(TempFluxcal record);

    List<TempFluxcal> selectByExample(TempFluxcalExample example);

    TempFluxcal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempFluxcal record);

    int updateByPrimaryKey(TempFluxcal record);
}