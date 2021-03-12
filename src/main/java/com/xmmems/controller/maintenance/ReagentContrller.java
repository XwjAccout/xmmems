package com.xmmems.controller.maintenance;

import com.xmmems.domain.OperationPerson;
import com.xmmems.domain.Reagent;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.maintenance.ReagentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reagent")
public class ReagentContrller {

    @Autowired
    ReagentService reagentService;
    /**
     * 分页查询角色
     */
    @GetMapping("/paginate")
    public ResponseEntity<PageResult<Reagent>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                     @RequestParam(value = "page", defaultValue = "1") Integer page){
        PageResult<Reagent> pageResult = reagentService.pageQuery(limit, page);
        return ResponseEntity.ok(pageResult);
    }


    /**
     * 添加
     */
    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<Void> save( Reagent reagent) {
        reagentService.save(reagent);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 更新账户用户
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST )
    @ResponseBody
    public ResponseEntity<Void> update( Reagent reagent) {
        reagentService.update(reagent);
        return ResponseEntity.ok().build();
    }

    /**
     * 根据id删除账户用户
     */
    @PostMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam(value = "id") Integer id) {
        reagentService.delete(id);
        return ResponseEntity.ok().build();
    }

}
