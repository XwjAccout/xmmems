package com.xmmems.material.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.InventorydetailsMapper;
import com.xmmems.mapper.MaterialManagementMapper;
import com.xmmems.material.domain.MaterialManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2021.02.23 09:56
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class MaterialManagementService {
    @Autowired
    private MaterialManagementMapper materialManagementMapper;

    @Autowired
    InventorydetailsMapper inventorydetailsMapper;

    public PageResult<MaterialManagement> findPage(Integer limit, Integer page, String name, Integer siteId, String type,String warnType) {

        //封装分页信息
        PageHelper.startPage(page, limit);
        List<MaterialManagement> materialManagements= materialManagementMapper.num(name,siteId,type);
        PageInfo<MaterialManagement> info = new PageInfo<>(materialManagements);
        List<MaterialManagement> materialManagements1=new ArrayList<>();
        //因为中间经过处理，所以分页插件总数需要重新设置
        materialManagements.forEach(temp -> {
            //处理预警状态
            if(temp.getNum()!=null){
                Integer count = temp.getNum();
                Integer warnCount = temp.getWarnCount();
                if (count > warnCount) {
                    temp.setWarnType("未预警");
                } else {
                    temp.setWarnType("预警");
                }
            }else{
                temp.setWarnType("未预警");
            }
            if("预警".equals(temp.getWarnType())){
                materialManagements1.add(temp);
            }

        });
        PageResult<MaterialManagement> result=null;
        if("预警".equals(warnType)){
            result   = new PageResult<>(info.getPageSize(), page, info.getTotal(), info.getPages(), materialManagements1);
        }else{
            result   = new PageResult<>(info.getPageSize(), page, info.getTotal(), info.getPages(), materialManagements);
        }
        return result;
    }

    public void addOrUpdate(List<MaterialManagement> list) {
       for(int i=0; i<list.size();i++){
           MaterialManagement materialManagement = new MaterialManagement();
           materialManagement.setName(list.get(i).getName());
           materialManagement.setSiteId(list.get(i).getSiteId());

           if (list.get(i).getId() != null) {
               materialManagement.setId(list.get(i).getId());
               materialManagement.setSiteName(list.get(i).getSiteName());
               materialManagement.setWarnCount(list.get(i).getWarnCount());
               materialManagement.setUnit(list.get(i).getUnit());
               materialManagement.setRemarks(list.get(i).getRemarks());
               materialManagement.setType(list.get(i).getType());
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
               select.setSiteName(list.get(i).getSiteName());
               select.setWarnCount(list.get(i).getWarnCount());
               select.setUnit(list.get(i).getUnit());
               select.setRemarks(list.get(i).getRemarks());
               try {
                   materialManagementMapper.updateByPrimaryKeySelective(select);
               } catch (Exception e) {
                   throw new XMException(ExceptionEnum.UPDATE_ERROR);
               }

           } else {
               //数据库还未有该物资，新增数据
               materialManagement.setSiteName(list.get(i).getSiteName());
               materialManagement.setWarnCount(list.get(i).getWarnCount());
               materialManagement.setUnit(list.get(i).getUnit());
               materialManagement.setRemarks(list.get(i).getRemarks());
               materialManagement.setType(list.get(i).getType());
               try {
                   materialManagementMapper.insertSelective(materialManagement);
               } catch (Exception e) {
                   throw new XMException(ExceptionEnum.INSERT_ERROR);
               }

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

    public Integer add( MaterialManagement materialManagement){
      return  materialManagementMapper.insertSelective(materialManagement);
    }

    public Integer update( MaterialManagement materialManagement){
        return  materialManagementMapper.updateByPrimaryKey(materialManagement);
    }

}
