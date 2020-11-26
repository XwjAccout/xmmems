package com.xmmems.controller.maintenance;

import com.xmmems.domain.OperationUnit;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.maintenance.OerationUnitSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("oerationUnit")
public class OerationUnitController {

    @Autowired
    private OerationUnitSerice oerationUnitSerice;

    /**
     * 分页查询角色
     */
    @GetMapping("/paginate")
    @SystemControllerLog(descrption = "分页查询运维单位列表", actionType = "1")
    public ResponseEntity<PageResult<OperationUnit>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                   @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                   @RequestParam(value = "unitName", required = false) String unitName){
        PageResult<OperationUnit> pageResult = oerationUnitSerice.pageQuery(limit, page, unitName);
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 根据id查找角色
     */
    @GetMapping("/findById")
    @SystemControllerLog(descrption = "根据id查询运维单位", actionType = "2")
    public ResponseEntity<OperationUnit> findById(@RequestParam(value = "id") Integer id){
        OperationUnit oerationUnit = oerationUnitSerice.findById(id);
        return ResponseEntity.ok(oerationUnit);
    }

    /**
     * 添加账户用户
     */
    @PostMapping("/save")
    @SystemControllerLog(descrption = "添加运维单位", actionType = "3")
    public ResponseEntity<Void> save(@RequestBody OperationUnit oerationUnit) {
        oerationUnitSerice.save(oerationUnit);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 更新账户用户
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST )
    @ResponseBody
    @SystemControllerLog(descrption = "修改运维单位", actionType = "4")
    public ResponseEntity<Void> update(@RequestBody OperationUnit oerationUnit) {
        oerationUnitSerice.update(oerationUnit);
        return ResponseEntity.ok().build();
    }

    /**
     * 根据id删除账户用户
     */
    @PostMapping("/delete")
    @SystemControllerLog(descrption = "根据id删除运维单位", actionType = "5")
    public ResponseEntity<Void> delete(@RequestParam(value = "id") Integer id) {
        oerationUnitSerice.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/treeformUnit")
    @SystemControllerLog(descrption = "运维公司树形结构", actionType = "5")
    public  ResponseEntity<List> treeformunit(){
        List<Map<String, Object>> list= oerationUnitSerice.treeformUnit();
        return ResponseEntity.ok(list);
    }
}
