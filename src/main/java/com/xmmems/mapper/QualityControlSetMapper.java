package com.xmmems.mapper;

import com.xmmems.domain.QualityControlSet;
import com.xmmems.domain.QualityControlSetExample;
import java.util.List;

public interface QualityControlSetMapper {
    int insert(QualityControlSet record);

    int insertSelective(QualityControlSet record);

    List<QualityControlSet> selectByExample(QualityControlSetExample example);
}