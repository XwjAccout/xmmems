package com.xmmems.service.warning;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.domain.EnvWarningDataLoss;
import com.xmmems.domain.EnvWarningDataLossExample;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.EnvWarningDataLossMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(rollbackFor = Exception.class)
public class WarningDataLossService {
    @Autowired
    EnvWarningDataLossMapper envWarningDataLossMapper;
    public PageResult<EnvWarningDataLoss> pageQuery(Integer limit, Integer page, String name) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            EnvWarningDataLossExample example = new EnvWarningDataLossExample();

            List<EnvWarningDataLoss> baseSites = envWarningDataLossMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<EnvWarningDataLoss> pageInfo = new PageInfo<>(baseSites);
            //封装自定义的分页对象
            return new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.ROLE_NOT_FOUND);
        }
    }


    public void update( EnvWarningDataLoss envWarningDataLoss) {
        int i = envWarningDataLossMapper.updateByPrimaryKeySelective(envWarningDataLoss);
        if (i != 1) {
            throw new XMException(ExceptionEnum.UPDATE_OPERATION_FAIL);
        }
    }
    public void delete( Integer id) {
        int i = envWarningDataLossMapper.deleteByPrimaryKey(id);
        if (i != 1) {
            throw new XMException(ExceptionEnum.UPDATE_OPERATION_FAIL);
        }
    }
    public void save( EnvWarningDataLoss envWarningDataLoss) {
        int i = envWarningDataLossMapper.insertSelective(envWarningDataLoss);
        if (i != 1) {
            throw new XMException(ExceptionEnum.UPDATE_OPERATION_FAIL);
        }
    }
}
