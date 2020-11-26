package com.xmmems.service.warning;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.domain.env.EnvWarnRecord;
import com.xmmems.domain.env.EnvWarnRecordExample;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.EnvWarnRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class WarnRecordService {
    @Autowired
    EnvWarnRecordMapper envWarnRecordMapper;
    public PageResult<EnvWarnRecord> pageQuery(Integer limit, Integer page, Integer siteId) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            EnvWarnRecordExample example = new EnvWarnRecordExample();
            EnvWarnRecordExample.Criteria criteria = example.createCriteria();
            if(siteId!=null){
                criteria.andSiteIdEqualTo(siteId);
            }

            List<EnvWarnRecord> baseSites = envWarnRecordMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<EnvWarnRecord> pageInfo = new PageInfo<EnvWarnRecord> (baseSites);
            //封装自定义的分页对象

            return new PageResult<EnvWarnRecord> (pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.ROLE_NOT_FOUND);
        }
    }

    public EnvWarnRecord findById(Integer id) {
        return envWarnRecordMapper.selectByPrimaryKey(id);
    }

    public int save(  EnvWarnRecord envWarningRule) {
        return envWarnRecordMapper.insertSelective(envWarningRule);
    }

    public void update(  EnvWarnRecord envWarningRule) {
        int i = envWarnRecordMapper.updateByPrimaryKeySelective(envWarningRule);
        if (i != 1) {
            throw new XMException(ExceptionEnum.UPDATE_OPERATION_FAIL);
        }
    }

    public void delete(Integer id) {
        int i = envWarnRecordMapper.deleteByPrimaryKey(id);
        if (i != 1) {
            throw new XMException(ExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }
}
