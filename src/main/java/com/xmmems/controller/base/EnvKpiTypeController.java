package com.xmmems.controller.base;

import com.xmmems.domain.env.EnvKpiType;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EnvKpiTypeController {

    @Autowired
    private BaseService baseService;

    //查询监测类别
    @GetMapping("/base/kpitype/paginate")
    @SystemControllerLog(descrption = "分页查询监测类别列表", actionType = "4")
    public ResponseEntity<PageResult<EnvKpiType>> baseKpitypePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                  @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                  @RequestParam(value = "kpiTypeName", required = false) String kpiTypeName){
        PageResult<EnvKpiType> pageResult = baseService.baseKpitypePageQuery(limit, page, kpiTypeName);
        return ResponseEntity.ok(pageResult);
    }

    //添加监测类别
    @PostMapping("/base/kpitype/save")
    @SystemControllerLog(descrption = "添加监测类别", actionType = "1")
    public ResponseEntity<Void> baseKpitypeSave(@RequestBody EnvKpiType envKpiType){
        baseService.baseKpitypeSave(envKpiType);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //根据id查询
    @GetMapping("/base/kpitype/findById")
    @SystemControllerLog(descrption = "根据id查询监测类别", actionType = "4")
    public ResponseEntity<EnvKpiType> baseKpitypeFindById(@RequestParam(value = "id") Integer id){
        EnvKpiType envKpiType = baseService.baseKpitypeFindById(id);
        return ResponseEntity.ok(envKpiType);
    }

    //根据id更新数据
    @PostMapping("/base/kpitype/update")
    @SystemControllerLog(descrption = "根据id修改监测类别", actionType = "2")
    public ResponseEntity<Void> baseKpitypeUpdate(@RequestBody EnvKpiType envKpiType){
        baseService.baseKpitypeUpdate(envKpiType);
        return ResponseEntity.ok().build();
    }

    //根据id删除数据
    @PostMapping("/base/kpitype/delete")
    @SystemControllerLog(descrption = "根据id删除监测类别", actionType = "3")
    public ResponseEntity<Void> baseKpitypeDelete(@RequestParam(value = "id") Integer id){
        baseService.baseKpitypeDelete(id);
        return ResponseEntity.ok().build();
    }
}
