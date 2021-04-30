package com.xmmems.service.warning;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.domain.env.EnvWarningRule;
import com.xmmems.domain.env.EnvWarningRuleExample;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.EnvWarningRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class WarningRuleService {

    @Autowired
    EnvWarningRuleMapper envWarningRuleMapper;

    public PageResult<EnvWarningRule> pageQuery(Integer limit, Integer page, Integer siteId) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            EnvWarningRuleExample example = new EnvWarningRuleExample();
            EnvWarningRuleExample.Criteria criteria = example.createCriteria();
            if (siteId != null) {
                criteria.andSiteIdEqualTo(siteId);
            }
            List<EnvWarningRule> baseSites = envWarningRuleMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<EnvWarningRule> pageInfo = new PageInfo<EnvWarningRule>(baseSites);
            //封装自定义的分页对象

            return new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            throw new XMException(500, "资源未找到");
        }

    }

    public EnvWarningRule findById(Integer id) {
        return envWarningRuleMapper.selectByPrimaryKey(id);
    }

    public int save(EnvWarningRule envWarningRule) {
        return envWarningRuleMapper.insertSelective(envWarningRule);
    }

    public void update(EnvWarningRule envWarningRule) {
        int i = envWarningRuleMapper.updateByPrimaryKeySelective(envWarningRule);
        if (i != 1) {
            throw new XMException(ExceptionEnum.UPDATE_OPERATION_FAIL);
        }
    }

    public void delete(Integer id) {
        int i = envWarningRuleMapper.deleteByPrimaryKey(id);
        if (i != 1) {
            throw new XMException(ExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }

}
