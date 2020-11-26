package com.xmmems.mapper;

import com.xmmems.domain.app.AppVersionRecord;
import com.xmmems.domain.app.AppVersionRecordExample;
import java.util.List;

public interface AppVersionRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppVersionRecord record);

    int insertSelective(AppVersionRecord record);

    List<AppVersionRecord> selectByExampleWithBLOBs(AppVersionRecordExample example);

    List<AppVersionRecord> selectByExample(AppVersionRecordExample example);

    AppVersionRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppVersionRecord record);

    int updateByPrimaryKeyWithBLOBs(AppVersionRecord record);

    int updateByPrimaryKey(AppVersionRecord record);
}