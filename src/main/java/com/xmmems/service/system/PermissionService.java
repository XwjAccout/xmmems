package com.xmmems.service.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.domain.role.Permission;
import com.xmmems.domain.role.PermissionExample;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;


    public PageResult<Permission> pageQuery(Integer limit, Integer page) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            PermissionExample example = new PermissionExample();
             example.setOrderByClause("actionKey asc");
            PermissionExample.Criteria criteria = example.createCriteria();
            // criteria.andIsvalidEqualTo("1");
            List<Permission> baseSites = permissionMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<Permission> pageInfo = new PageInfo<>(baseSites);
            //封装自定义的分页对象
            return new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.Permission_NOT_FOUND);
        }
    }

    public Permission findById(Integer id) {
        Permission permission = permissionMapper.selectByPrimaryKey(id);
        if (permission == null) {
            throw new XMException(ExceptionEnum.Permission_NOT_FOUND);
        }
        return permission;
    }

    public void save(Permission permission) {
        int i = permissionMapper.insertSelective(permission);
        if (i < 1) {
            throw new XMException(ExceptionEnum.INSERT_OPERATION_FAIL);
        }
    }

    public void update(Permission permission) {
        int i = permissionMapper.updateByPrimaryKeySelective(permission);
        if (i < 1) {
            throw new XMException(ExceptionEnum.UPDATE_OPERATION_FAIL);
        }
    }

    public void delete(Integer id) {
        int i = permissionMapper.deleteByPrimaryKey(id);
        if (i < 1) {
            throw new XMException(ExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }

    public List<Permission> findAllByControllerAsc() {
        List<Permission> list = permissionMapper.findAllByControllerAsc();
        if (CollectionUtils.isEmpty(list)) {
            throw new XMException(ExceptionEnum.Permission_NOT_FOUND);
        }
        return list;
    }

    public List<Permission> findByRoleId(Integer roleId) {
        return permissionMapper.findByRoleId(roleId);
    }

    /**
     * 根据 数据库表字段controller 将 permission 进行分组
     */
    public LinkedHashMap<String, List<Permission>> groupByController(List<Permission> permissionList) {
        LinkedHashMap<String, List<Permission>> ret = new LinkedHashMap<String, List<Permission>>();

        for (Permission permission : permissionList) {
            String controller = permission.getController();
            List<Permission> list = ret.computeIfAbsent(controller, k -> new ArrayList<Permission>());

            list.add(permission);
        }

        return ret;
    }

    public LinkedHashMap<String, List<Permission>> assignPermissions() {
        List<Permission> allByControllerAsc = findAllByControllerAsc();
        return groupByController(allByControllerAsc);
    }

    public List<Map<String, Object>> findotherPowerByRoleId(Integer roleId) {
        return permissionMapper.findotherPowerByRoleId(roleId);
    }
}
