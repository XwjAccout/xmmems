package com.xmmems.service.warning;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.CustomUtils;
import com.xmmems.domain.env.*;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.EnvWarningGroupMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class WarningGroupService {
    @Autowired
   private EnvWarningGroupMapper envWarningGroupMapper;

    public PageResult<EnvWarningGroup> pageQuery(Integer limit, Integer page) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            EnvWarningGroupExample example = new EnvWarningGroupExample();
            // example.setOrderByClause("id desc");
            EnvWarningGroupExample.Criteria criteria = example.createCriteria();
            // criteria.andIsvalidEqualTo("1");

            List<EnvWarningGroup> baseSites = envWarningGroupMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<EnvWarningGroup> pageInfo = new PageInfo<>(baseSites);
            //封装自定义的分页对象
            PageResult<EnvWarningGroup> pageResult =
                    new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());

            return pageResult;
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.ROLE_NOT_FOUND);
        }
    }

    public EnvWarningGroup findById(Integer id) {
        EnvWarningGroup envWarningGroup = envWarningGroupMapper.selectByPrimaryKey(id);
        return envWarningGroup;
    }

    public int save( EnvWarningGroupWithBLOBs envWarningGroupWithBLOBs) {
        int result = envWarningGroupMapper.insertSelective(envWarningGroupWithBLOBs);
        return result;
    }

    public void update( EnvWarningGroupWithBLOBs envWarningGroupWithBLOBs) {
        int i = envWarningGroupMapper.updateByPrimaryKeySelective(envWarningGroupWithBLOBs);
        if (i != 1) {
            throw new XMException(ExceptionEnum.UPDATE_OPERATION_FAIL);
        }
    }

    public void delete(Integer id) {
        int i = envWarningGroupMapper.deleteByPrimaryKey(id);
        if (i != 1) {
            throw new XMException(ExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }

}
