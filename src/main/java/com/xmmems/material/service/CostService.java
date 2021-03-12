package com.xmmems.material.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.CostMapper;
import com.xmmems.mapper.MaterialManagementMapper;
import com.xmmems.material.domain.Cost;
import com.xmmems.material.domain.CostSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2021.03.01 16:16
 */
@Service
@Transactional
public class CostService {

    @Autowired
    private CostMapper costMapper;

    @Autowired
    private MaterialManagementMapper materialManagementMapper;

    public void add(Cost cost) {
        try {
            costMapper.insertSelective(cost);
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.INSERT_ERROR);
        }
    }

    public void addandfindPage() {
        List<Cost> costList=costMapper.findCost();
        List<Cost> costListAll= costMapper.findCostAll();
        double one=500;
        double two=100;
        costList.forEach(temp -> {
            Cost cost=new Cost();
            costListAll.forEach(tempAll -> {
                if(!temp.getNoticeId().equals(tempAll.getNoticeId())){
                    cost.setNoticeId(temp.getNoticeId());
                    cost.setReceiveAccountId(temp.getReceiveAccountId());
                    cost.setReceiveAccountName(temp.getReceiveAccountName());
                    cost.setReceiptTime(temp.getReceiptTime());
                    cost.setCounts(temp.getCounts());
                    for(int i=1;i<=temp.getCounts();i++) {
                        if (i == 1) {
                            cost.setPrice(one);
                        } else{
                            cost.setPrice(cost.getPrice() + two);
                        }
                    }
                }

            });
            costMapper.insertSelective(cost);
        });
    }

    public PageResult<Cost> findPage(Integer limit, Integer page) {
//        addandfindPage();
        PageHelper.startPage(page, limit);
        Example example = new Example(Cost.class);
        example.setOrderByClause("id desc");
        Example.Criteria criteria = example.createCriteria();
//        if (StringUtils.isNotBlank(name)) {
//            criteria.andEqualTo("name", name);
//        }
//        if (type != null) {
//            criteria.andEqualTo("type", type);
//        }
        List<Cost> costs = costMapper.selectByExample(example);
        PageInfo<Cost> info = new PageInfo<>(costs);
        return new PageResult<>(info.getPageSize(), page, info.getTotal(), info.getPages(), costs);
    }

    public PageResult<CostSite> sitefindPage(Integer limit, Integer page, Integer siteId) {

        PageHelper.startPage(page, limit);
        List<CostSite> costs = materialManagementMapper.costSite(siteId);

        PageInfo<CostSite> info = new PageInfo<>(costs);
        //封装自定义的分页对象
        return new PageResult<>(info.getPageSize(), page, info.getTotal(), info.getPages(), costs);
    }

//    public Map<String, Object> findCost(Integer id, String title, Double price,Integer siteId ,String siteName) {
//        Cost cost = new Cost();
//        cost.setId(id);
////        cost.setTitle(title);
//        cost.setPrice(price);
////        cost.setPid(0);
//        cost.setSiteId(siteId);
//        cost.setSiteName(siteName);
//        Cost record = new Cost();
////        record.setPid(id);
//        List<Cost> select = costMapper.select(record);
//        for (Cost t : select) {
//            price += t.getPrice();
//        }
//
//        select.add(cost);
//        Map<String, Object> map = new HashMap<>(4);
//        map.put("list", select);
//        map.put("totalCost", new BigDecimal(price).setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString());
//        return map;
//    }

    public int delete(Integer id) {
        try {
            int i = costMapper.deleteByPrimaryKey(id);
            Cost record = new Cost();
            int counts = costMapper.delete(record);
            return i + counts;
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.DELETE_ERROR);
        }
    }

    public int update(Cost cost) {
        try {
            return costMapper.updateByPrimaryKeySelective(cost);
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.UPDATE_ERROR);
        }
    }
}
