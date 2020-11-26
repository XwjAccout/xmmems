package com.xmmems.controller.base;

import com.xmmems.domain.base.BaseItem;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BaseItemController {

    @Autowired
    private BaseService baseService;

    //查询监测项目
    @GetMapping("/base/item/paginate")
    @SystemControllerLog(descrption = "分页查询监测项目列表", actionType = "4")
    public ResponseEntity<PageResult<BaseItem>> baseItemPageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                  @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                  @RequestParam(value = "typeName", required = false) String typeName,
                                                                  @RequestParam(value = "itemName", required = false) String itemName){
        PageResult<BaseItem> pageResult  = baseService.baseItemPageQuery(limit, page, typeName,itemName);
        return ResponseEntity.ok(pageResult);
    }

    //添加监测项目
    @PostMapping("/base/item/save")
    @SystemControllerLog(descrption = "添加监测项目", actionType = "1")
    public ResponseEntity<Void> baseItemSave(@RequestBody BaseItem baseItem){
        baseService.baseItemSave(baseItem);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //根据id查询
    @GetMapping("/base/item/findById")
    @SystemControllerLog(descrption = "根据id查找监测项目", actionType = "4")
    public ResponseEntity<BaseItem> baseItemFindById(@RequestParam(value = "id") Integer id){
        BaseItem baseItem = baseService.baseItemFindById(id);
        return ResponseEntity.ok(baseItem);
    }

    //根据id更新数据
    @PostMapping("/base/item/update")
    @SystemControllerLog(descrption = "根据id修改监测项目", actionType = "2")
    public ResponseEntity<Void> baseItemUpdate(@RequestBody BaseItem baseSite){
        baseService.baseItemUpdate(baseSite);
        return ResponseEntity.ok().build();
    }

    //根据id删除数据
    @PostMapping("/base/item/delete")
    @SystemControllerLog(descrption = "根据id删除监测项目", actionType = "3")
    public ResponseEntity<Void> baseItemDelete(@RequestParam(value = "id") Integer id){
        baseService.baseItemDelete(id);
        return ResponseEntity.ok().build();
    }

    //查询所有常用项目,默认常用
    @GetMapping("/base/item/findAllByOften")
    //@SystemControllerLog(descrption = "根据id查找监测项目", actionType = "4")
    public ResponseEntity<List<Map<String, Object>>> findAllByOften(@RequestParam(value = "often",defaultValue = "1") String often){
        List<Map<String, Object>> map = baseService.findAllByOften(often);
        return ResponseEntity.ok(map);
    }
}
