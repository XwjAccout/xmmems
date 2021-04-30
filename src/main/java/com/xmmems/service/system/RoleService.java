package com.xmmems.service.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.BeanHelper;
import com.xmmems.domain.role.Permission;
import com.xmmems.domain.role.Role;
import com.xmmems.domain.role.RoleExample;
import com.xmmems.dto.PageResult;
import com.xmmems.dto.RoleDTO;
import com.xmmems.mapper.RoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class RoleService {
  
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private MenuService menuService;

    public PageResult<Role> pageQuery(Integer limit, Integer page, String siteName) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            RoleExample example = new RoleExample();
            List<Role> baseSites = roleMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<Role> pageInfo = new PageInfo<>(baseSites);
            //封装自定义的分页对象
            return new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.ROLE_NOT_FOUND);
        }
    }

    public Role findById(Integer id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        if (role == null) {
            throw new XMException(ExceptionEnum.ROLE_NOT_FOUND);
        }
        //添加权限
        List<Permission> permissions = permissionService.findByRoleId(id);
        role.setPermissions(permissions);
        //添加菜单
        List<Map<String, Object>> menus = menuService.findByRoleId(id);
        role.setMenus(menus);

        //添加其他权限  未知具体来源
        List<Map<String, Object>> op = permissionService.findotherPowerByRoleId(id);
        role.setOtherPower(op);

        return role;
    }

    public void save(String name) {
        Role role = new Role();
        role.setName(name);
        role.setCreateAt(new Date());
        int i = roleMapper.insertSelective(role);
        if (i < 1) {
            throw new XMException(ExceptionEnum.INSERT_OPERATION_FAIL);
        }
    }

    public void update(Role role) {
        int i = roleMapper.updateByPrimaryKeySelective(role);
        if (i < 1) {
            throw new XMException(ExceptionEnum.UPDATE_OPERATION_FAIL);
        }
    }

    public void delete(Integer id) {
        int i = roleMapper.deleteByPrimaryKey(id);
        if (i < 1) {
            throw new XMException(ExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }

    /**
     * 根据用户id查找角色，可以返回null
     */
    public List<RoleDTO> findRoleByAccountId(Integer id){
        List<Role> roles = roleMapper.findRoleByAccountId(id);
        if (CollectionUtils.isEmpty(roles)) {
            return null;
        }
        return BeanHelper.copyWithCollection(roles, RoleDTO.class);
    }


    public List<RoleDTO> findAll() {
        List<Role> roles = roleMapper.selectByExample(new RoleExample());
        if (CollectionUtils.isEmpty(roles)) {
            return null;
        }

        return BeanHelper.copyWithCollection(roles, RoleDTO.class);
    }

    public void deletePermission(Integer roleId, Integer permissionId) {
        if (roleId == 1) {
            throw new XMException(500,"超级管理员天然拥有所有权限，不能删除权限");
        }
        int i = roleMapper.deletePermission(roleId,permissionId);
        if (i < 1) {
            throw new XMException(ExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }

    public void savePermission(Integer roleId, Integer permissionId) {
        int i = roleMapper.savePermission(roleId,permissionId);
        if (i < 1) {
            throw new XMException(ExceptionEnum.INSERT_OPERATION_FAIL);
        }
    }

    public void saveMenu(Integer roleId, Integer menuId) {
        int count=roleMapper.isExistmenuId(menuId,roleId);
        int i=0;
        if(count==0){
             i = roleMapper.saveMenu(roleId,menuId);
        }else{
            log.info("不需要添加");
        }

        if (i < 1) {
            throw new XMException(ExceptionEnum.INSERT_OPERATION_FAIL);
        }
    }

    public void deleteMenu(Integer roleId, Integer menuId) {
        int count=roleMapper.isExistmenuId(menuId,roleId);
        int i=0;
        if(count==0){
            log.info("没有可删除的id");
        }else{
             i = roleMapper.deleteMenu(roleId,menuId);
        }
        if (i < 1) {
            throw new XMException(ExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }

    public void saveotherPower(Integer roleId, Integer otherPowerId) {
        int i = roleMapper.saveotherPower(roleId,otherPowerId);
        if (i < 1) {
            throw new XMException(ExceptionEnum.INSERT_OPERATION_FAIL);
        }
    }

    public void deleteotherPower(Integer roleId, Integer otherPowerId) {
        int i = roleMapper.deleteotherPower(roleId,otherPowerId);
        if (i < 1) {
            throw new XMException(ExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }
}

