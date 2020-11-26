package com.xmmems.service.quality;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.domain.QualityControlSet;
import com.xmmems.domain.QualityControlSetExample;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.QualityControlSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class QualityControlSetService {
    @Autowired
    QualityControlSetMapper qualityControlSetMapper;

    public PageResult<QualityControlSet> pageQuery(Integer limit, Integer page, Integer type,Integer siteId) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            QualityControlSetExample example = new QualityControlSetExample();
            // example.setOrderByClause("id desc");
            QualityControlSetExample.Criteria criteria = example.createCriteria();
             criteria.andTypeEqualTo(type);
            if(siteId!=null){
                criteria.andSiteIdEqualTo(siteId);
            }
            List<QualityControlSet> baseSites = qualityControlSetMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<QualityControlSet> pageInfo = new PageInfo<>(baseSites);
            //封装自定义的分页对象
            return new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.ROLE_NOT_FOUND);
        }
    }

    public int save(  QualityControlSet envWarningRule) {
        return qualityControlSetMapper.insertSelective(envWarningRule);
    }
}
