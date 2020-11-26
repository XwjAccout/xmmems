package com.xmmems.mapper;

import com.xmmems.domain.cal.CalFluxcalLog;
import com.xmmems.domain.cal.CalFluxcalLogExample;
import java.util.List;

public interface CalFluxcalLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalFluxcalLog record);

    int insertSelective(CalFluxcalLog record);

    List<CalFluxcalLog> selectByExample(CalFluxcalLogExample example);

    CalFluxcalLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalFluxcalLog record);

    int updateByPrimaryKey(CalFluxcalLog record);
}