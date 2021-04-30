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
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class OperationPersonSerice {
    @Autowired
    private OperationPersonMapper operationPersonMapper;

    public PageResult<OperationPerson> pageQuery(Integer limit, Integer page, String name,Integer unitid) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            OperationPersonExample example = new OperationPersonExample();
            OperationPersonExample.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(name)) {
                criteria.andNameLike(CustomUtils.likeValue(name));
            }
            criteria.andUnitIDEqualTo(unitid);
            List<OperationPerson> baseSites = operationPersonMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<OperationPerson> pageInfo = new PageInfo<>(baseSites);
            //封装自定义的分页对象
            return new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
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


    public  List<Map<String, Object>> treeformUnit(){
        List<Map<String, Object>> list0 = new ArrayList<>();
        OperationPersonExample example = new OperationPersonExample();
        List<OperationPerson> operationUnit = operationPersonMapper.selectByExample(example);
        int num=0;
        //不为空
        if (!CollectionUtils.isEmpty(operationUnit)) {
            Map<String, Object> map0 = new HashMap<>(4);
            List<Map<String, Object>> list1 = new ArrayList<>();
            for (OperationPerson menu1 : operationUnit) {
                if (num==0) {
                    num++;
                    Map<String, Object> map1 = new HashMap<>(4);
                    map1.put("name","员工名称");
                    List<Map<String, Object>> list2 = new ArrayList<>();
                    for (OperationPerson menu2 : operationUnit) {
                        if (menu1.getId().equals(menu1.getId())) {
                            Map<String, Object> map2 = new HashMap<>(8);
                            map2.put("id", menu2.getId());
                            map2.put("name", menu2.getName());
                            map2.put("account", menu2.getAccount());
                            map2.put("unitID  ", menu2.getUnitID());
                            map2.put("role", menu2.getRole());
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
}
