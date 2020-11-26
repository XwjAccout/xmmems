package com.xmmems.controller.maintenance;

import com.xmmems.domain.MonitoringFacility;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.maintenance.MonitoringFacilitySerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("monitoringFacility")
public class MonitoringFacilityController {
    @Autowired
    private MonitoringFacilitySerice monitoringFacilitySerice;


    /**
     * 分页查询角色
     */
    @GetMapping("/paginate")
    @SystemControllerLog(descrption = "分页查询监测设备", actionType = "1")
    public ResponseEntity<PageResult<MonitoringFacility>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                  @RequestParam(value = "page", defaultValue = "1") Integer page){
        PageResult<MonitoringFacility> pageResult = monitoringFacilitySerice.pageQuery(limit, page);
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 根据id查找角色
     */
    @GetMapping("/findById")
    @SystemControllerLog(descrption = "根据id查询监测设备", actionType = "2")
    public ResponseEntity<MonitoringFacility> findById(@RequestParam(value = "id") Integer id){
        MonitoringFacility  monitoringFacility = monitoringFacilitySerice.findById(id);
        return ResponseEntity.ok(monitoringFacility);
    }

    /**
     * 添加账户用户
     */
    @PostMapping("/save")
    @SystemControllerLog(descrption = "添加监测设备", actionType = "3")
    public ResponseEntity<Void> save(@RequestBody MonitoringFacility  monitoringFacility) {
        monitoringFacilitySerice.save(monitoringFacility);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 更新账户用户
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST )
    @ResponseBody
    @SystemControllerLog(descrption = "修改监测设备", actionType = "4")
    public ResponseEntity<Void> update(@RequestBody  MonitoringFacility  monitoringFacility) {
        monitoringFacilitySerice.update(monitoringFacility);
        return ResponseEntity.ok().build();
    }

    /**
     * 根据id删除账户用户
     */
    @PostMapping("/delete")
    @SystemControllerLog(descrption = "根据id删除监测设备", actionType = "5")
    public ResponseEntity<Void> delete( @RequestParam(value = "id") Integer id) {
        monitoringFacilitySerice.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAnalysisway")
    @SystemControllerLog(descrption = "查询分析方法", actionType = "5")
    public ResponseEntity<List> selectAnalysisway() {
       List list= monitoringFacilitySerice.selectAnalysisway();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/treeform")
    @SystemControllerLog(descrption = "监测设备树形结构", actionType = "5")
    public  ResponseEntity<List> treeform(){
        List<Map<String, Object>> list= monitoringFacilitySerice.treeform();
        return ResponseEntity.ok(list);
    }
}
