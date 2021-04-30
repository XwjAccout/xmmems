package com.xmmems.material.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.InventorydetailsMapper;
import com.xmmems.mapper.MaterialManagementMapper;
import com.xmmems.material.domain.Inventorydetails;
import com.xmmems.material.domain.MaterialManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class InventorydetailsService {
  @Autowired
  private   InventorydetailsMapper inventorydetailsMapper;
    @Autowired
    private MaterialManagementMapper materialManagementMapper;
    //添加库存
    public void addnumber(Inventorydetails inventorydetails){
        inventorydetailsMapper.insertSelective(inventorydetails);
    }

    //消耗
    public void consume(Integer id, Integer num,int mId,String name,String nextexpendTime) {
        Inventorydetails inventorydetails = inventorydetailsMapper.selectByPrimaryKey(id);
        MaterialManagement materialManagement  = materialManagementMapper.numBymid(mId);
        if (materialManagement.getNum() >= num) {
            inventorydetails.setNum(inventorydetails.getNum()-num);
            inventorydetails.setConsume(num);
            inventorydetails.setName(name);
            inventorydetails.setNextexpendTime(nextexpendTime);
            inventorydetailsMapper.updateByPrimaryKey(inventorydetails);
        } else {
            throw new XMException(500, "库存不足");
        }
    }

    public PageResult<Inventorydetails> findPage(Integer limit, Integer page,Integer mid) {
        PageHelper.startPage(page, limit);
        Example example = new Example(Inventorydetails.class);
        example.setOrderByClause("id desc");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("mid", mid);
        List<Inventorydetails> costs = inventorydetailsMapper.selectByExample(example);
        //因为中间经过处理，所以分页插件总数需要重新设置
        costs.forEach(temp -> {
            //处理预警状态
            Integer count = temp.getNum();
            Integer consume = temp.getNum();
            temp.setResidue(count-consume);
        });
        PageInfo<Inventorydetails> info = new PageInfo<>(costs);
        //封装自定义的分页对象
        return new PageResult<>(info.getPageSize(), page, info.getTotal(), info.getPages(), costs);
    }

    public void delete(Integer id) {
        try {
             materialManagementMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.DELETE_ERROR);
        }
    }

}
