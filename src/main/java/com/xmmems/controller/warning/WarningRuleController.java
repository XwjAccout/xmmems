package com.xmmems.controller.warning;

import com.xmmems.domain.env.EnvWarningGroup;
import com.xmmems.domain.env.EnvWarningGroupWithBLOBs;
import com.xmmems.domain.env.EnvWarningRule;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.warning.WarningRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warningRule")
public class WarningRuleController {

    @Autowired
    WarningRuleService warningRuleService;

    /**
     * 分页查询报警规则
     * @param limit
     * @param page
//     * @param
     * @return
     */
    @GetMapping("/paginate")
    @SystemControllerLog(descrption = "分页查询报警规则", actionType = "4")
    public ResponseEntity<PageResult<EnvWarningRule>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                     @RequestParam(value = "page", defaultValue = "200") Integer page,
                                                                     @RequestParam(value = "siteId", required = false) Integer siteId){
        PageResult<EnvWarningRule> pageResult = warningRuleService.pageQuery(limit, page,siteId);
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 根据id查找报警规则
     * @param id
     * @return
     */
    @GetMapping("/findById")
    @SystemControllerLog(descrption = "根据id查询报警规则", actionType = "4")
    public ResponseEntity<EnvWarningRule> findById(@RequestParam(value = "id") Integer id){
        EnvWarningRule envAddressBook = warningRuleService.findById(id);
        return ResponseEntity.ok(envAddressBook);
    }

    /**
     * 添加报警规则
     * @param envAddressBook
     * @return
     */
    @PostMapping("/save")
    @SystemControllerLog(descrption = "添加报警规则", actionType = "1")
    public ResponseEntity<Void> save(@RequestBody EnvWarningRule envAddressBook){
        warningRuleService.save(envAddressBook);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 更新报警规则
     * @param envAddressBook
     * @return
     */
    @PostMapping("/update")
    @SystemControllerLog(descrption = "修改报警规则", actionType = "2")
    public ResponseEntity<Void> update(@RequestBody EnvWarningRule envAddressBook){
        warningRuleService.update(envAddressBook);
        return ResponseEntity.ok().build();
    }

    /**
     * 根据id删除报警规则
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @SystemControllerLog(descrption = "根据id删除报警规则", actionType = "3")
    public ResponseEntity<Void> delete(@RequestParam(value = "id") Integer id){
        warningRuleService.delete(id);
        return ResponseEntity.ok().build();
    }

}
