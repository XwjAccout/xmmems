package com.xmmems.service.warning;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.domain.env.EnvWarningGroup;
import com.xmmems.domain.env.EnvWarningGroupExample;
import com.xmmems.domain.env.EnvWarningGroupWithBLOBs;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.EnvWarningGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(rollbackFor = Exception.class)
public class WarningGroupService {
    @Autowired
   private EnvWarningGroupMapper envWarningGroupMapper;

    public PageResult<EnvWarningGroup> pageQuery(Integer limit, Integer page) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            EnvWarningGroupExample example = new EnvWarningGroupExample();

            List<EnvWarningGroup> baseSites = envWarningGroupMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<EnvWarningGroup> pageInfo = new PageInfo<>(baseSites);
            //封装自定义的分页对象
            return new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
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
