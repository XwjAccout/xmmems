package com.xmmems.mapper;

import com.xmmems.domain.cal.CalFluxcalResultExtre;
import com.xmmems.domain.cal.CalFluxcalResultExtreExample;
import java.util.List;

public interface CalFluxcalResultExtreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalFluxcalResultExtre record);

    int insertSelective(CalFluxcalResultExtre record);

    List<CalFluxcalResultExtre> selectByExample(CalFluxcalResultExtreExample example);

    CalFluxcalResultExtre selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalFluxcalResultExtre record);

    int updateByPrimaryKey(CalFluxcalResultExtre record);
}