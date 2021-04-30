package com.xmmems.service.maintenance;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.CustomUtils;
import com.xmmems.domain.OperationVehicle;
import com.xmmems.domain.OperationVehicleExample;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.OperationVehicleMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OperationVehicleSerice {
    @Autowired
    private OperationVehicleMapper operationVehicleMapper;

    public PageResult<OperationVehicle> pageQuery(Integer limit, Integer page, String licence,Integer unitid) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            OperationVehicleExample example = new OperationVehicleExample();
            OperationVehicleExample.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(licence)) {
                criteria.andLicenceLike(CustomUtils.likeValue(licence));
            }
            criteria.andUnitIDEqualTo(unitid);
            List<OperationVehicle> baseSites = operationVehicleMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<OperationVehicle> pageInfo = new PageInfo<>(baseSites);
            //封装自定义的分页对象
            return new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.ROLE_NOT_FOUND);
        }
    }

    public OperationVehicle findById(Integer id) {
        return operationVehicleMapper.selectByPrimaryKey(id);
    }

    public void save(OperationVehicle operationVehicle) {
        int i = operationVehicleMapper.insertSelective(operationVehicle);
        if (i < 1) {
            throw new XMException(ExceptionEnum.INSERT_OPERATION_FAIL);
        }
    }

    public void update(OperationVehicle operationVehicle) {
        int i = operationVehicleMapper.updateByPrimaryKeySelective(operationVehicle);
        if (i < 1) {
            throw new XMException(ExceptionEnum.UPDATE_OPERATION_FAIL);
        }
    }

    public void delete(Integer id) {
        int i = operationVehicleMapper.deleteByPrimaryKey(id);
        if (i < 1) {
            throw new XMException(ExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }


}
