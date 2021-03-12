package com.xmmems.mapper;

import com.xmmems.task.domain.Sendnotice;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface SendnoticeMapper extends Mapper<Sendnotice> {

    @Select("select noticeId ,receiveAccountId,receiveAccountName,DATE_FORMAT(receiptTime,'%Y-%m-%d') as receiptTime from sendnotice where noticeId=#{noticeId}")
    public Sendnotice findBynoticeId(@Param("noticeId") Integer noticeId);
}
