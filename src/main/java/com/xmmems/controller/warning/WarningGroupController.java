package com.xmmems.controller.warning;

import com.xmmems.domain.env.EnvWarningGroup;
import com.xmmems.domain.env.EnvWarningGroupWithBLOBs;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.warning.WarningGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warningGroup")
public class WarningGroupController {

    @Autowired
    WarningGroupService warningGroupService;
    /**
     * 分页查询报警群组
     * @param limit
     * @param page
     * @param name
     * @return
     */
    @GetMapping("/paginate")
    @SystemControllerLog(descrption = "分页查询报警群组", actionType = "4")
    public ResponseEntity<PageResult<EnvWarningGroup>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                    @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                    @RequestParam(value = "name", required = false) String name){
        PageResult<EnvWarningGroup> pageResult = warningGroupService.pageQuery(limit, page);
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 根据id查找报警群组
     * @param id
     * @return
     */
    @GetMapping("/findById")
    @SystemControllerLog(descrption = "根据id查询报警群组", actionType = "4")
    public ResponseEntity<EnvWarningGroup> findById(@RequestParam(value = "id") Integer id){
        EnvWarningGroup envAddressBook = warningGroupService.findById(id);
        return ResponseEntity.ok(envAddressBook);
    }

    /**
     * 添加报警群组
     * @param envAddressBook
     * @return
     */
    @PostMapping("/save")
    @SystemControllerLog(descrption = "添加报警群组", actionType = "1")
    public ResponseEntity<Void> save(@RequestBody EnvWarningGroupWithBLOBs envAddressBook){
        warningGroupService.save(envAddressBook);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 更新通讯录
     * @param envAddressBook
     * @return
     */
    @PostMapping("/update")
    @SystemControllerLog(descrption = "修改报警群组", actionType = "2")
    public ResponseEntity<Void> update(@RequestBody EnvWarningGroupWithBLOBs envAddressBook){
        warningGroupService.update(envAddressBook);
        return ResponseEntity.ok().build();
    }

    /**
     * 根据id删除通讯录
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @SystemControllerLog(descrption = "根据id删除报警群组", actionType = "3")
    public ResponseEntity<Void> delete(@RequestParam(value = "id") Integer id){
        warningGroupService.delete(id);
        return ResponseEntity.ok().build();
    }



}
