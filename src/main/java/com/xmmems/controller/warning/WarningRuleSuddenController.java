package com.xmmems.controller.warning;

import com.xmmems.domain.env.EnvWarningRuleSudden;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.warning.WarningRuleSuddenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warningRuleSudden")
public class WarningRuleSuddenController {

    @Autowired
    WarningRuleSuddenService warningRuleSuddenService;


    /**
     * 分页查询突变报警规则
     * @param limit
     * @param page
     * @param
     * @return
     */
    @GetMapping("/paginate")
    @SystemControllerLog(descrption = "分页查询突变报警规则", actionType = "4")
    public ResponseEntity<PageResult<EnvWarningRuleSudden>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                    @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                    @RequestParam(value = "siteId", required = false) Integer siteId){
        PageResult<EnvWarningRuleSudden> pageResult = warningRuleSuddenService.pageQuery(limit, page,siteId);
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 根据id查找突变报警规则
     * @param id
     * @return
     */
    @GetMapping("/findById")
    @SystemControllerLog(descrption = "根据id查询突变报警规则", actionType = "4")
    public ResponseEntity<EnvWarningRuleSudden> findById(@RequestParam(value = "id") Integer id){
        EnvWarningRuleSudden envAddressBook = warningRuleSuddenService.findById(id);
        return ResponseEntity.ok(envAddressBook);
    }

    /**
     * 添加突变报警规则
     * @param warningRuleSudden
     * @return
     */
    @PostMapping("/save")
    @SystemControllerLog(descrption = "添加突变报警规则", actionType = "1")
    public ResponseEntity<Void> save(@RequestBody EnvWarningRuleSudden warningRuleSudden){
        warningRuleSuddenService.save(warningRuleSudden);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 更新报警规则
     * @param warningRuleSudden
     * @return
     */
    @PostMapping("/update")
    @SystemControllerLog(descrption = "修改报警规则", actionType = "2")
    public ResponseEntity<Void> update(@RequestBody EnvWarningRuleSudden warningRuleSudden){
        warningRuleSuddenService.update(warningRuleSudden);
        return ResponseEntity.ok().build();
    }

    /**
     * 根据id删除突变报警规则
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @SystemControllerLog(descrption = "根据id删除突变报警规则", actionType = "3")
    public ResponseEntity<Void> delete(@RequestParam(value = "id") Integer id){
        warningRuleSuddenService.delete(id);
        return ResponseEntity.ok().build();
    }


}
