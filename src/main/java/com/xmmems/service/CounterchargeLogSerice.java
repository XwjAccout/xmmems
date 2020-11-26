package com.xmmems.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.domain.CounterchargeLog;
import com.xmmems.domain.CounterchargeLogExample;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.CounterchargeLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CounterchargeLogSerice {
    @Autowired
    private CounterchargeLogMapper counterchargeLogMapper;

    public PageResult<CounterchargeLog> pageQuery(Integer limit, Integer page) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            CounterchargeLogExample example = new CounterchargeLogExample();
            CounterchargeLogExample.Criteria criteria = example.createCriteria();
            List<CounterchargeLog> baseSites = counterchargeLogMapper.selectByExample(example);
            //得到pageHelper的分页对象
            PageInfo<CounterchargeLog> pageInfo = new PageInfo<>(baseSites);
            //封装自定义的分页对象
            return new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.ROLE_NOT_FOUND);
        }
    }

}
