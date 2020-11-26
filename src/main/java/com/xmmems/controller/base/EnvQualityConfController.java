package com.xmmems.controller.base;

import com.xmmems.domain.env.EnvQualityConf;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EnvQualityConfController {

    @Autowired
    private BaseService baseService;

    //查询质量类别
    @GetMapping("/base/qualityconf/paginate")
    @SystemControllerLog(descrption = "分页查询质量类别列表", actionType = "4")
    public ResponseEntity<PageResult<EnvQualityConf>> baseQualityconfPageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                  @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                  @RequestParam(value = "kpiName", required = false) String kpiName){
        PageResult<EnvQualityConf> pageResult = baseService.baseQualityconfPageQuery(limit, page, kpiName);
        return ResponseEntity.ok(pageResult);
    }

    //添加质量类别
    @PostMapping("/base/qualityconf/save")
    @SystemControllerLog(descrption = "添加质量类别", actionType = "1")
    public ResponseEntity<Void> baseQualityconfSave(@RequestBody EnvQualityConf envQualityConf){
        baseService.baseQualityconfSave(envQualityConf);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //根据id查询
    @GetMapping("/base/qualityconf/findById")
    @SystemControllerLog(descrption = "根据id查询质量类别", actionType = "4")
    public ResponseEntity<EnvQualityConf> baseQualityconfFindById(@RequestParam(value = "id") Integer id){
        EnvQualityConf envQualityConf = baseService.baseQualityconfFindById(id);
        return ResponseEntity.ok(envQualityConf);
    }

    //根据id更新数据
    @PostMapping("/base/qualityconf/update")
    @SystemControllerLog(descrption = "根据id修改质量类别", actionType = "2")
    public ResponseEntity<Void> baseQualityconfUpdate(@RequestBody EnvQualityConf envQualityConf){
        baseService.baseQualityconfUpdate(envQualityConf);
        return ResponseEntity.ok().build();
    }

    //根据id删除数据
    @PostMapping("/base/qualityconf/delete")
    @SystemControllerLog(descrption = "根据id删除质量类别", actionType = "3")
    public ResponseEntity<Void> baseQualityconfDelete(@RequestParam(value = "id") Integer id){
        baseService.baseQualityconfDelete(id);
        return ResponseEntity.ok().build();
    }
}
