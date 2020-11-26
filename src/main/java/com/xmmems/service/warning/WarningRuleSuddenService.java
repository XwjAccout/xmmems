package com.xmmems.service.warning;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.domain.env.*;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.EnvWarningRuleSuddenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class WarningRuleSuddenService {
    @Autowired
    EnvWarningRuleSuddenMapper envWarningRuleSuddenMapper;

    public PageResult<EnvWarningRuleSudden> pageQuery(Integer limit, Integer page, Integer siteId) {
        try {
            //封装分页信息
            PageHelper.startPage(page,limit);
            //封装查询条件
            EnvWarningRuleSuddenExample example = new EnvWarningRuleSuddenExample();
            EnvWarningRuleSuddenExample.Criteria criteria = example.createCriteria();
            if(siteId!=null){
                criteria.andSiteIdEqualTo(siteId);
            }

            List<EnvWarningRuleSudden> baseSites = envWarningRuleSuddenMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<EnvWarningRuleSudden> pageInfo = new PageInfo<EnvWarningRuleSudden> (baseSites);
            //封装自定义的分页对象

            return new PageResult<EnvWarningRuleSudden> (pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.ROLE_NOT_FOUND);
        }
    }

    public EnvWarningRuleSudden findById(Integer id) {
        return envWarningRuleSuddenMapper.selectByPrimaryKey(id);
    }

    public int save(  EnvWarningRuleSudden envWarningRule) {
        return envWarningRuleSuddenMapper.insertSelective(envWarningRule);
    }

    public void update(  EnvWarningRuleSudden envWarningRule) {
        int i = envWarningRuleSuddenMapper.updateByPrimaryKeySelective(envWarningRule);
        if (i != 1) {
            throw new XMException(ExceptionEnum.UPDATE_OPERATION_FAIL);
        }
    }

    public void delete(Integer id) {
        int i = envWarningRuleSuddenMapper.deleteByPrimaryKey(id);
        if (i != 1) {
            throw new XMException(ExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }

}
