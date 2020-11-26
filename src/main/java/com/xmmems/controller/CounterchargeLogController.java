package com.xmmems.controller;

import com.xmmems.domain.CounterchargeLog;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.CounterchargeLogSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("counterchargeLog")
public class CounterchargeLogController {
    @Autowired
    private CounterchargeLogSerice counterchargeLogSerice;


    /**
     * 分页查询角色
     */
    @GetMapping("/paginate")
    @SystemControllerLog(descrption = "分页查询反控日志", actionType = "1")
    public ResponseEntity<PageResult<CounterchargeLog>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                  @RequestParam(value = "page", defaultValue = "1") Integer page){
        PageResult<CounterchargeLog> pageResult = counterchargeLogSerice.pageQuery(limit, page);
        return ResponseEntity.ok(pageResult);
    }

}
