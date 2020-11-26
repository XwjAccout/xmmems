package com.xmmems.controller.base;

import com.xmmems.domain.base.BaseArea;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BaseAreaController {

    @Autowired
    private BaseService baseService;

    //查询区域信息
    @GetMapping("/base/area/paginate")
    @SystemControllerLog(descrption = "分页查询区域列表", actionType = "4")
    public ResponseEntity<PageResult<BaseArea>> baseAreaPageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                  @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                  @RequestParam(value = "provinceCode", defaultValue = "44") String provinceCode,
                                                                  @RequestParam(value = "areaName", required = false) String areaName){
        PageResult<BaseArea> pageResult = baseService.baseAreaPageQuery(limit, page, areaName,provinceCode);
        return ResponseEntity.ok(pageResult);
    }

    //根据id查询
    @GetMapping("/base/area/findById")
    @SystemControllerLog(descrption = "根据id查询区域", actionType = "4")
    public ResponseEntity<BaseArea> baseAreaFindById(@RequestParam(value = "id") Integer id){
        BaseArea baseArea =  baseService.baseAreaFindById(id);
        return ResponseEntity.ok(baseArea);
    }

    //根据id更新数据
    @PostMapping("/base/area/update")
    @SystemControllerLog(descrption = "根据id修改区域", actionType = "2")
    public ResponseEntity<Void> baseAreaUpdate(@RequestBody BaseArea baseSite){
        baseService.baseAreaUpdate(baseSite);
        return ResponseEntity.ok().build();
    }

    /**
     * 根据id删除数据
     */
    @PostMapping("/base/area/delete")
    @SystemControllerLog(descrption = "根据id删除区域", actionType = "3")
    public ResponseEntity<Void> baseAreaDelete(@RequestParam(value = "id") Integer id){
        baseService.baseAreaDelete(id);
        return ResponseEntity.ok().build();
    }

}
