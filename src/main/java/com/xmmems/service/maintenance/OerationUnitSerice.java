package com.xmmems.service.maintenance;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.domain.OperationUnit;
import com.xmmems.domain.OperationUnitExample;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.OperationUnitMapper;
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
public class OerationUnitSerice {
    @Autowired
    private  OperationUnitMapper oerationUnitMapper;

    public PageResult<OperationUnit> pageQuery(Integer limit, Integer page, String siteName) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            OperationUnitExample example = new OperationUnitExample();
            // example.setOrderByClause("id desc");
            OperationUnitExample.Criteria criteria = example.createCriteria();
            // criteria.andIsvalidEqualTo("1");
            List<OperationUnit> baseSites = oerationUnitMapper.selectByExample(example);


            //得到pageHelper的分页对象
            PageInfo<OperationUnit> pageInfo = new PageInfo<OperationUnit>(baseSites);
            //封装自定义的分页对象

            return new PageResult<OperationUnit>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.ROLE_NOT_FOUND);
        }
    }

    public OperationUnit findById(Integer id) {
        return oerationUnitMapper.selectByPrimaryKey(id);
    }

    public void save(OperationUnit oerationUnit) {
        int i = oerationUnitMapper.insertSelective(oerationUnit);
        if (i < 1) {
            throw new XMException(ExceptionEnum.INSERT_OPERATION_FAIL);
        }
    }

    public void update(OperationUnit OerationUnit) {
        int i = oerationUnitMapper.updateByPrimaryKeySelective(OerationUnit);
        if (i < 1) {
            throw new XMException(ExceptionEnum.UPDATE_OPERATION_FAIL);
        }
    }

    public void delete(Integer id) {
        int i = oerationUnitMapper.deleteByPrimaryKey(id);
        if (i < 1) {
            throw new XMException(ExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }
    public  List<Map<String, Object>> treeformUnit(){
        List<Map<String, Object>> list0 = new ArrayList<>();
        OperationUnitExample example = new OperationUnitExample();
        List<OperationUnit> operationUnit = oerationUnitMapper.selectByExample(example);
        int num=0;
        //不为空
        if (!CollectionUtils.isEmpty(operationUnit)) {
            Map<String, Object> map0 = new HashMap<>();
            List<Map<String, Object>> list1 = new ArrayList<>();
            for (OperationUnit menu1 : operationUnit) {
                if (num==0) {
                    num++;
                    Map<String, Object> map1 = new HashMap<>();
                    map1.put("name","单位名称");
                    List<Map<String, Object>> list2 = new ArrayList<>();
                    for (OperationUnit menu2 : operationUnit) {
                        if (menu1.getId().equals(menu1.getId())) {
                            Map<String, Object> map2 = new HashMap<>();
                            map2.put("id", menu2.getId());
                            map2.put("name", menu2.getUnitName());
                            map2.put("shortName", menu2.getShortName());
                            map2.put("creditID  ", menu2.getCreditID());
                            map2.put("legalPerson", menu2.getLegalPerson());
                            map2.put("legalPhone", menu2.getLegalPhone());
                            map2.put("linkman", menu2.getLinkman());
                            map2.put("telephone", menu2.getTelephone());
                            map2.put("area", menu2.getArea());
                            map2.put("zipCode", menu2.getZipCode());
                            map2.put("address", menu2.getAddress());
                            map2.put("website", menu2.getWebsite());
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
