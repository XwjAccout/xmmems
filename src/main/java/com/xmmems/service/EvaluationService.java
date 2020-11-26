package com.xmmems.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.domain.Evaluation;
import com.xmmems.domain.EvaluationExample;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.EvaluationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EvaluationService {
    @Autowired
    EvaluationMapper evaluationMapper;

    public PageResult<Evaluation> pageQuery(Integer limit, Integer page, Integer siteId) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            EvaluationExample example = new EvaluationExample();
            EvaluationExample.Criteria criteria = example.createCriteria();
            if(siteId!=null){
                criteria.andSiteIdEqualTo(siteId);
            }
            List<Evaluation> baseSites = evaluationMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<Evaluation> pageInfo = new PageInfo<>(baseSites);
            //封装自定义的分页对象
            return new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.ROLE_NOT_FOUND);
        }
    }

}
