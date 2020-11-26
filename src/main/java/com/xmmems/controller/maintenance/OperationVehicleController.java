package com.xmmems.controller.maintenance;

import com.xmmems.domain.OperationVehicle;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.maintenance.OperationVehicleSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("operationVehicle")
public class OperationVehicleController {
    @Autowired
    private OperationVehicleSerice operationVehicleSerice;


    /**
     * 分页查询角色
     */
    @GetMapping("/paginate")
    @SystemControllerLog(descrption = "分页查询运维车辆列表", actionType = "1")
    public ResponseEntity<PageResult<OperationVehicle>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                      @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                      @RequestParam(value = "unitID", required = false) Integer unitID,
                                                                      @RequestParam(value = "licence", required = false) String licence) {
        PageResult<OperationVehicle> pageResult = operationVehicleSerice.pageQuery(limit, page, licence, unitID);
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 根据id查找角色
     */
    @GetMapping("/findById")
    @SystemControllerLog(descrption = "根据id查询运维车辆", actionType = "2")
    public ResponseEntity<OperationVehicle> findById(@RequestParam(value = "id") Integer id) {
        OperationVehicle operationVehicle = operationVehicleSerice.findById(id);
        return ResponseEntity.ok(operationVehicle);
    }

    /**
     * 添加账户用户
     */
    @PostMapping("/save")
    @SystemControllerLog(descrption = "添加运维车辆", actionType = "3")
    public ResponseEntity<Void> save(@RequestBody OperationVehicle operationVehicle) {
        operationVehicleSerice.save(operationVehicle);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 更新账户用户
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @SystemControllerLog(descrption = "修改运维车辆", actionType = "4")
    public ResponseEntity<Void> update(@RequestBody OperationVehicle operationVehicle) {
        operationVehicleSerice.update(operationVehicle);
        return ResponseEntity.ok().build();
    }

    /**
     * 根据id删除账户用户
     */
    @PostMapping("/delete")
    @SystemControllerLog(descrption = "根据id删除运维车辆", actionType = "5")
    public ResponseEntity<Void> delete(@RequestParam(value = "id") Integer id) {
        operationVehicleSerice.delete(id);
        return ResponseEntity.ok().build();
    }
}
