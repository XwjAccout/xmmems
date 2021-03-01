package com.xmmems.material.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.dto.PageResult;
import com.xmmems.material.domain.MaterialManagement;
import com.xmmems.mapper.MaterialManagementMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2021.02.23 09:56
 */
@Transactional
@Service
public class MaterialManagementService {
    @Autowired
    private MaterialManagementMapper materialManagementMapper;

    public PageResult<MaterialManagement> findPage(Integer limit, Integer page, String name, Integer siteId, String warnType) {

        //封装分页信息
        PageHelper.startPage(page, limit);
        //封装查询条件
        Example example = new Example(MaterialManagement.class);
        Example.Criteria criteria = example.createCriteria();
        if (siteId != null) {
            criteria.andEqualTo("siteId", siteId);
        }
        if (StringUtils.isNotBlank(name)) {
            criteria.andLike("name", "%" + name + "%");
        }
        if ("预警".equals(warnType)) {
            criteria.andCondition("count <= warnCount");
        } else if ("未预警".equals(warnType)) {
            criteria.andCondition("count > warnCount");
        }

        List<MaterialManagement> materialManagements = materialManagementMapper.selectByExample(example);

        PageInfo<MaterialManagement> info = new PageInfo<>(materialManagements);
        //封装自定义的分页对象
        //因为中间经过处理，所以分页插件总数需要重新设置
        materialManagements.forEach(temp -> {
            //处理预警状态
            Integer count = temp.getCount();
            Integer warnCount = temp.getWarnCount();
            if (count > warnCount) {
                temp.setWarnType("未预警");
            } else {
                temp.setWarnType("预警");
            }
        });
        return new PageResult<>(info.getPageSize(), page, info.getTotal(), info.getPages(), materialManagements);
    }

    public void addOrUpdate(String name, String unit, Integer count, Integer warnCount, Integer siteId, String siteName, String remarks, Integer id) {

        MaterialManagement materialManagement = new MaterialManagement();
        materialManagement.setName(name);
        materialManagement.setSiteId(siteId);

        if (id != null) {
            materialManagement.setId(id);
            materialManagement.setSiteName(siteName);
            materialManagement.setCount(count);
            materialManagement.setWarnCount(warnCount);
            materialManagement.setUnit(unit);
            materialManagement.setRemarks(remarks);
            try {
                materialManagementMapper.updateByPrimaryKeySelective(materialManagement);
                return;
            } catch (Exception e) {
                throw new XMException(ExceptionEnum.UPDATE_ERROR);
            }
        }

        MaterialManagement select = materialManagementMapper.selectOne(materialManagement);

        if (select != null) {
            //已经有物资，修改物资数量数据即可
            select.setCount(count + select.getCount());
            select.setSiteName(siteName);
            select.setWarnCount(warnCount);
            select.setUnit(unit);
            select.setRemarks(remarks);
            select.setCreateTime(null);

            try {
                materialManagementMapper.updateByPrimaryKeySelective(select);
            } catch (Exception e) {
                throw new XMException(ExceptionEnum.UPDATE_ERROR);
            }

        } else {
            //数据库还未有该物资，新增数据
            materialManagement.setSiteName(siteName);
            materialManagement.setCount(count);
            materialManagement.setWarnCount(warnCount);
            materialManagement.setUnit(unit);
            materialManagement.setRemarks(remarks);
            try {
                materialManagementMapper.insertSelective(materialManagement);
            } catch (Exception e) {
                throw new XMException(ExceptionEnum.INSERT_ERROR);
            }

        }
    }

    public void delete(List<Integer> ids) {
        try {
            ids.forEach(id -> materialManagementMapper.deleteByPrimaryKey(id));
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.DELETE_ERROR);
        }
    }

    //消耗
    public void consume(Integer id, Integer num) {
        MaterialManagement materialManagement = materialManagementMapper.selectByPrimaryKey(id);
        Integer count = materialManagement.getCount();
        if (count >= num) {
            materialManagement.setCount(count - num);
            materialManagementMapper.updateByPrimaryKey(materialManagement);
        } else {
            throw new XMException(500, "库存不足");
        }
    }
}
