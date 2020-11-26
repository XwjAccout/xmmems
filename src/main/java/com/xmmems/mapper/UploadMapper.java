package com.xmmems.mapper;

import com.xmmems.domain.Upload;
import com.xmmems.domain.UploadExample;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UploadMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Upload record);

    int insertSelective(Upload record);

    List<Upload> selectByExample(UploadExample example);

    Upload selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Upload record);

    int updateByPrimaryKey(Upload record);

    @Select("select url from upload where purpose='背景图片' order by date desc limit 1")
    String selectNewestBackground();

    @Select("select * from upload where purpose='附件'")
    List<Upload> selectAllFiles();
}