package com.xmmems.controller.warning;

import com.xmmems.domain.EnvWarningDataLoss;
import com.xmmems.domain.env.EnvAddressBook;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.warning.AddressBookService;
import com.xmmems.service.warning.WarningDataLossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warningDataLoss")
public class WarningDataLossController {

    @Autowired
    WarningDataLossService warningDataLossService;
    /**
     * 分页查询数据缺失报警
     * @param limit
     * @param page
     * @param name
     * @return
     */
    @GetMapping("/paginate")
    @SystemControllerLog(descrption = "分页查询数据缺失报警", actionType = "4")
    public ResponseEntity<PageResult<EnvWarningDataLoss>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                        @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                        @RequestParam(value = "name", required = false) String name){
        PageResult<EnvWarningDataLoss> pageResult = warningDataLossService.pageQuery(limit, page, name);
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 更新角色
     * @param envWarningDataLoss
     * @return
     */
    @PostMapping("/update")
    @SystemControllerLog(descrption = "修改数据缺失报警", actionType = "2")
    public ResponseEntity<Void> update(@RequestBody EnvWarningDataLoss envWarningDataLoss){
        warningDataLossService.update(envWarningDataLoss);
        return ResponseEntity.ok().build();
    }
}
