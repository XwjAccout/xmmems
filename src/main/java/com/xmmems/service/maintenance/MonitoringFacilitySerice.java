package com.xmmems.service.maintenance;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.domain.MonitoringFacility;
import com.xmmems.domain.MonitoringFacilityExample;
import com.xmmems.domain.OperationUnit;
import com.xmmems.domain.OperationUnitExample;
import com.xmmems.domain.base.BaseAnalysiswayExample;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.BaseAnalysiswayMapper;
import com.xmmems.mapper.MonitoringFacilityMapper;
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
public class MonitoringFacilitySerice {
    @Autowired
    private MonitoringFacilityMapper monitoringFacilityMapper;
    @Autowired
    private BaseAnalysiswayMapper baseAnalysiswayMapper;
    @Autowired
    private  OperationUnitMapper oerationUnitMapper;


    public PageResult<MonitoringFacility> pageQuery(Integer limit, Integer page) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            MonitoringFacilityExample example = new MonitoringFacilityExample();
            // example.setOrderByClause("id desc");
            MonitoringFacilityExample.Criteria criteria = example.createCriteria();
            // criteria.andIsvalidEqualTo("1");
            List<MonitoringFacility> baseSites = monitoringFacilityMapper.selectByExample(example);


            //得到pageHelper的分页对象
            PageInfo<MonitoringFacility> pageInfo = new PageInfo<MonitoringFacility>(baseSites);
            //封装自定义的分页对象

            return new PageResult<MonitoringFacility>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.ROLE_NOT_FOUND);
        }
    }

    public MonitoringFacility findById(Integer id) {
        return monitoringFacilityMapper.selectByPrimaryKey(id);
    }

    public void save(MonitoringFacility oerationUnit) {
        int i = monitoringFacilityMapper.insertSelective(oerationUnit);
        if (i < 1) {
            throw new XMException(ExceptionEnum.INSERT_OPERATION_FAIL);
        }
    }

    public void update(MonitoringFacility monitoringFacility) {
        int i = monitoringFacilityMapper.updateByPrimaryKeySelective(monitoringFacility);
        if (i < 1) {
            throw new XMException(ExceptionEnum.UPDATE_OPERATION_FAIL);
        }
    }

    public void delete(Integer id) {
        int i = monitoringFacilityMapper.deleteByPrimaryKey(id);
        if (i < 1) {
            throw new XMException(ExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }
    public List selectAnalysisway(){
        BaseAnalysiswayExample example = new BaseAnalysiswayExample();
        return baseAnalysiswayMapper.selectByExample(example);
    }


    public  List<Map<String, Object>> treeform(){
        List<Map<String, Object>> list0 = new ArrayList<>();
        OperationUnitExample example = new OperationUnitExample();
        List<OperationUnit> operationUnit = oerationUnitMapper.selectByExample(example);

        //不为空
        if (!CollectionUtils.isEmpty(operationUnit)) {
            Map<String, Object> map0 = new HashMap<>();
            List<Map<String, Object>> list1 = new ArrayList<>();
            for (OperationUnit menu1 : operationUnit) {
                if (menu1.getId().equals(menu1.getId())) {
                    Map<String, Object> map1 = new HashMap<>();
                    map1.put("name", menu1.getUnitName());
                    map1.put("id", menu1.getId());
                    List<Map<String, Object>> list2 = new ArrayList<>();
                    List<MonitoringFacility> menuslist = monitoringFacilityMapper.selectByUnitId(menu1.getId());
                    for (MonitoringFacility menu2 : menuslist) {
                        if (menu2.getUnitID().equals(menu1.getId())) {
                            Map<String, Object> map2 = new HashMap<>();
                            map2.put("analysisWay", menu2.getAnalysisWay());
                            map2.put("id", menu2.getId());
                            map2.put("equipmentModel", menu2.getEquipmentModel());
                            map2.put("name", menu2.getEquipmentName());
                            map2.put("testOption", menu2.getId());
                            map2.put("reagent", menu2.getReagent());
                            map2.put("detection", menu2.getDetection());
                            map2.put("unitID", menu2.getUnitID());
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
