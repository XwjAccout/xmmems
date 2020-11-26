package com.xmmems.mapper;

import com.xmmems.domain.temp.TempFluxcalExtre;
import com.xmmems.domain.temp.TempFluxcalExtreExample;
import java.util.List;

public interface TempFluxcalExtreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TempFluxcalExtre record);

    int insertSelective(TempFluxcalExtre record);

    List<TempFluxcalExtre> selectByExample(TempFluxcalExtreExample example);

    TempFluxcalExtre selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempFluxcalExtre record);

    int updateByPrimaryKey(TempFluxcalExtre record);
}