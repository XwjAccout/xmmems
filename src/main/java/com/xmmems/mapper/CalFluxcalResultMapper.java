package com.xmmems.mapper;

import com.xmmems.domain.cal.CalFluxcalResult;
import com.xmmems.domain.cal.CalFluxcalResultExample;
import java.util.List;

public interface CalFluxcalResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalFluxcalResult record);

    int insertSelective(CalFluxcalResult record);

    List<CalFluxcalResult> selectByExample(CalFluxcalResultExample example);

    CalFluxcalResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalFluxcalResult record);

    int updateByPrimaryKey(CalFluxcalResult record);
}