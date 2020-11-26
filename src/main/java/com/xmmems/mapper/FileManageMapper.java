package com.xmmems.mapper;

import com.xmmems.domain.FileManage;
import com.xmmems.domain.FileManageExample;
import java.util.List;

public interface FileManageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FileManage record);

    int insertSelective(FileManage record);

    List<FileManage> selectByExample(FileManageExample example);

    FileManage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FileManage record);

    int updateByPrimaryKey(FileManage record);
}