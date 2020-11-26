package com.xmmems.mapper;

import com.xmmems.domain.TreeData;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TreeDataMapper {

    @Select("SELECT * FROM tree_data")
    List<TreeData> getTreeData();
}
