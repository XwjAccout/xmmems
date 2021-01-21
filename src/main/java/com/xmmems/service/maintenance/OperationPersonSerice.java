package com.xmmems.service.maintenance;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.CustomUtils;
import com.xmmems.domain.OperationPerson;
import com.xmmems.domain.OperationPersonExample;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.OperationPersonMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OperationPersonSerice {
    @Autowired
    private OperationPersonMapper operationPersonMapper;

    public PageResult<OperationPerson> pageQuery(Integer limit, Integer page, String name,Integer unitID) {
        System.out.println(name);
        System.out.println(unitID);
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            OperationPersonExample example = new OperationPersonExample();
            // example.setOrderByClause("id desc");
            OperationPersonExample.Criteria criteria = example.createCriteria();
            // criteria.andIsvalidEqualTo("1");
            if (StringUtils.isNotBlank(name)) {
                criteria.andNameLike(CustomUtils.likeValue(name));
            }
            criteria.andUnitIDEqualTo(unitID);
            List<OperationPerson> baseSites = operationPersonMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<OperationPerson> pageInfo = new PageInfo<OperationPerson>(baseSites);
            //封装自定义的分页对象

            return new PageResult<OperationPerson>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.ROLE_NOT_FOUND);
        }
    }

    public OperationPerson findById(Integer id) {
        return operationPersonMapper.selectByPrimaryKey(id);
    }

    public void save(OperationPerson operationPerson) {
        int i = operationPersonMapper.insertSelective(operationPerson);
        if (i < 1) {
            throw new XMException(ExceptionEnum.INSERT_OPERATION_FAIL);
        }
    }

    public void update(OperationPerson operationPerson) {
        int i = operationPersonMapper.updateByPrimaryKeySelective(operationPerson);
        if (i < 1) {
            throw new XMException(ExceptionEnum.UPDATE_OPERATION_FAIL);
        }
    }

    public void delete(Integer id) {
        int i = operationPersonMapper.deleteByPrimaryKey(id);
        if (i < 1) {
            throw new XMException(ExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }


    public List<OperationPerson> findAll() {
        return operationPersonMapper.selectByExample(new OperationPersonExample());
    }
}
