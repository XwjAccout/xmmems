package com.xmmems.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.domain.base.*;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.BaseRiverMapper;
import com.xmmems.mapper.BaseSectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BaseRiverServer {
    @Autowired
    private BaseRiverMapper baseRiverMapper;

    @Autowired
    private BaseSectionMapper baseSectionMapper;

    //分页查询
    public PageResult<BaseRiver> baseRiverPageQuery(Integer limit, Integer page) {

        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            BaseRiverExample example = new BaseRiverExample();
            BaseRiverExample.Criteria criteria = example.createCriteria();
            List<BaseRiver> baseSites = baseRiverMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<BaseRiver> pageInfo = new PageInfo<>(baseSites);
            //封装自定义的分页对象
            return new PageResult<>(pageInfo.getSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {

            throw new XMException(ExceptionEnum.BASESITE_NOT_FOUND);
        }
    }

    //分页查询
    public PageResult<BaseSection> baseSectionPageQuery(Integer limit, Integer page) {

        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            BaseSectionExample example = new BaseSectionExample();
            BaseSectionExample.Criteria criteria = example.createCriteria();
            List<BaseSection> baseSites = baseSectionMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<BaseSection> pageInfo = new PageInfo<>(baseSites);
            //封装自定义的分页对象
            return new PageResult<>(pageInfo.getSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.BASESITE_NOT_FOUND);
        }
    }
}
