package com.xmmems.mapper;

import com.xmmems.domain.CounterchargeLog;
import com.xmmems.domain.CounterchargeLogExample;
import java.util.List;

public interface CounterchargeLogMapper {
    int insert(CounterchargeLog record);

    int insertSelective(CounterchargeLog record);

    List<CounterchargeLog> selectByExample(CounterchargeLogExample example);
    int updateByPrimaryKeySelective(CounterchargeLog counterchargeLog);
}