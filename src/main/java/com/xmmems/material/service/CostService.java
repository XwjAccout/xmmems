package com.xmmems.material.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.CostMapper;
import com.xmmems.material.domain.Cost;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void add(String title, Double price, Integer pid) {
        try {
            Cost record = new Cost();
            record.setTitle(title);
            record.setPrice(price);
            record.setPid(pid);
            costMapper.insertSelective(record);
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.INSERT_ERROR);
        }
    }

    public PageResult<Cost> findPage(Integer limit, Integer page, String title) {
        PageHelper.startPage(page, limit);
        Example example = new Example(Cost.class);
        example.setOrderByClause("id desc");
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("pid", 0);
        if (StringUtils.isNotBlank(title)) {
            criteria.andLike("title", "%" + title + "%");
        }

        List<Cost> costs = costMapper.selectByExample(example);
        PageInfo<Cost> info = new PageInfo<>(costs);
        //封装自定义的分页对象
        return new PageResult<>(info.getPageSize(), page, info.getTotal(), info.getPages(), costs);
    }

    public Map<String, Object> findCost(Integer id, String title, Double price) {
        Cost cost = new Cost();
        cost.setId(id);
        cost.setTitle(title);
        cost.setPrice(price);
        cost.setPid(0);

        Cost record = new Cost();
        record.setPid(id);
        List<Cost> select = costMapper.select(record);
        for (Cost t : select) {
            price += t.getPrice();
        }

        select.add(cost);
        Map<String, Object> map = new HashMap<>(4);
        map.put("list", select);
        map.put("totalCost", new BigDecimal(price).setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString());
        return map;
    }

    public int delete(Integer id) {
        try {
            int i = costMapper.deleteByPrimaryKey(id);
            Cost record = new Cost();
            record.setPid(id);
            int counts = costMapper.delete(record);
            return i + counts;
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.DELETE_ERROR);
        }
    }

    public int update(Integer id, String title, Double price, Integer pid) {
        Cost record = new Cost();
        record.setId(id);
        record.setPid(pid);
        record.setPrice(price);
        record.setTitle(title);
        try {
            return costMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.UPDATE_ERROR);
        }
    }
}
