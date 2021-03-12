package com.xmmems.mapper;

import com.xmmems.material.domain.Cost;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CostMapper extends Mapper<Cost> {

    @Select("SELECT count(1)as counts, noticeId ,receiveAccountId,receiveAccountName,DATE_FORMAT(receiptTime,'%Y-%m-%d') as receiptTime from  sendnotice where readType='已回执' and  !ISNULL(annexUrl) GROUP BY DATE_FORMAT(receiptTime,'%Y-%m-%d'),receiveAccountId ")
    public List<Cost> findCost();
    @Select("SELECT noticeId  from  sendnotice ")
    public List<Cost> findCostAll();
}
