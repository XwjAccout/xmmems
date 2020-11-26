package com.xmmems.controller.maintenance;

import com.xmmems.domain.OperationPerson;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.maintenance.OperationPersonSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("operationPerson")
public class OperationPersonController {
    @Autowired
    private OperationPersonSerice operationPersonSerice;


    /**
     * 分页查询角色
     */
    @GetMapping("/paginate")
    @SystemControllerLog(descrption = "分页查询运维单位人员", actionType = "1")
    public ResponseEntity<PageResult<OperationPerson>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                     @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                     @RequestParam(value = "name", required = true) String name
                                                                     ,@RequestParam(value = "unitID", required = false) Integer unitID){
        PageResult<OperationPerson> pageResult = operationPersonSerice.pageQuery(limit, page, name,unitID);
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 根据id查找角色
     */
    @GetMapping("/findById")
    @SystemControllerLog(descrption = "根据id查询运维人员", actionType = "2")
    public ResponseEntity<OperationPerson> findById(@RequestParam(value = "id") Integer id){
        OperationPerson operationPerson = operationPersonSerice.findById(id);
        return ResponseEntity.ok(operationPerson);
    }

    /**
     * 添加账户用户
     */
    @PostMapping("/save")
    @SystemControllerLog(descrption = "添加运维人员", actionType = "3")
    public ResponseEntity<Void> save(@RequestBody OperationPerson operationPerson) {
        operationPersonSerice.save(operationPerson);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 更新账户用户
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST )
    @ResponseBody
    @SystemControllerLog(descrption = "修改运维人员", actionType = "4")
    public ResponseEntity<Void> update(@RequestBody OperationPerson operationPerson) {
        operationPersonSerice.update(operationPerson);
        return ResponseEntity.ok().build();
    }

    /**
     * 根据id删除账户用户
     */
    @PostMapping("/delete")
    @SystemControllerLog(descrption = "根据id删除运维人员", actionType = "5")
    public ResponseEntity<Void> delete(@RequestParam(value = "id") Integer id) {
        operationPersonSerice.delete(id);
        return ResponseEntity.ok().build();
    }
}
