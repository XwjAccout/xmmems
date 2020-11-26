package com.xmmems.service.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.auth.domain.UserHolder;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.BeanHelper;
import com.xmmems.domain.account.AccountRoleKey;
import com.xmmems.domain.role.Menu;
import com.xmmems.domain.role.MenuExample;
import com.xmmems.dto.MenuDTO;
import com.xmmems.mapper.MenuMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@Slf4j
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public PageInfo<Menu> pageQuery(Integer limit, Integer page, String name) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            MenuExample example = new MenuExample();
            example.setOrderByClause("rank asc");
            MenuExample.Criteria criteria = example.createCriteria();
            criteria.andIsvalidEqualTo("1");
            if (StringUtils.isNotBlank(name)) {
                criteria.andNameEqualTo(name);
            }
            List<Menu> baseSites = menuMapper.selectByExample(example);

            return new PageInfo<>(baseSites);
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.MENU_NOT_FOUND);
        }
    }

    /**
     * 给菜单排序
     */
    private void rankMenuDTO(List<MenuDTO> menuDTOS, List<MenuDTO> list) {
        //等级等于0 先排序，等级等于1，再根据父编号排序
        menuDTOS.forEach(menuDTO -> {
            if ("0".equals(menuDTO.getLevel())) {
                list.add(menuDTO);
                menuDTOS.forEach(temp -> {
                    if ("1".equals(temp.getLevel()) && temp.getPcode().equals(menuDTO.getCode())) {
                        list.add(temp);
                        menuDTOS.forEach(temp2 -> {
                            if ("2".equals(temp2.getLevel()) && temp2.getPcode().equals(temp.getCode())) {
                                list.add(temp2);
                            }
                        });
                    }
                });

            }
        });
    }

    public MenuDTO findById(Integer id) {
        Menu menu = menuMapper.selectByPrimaryKey(id);
        if (menu == null) {
            throw new XMException(ExceptionEnum.MENU_NOT_FOUND);
        }
        return BeanHelper.copyProperties(menu, MenuDTO.class);
    }

    public void save(Menu menu) {
        menu.setIsvalid("1");
        int i = menuMapper.insertSelective(menu);
        if (i < 1) {
            throw new XMException(ExceptionEnum.INSERT_OPERATION_FAIL);
        }
    }

    public void update(Menu menu) {
        int i = menuMapper.updateByPrimaryKeySelective(menu);
        if (i < 1) {
            throw new XMException(ExceptionEnum.UPDATE_OPERATION_FAIL);
        }
    }

    public void delete(Integer id) {
        int i = menuMapper.deleteByPrimaryKey(id);
        if (i < 1) {
            throw new XMException(ExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }

    /**
     * 查询所有一级菜单
     * @return
     */
    public List<MenuDTO> findPmenu() {
        MenuExample example = new MenuExample();
        //查询当前用户的角色
        AccountRoleKey account = menuMapper.roleByAccoutId(UserHolder.loginId());
        List<Menu> menus = menuMapper.roleById(account.getRoleId());
        if (CollectionUtils.isEmpty(menus)) {
            throw new XMException(ExceptionEnum.MENU_NOT_FOUND);
        }
        return BeanHelper.copyWithCollection(menus, MenuDTO.class);
    }

    public List<Map<String, Object>> findByPid(String pcode) {
        List<Map<String, Object>> list0 = new ArrayList<>();
        AccountRoleKey account = menuMapper.roleByAccoutId(UserHolder.loginId());
        List<Menu> menus = menuMapper.findByPid(pcode,account.getRoleId());

        //不为空
        if (!CollectionUtils.isEmpty(menus)) {
                Map<String, Object> map0 = new HashMap<>();
                    List<Map<String, Object>> list1 = new ArrayList<>();
                    for (Menu menu1 : menus) {
                        if (menu1.getPcode().equals(pcode)) {
                            Map<String, Object> map1 = new HashMap<>();
                            map1.put("name", menu1.getName());
                            map1.put("path", menu1.getNewUrl());
                            map1.put("id", menu1.getId());
                            map1.put("icon", menu1.getIcon());
                            List<Map<String, Object>> list2 = new ArrayList<>();
                            List<Menu> menuslist = menuMapper.findByPid(menu1.getCode(),account.getRoleId());
                            for (Menu menu2 : menuslist) {
                                if (menu2.getPcode().equals(menu1.getCode())) {
                                    Map<String, Object> map2 = new HashMap<>();
                                    map2.put("name", menu2.getName());
                                    map2.put("path", menu2.getNewUrl());
                                    map2.put("id", menu2.getId());
                                    map2.put("icon", menu2.getIcon());
                                    list2.add(map2);
                                }

                            }
                            map1.put("menu", list2);
                            list1.add(map1);
                        }
                    }
            map0.put("menu", list1);
            //封装数据
            list0.add(map0);

        }

        return list0;
    }

    public List<Map<String, Object>> findByRoleId(Integer roleId) {
        return menuMapper.findByRoleId(roleId);
    }

    public List<MenuDTO> findByAccountId() {
        Integer id = UserHolder.loginId();
        List<Menu> menus = menuMapper.selectByAccountId(id);
        if (CollectionUtils.isEmpty(menus)) {
            throw new XMException(ExceptionEnum.MENU_NOT_FOUND);
        }
        List<MenuDTO> menuDTOS = BeanHelper.copyWithCollection(menus, MenuDTO.class);
        List<MenuDTO> list = new ArrayList<>();
        //重新排序
        rankMenuDTO(menuDTOS, list);

        return list;
    }

    public List<Map<String, Object>> findMenuTree(Integer roleId) {
        //传送的对象
        List<Map<String, Object>> list0 = new ArrayList<>();

         List<Menu> menus  = null;
        if (roleId==null) {
            menus = menuMapper.selectAll();
        } else {
            menus = menuMapper.selectByRoleId(roleId);
        }

        //不为空
        if (!CollectionUtils.isEmpty(menus)) {
            for (Menu menu0 : menus) {
                if ("0".equals(menu0.getLevel())) {
                    Map<String, Object> map0 = new HashMap<>();
                    map0.put("name", menu0.getName());
                    map0.put("path", menu0.getNewUrl());
                    map0.put("id", menu0.getId());
                    List<Map<String, Object>> list1 = new ArrayList<>();
                    for (Menu menu1 : menus) {
                        if ("1".equals(menu1.getLevel()) && menu1.getPcode().equals(menu0.getCode())) {
                            Map<String, Object> map1 = new HashMap<>();
                            map1.put("name", menu1.getName());
                            map1.put("path", menu1.getNewUrl());
                            map1.put("id", menu1.getId());
                            List<Map<String, Object>> list2 = new ArrayList<>();
                            for (Menu menu2 : menus) {
                                if ("2".equals(menu2.getLevel()) && menu2.getPcode().equals(menu1.getCode())) {
                                    Map<String, Object> map2 = new HashMap<>();
                                    map2.put("name", menu2.getName());
                                    map2.put("path", menu2.getNewUrl());
                                    map2.put("id", menu2.getId());
                                    list2.add(map2);
                                }
                            }
                            map1.put("menu", list2);
                            list1.add(map1);
                        }
                    }
                    map0.put("menu", list1);
                    //封装数据
                    list0.add(map0);
                }
            }
        }
        return list0;
    }
}
