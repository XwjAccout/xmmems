package com.xmmems.service.warning;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.CustomUtils;
import com.xmmems.domain.EnvWarningDataLoss;
import com.xmmems.domain.EnvWarningDataLossExample;
import com.xmmems.domain.env.EnvAddressBook;
import com.xmmems.domain.env.EnvAddressBookExample;
import com.xmmems.domain.env.EnvWarningGroupWithBLOBs;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.EnvWarningDataLossMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class WarningDataLossService {
    @Autowired
    EnvWarningDataLossMapper envWarningDataLossMapper;
    public PageResult<EnvWarningDataLoss> pageQuery(Integer limit, Integer page, String name) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            EnvWarningDataLossExample example = new EnvWarningDataLossExample();
            // example.setOrderByClause("id desc");
            EnvWarningDataLossExample.Criteria criteria = example.createCriteria();
            // criteria.andIsvalidEqualTo("1");

            List<EnvWarningDataLoss> baseSites = envWarningDataLossMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<EnvWarningDataLoss> pageInfo = new PageInfo<>(baseSites);
            //封装自定义的分页对象
            PageResult<EnvWarningDataLoss> pageResult =
                    new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());

            return pageResult;
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
}
