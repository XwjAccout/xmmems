package com.xmmems.controller.warning;

import com.xmmems.domain.env.EnvWarnRecord;
import com.xmmems.domain.env.EnvWarningRule;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.warning.WarnRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warnRecord")
public class WarnRecordController {
    @Autowired
    WarnRecordService warnRecordService;
    /**
     * 分页查询报警数据
     * @param limit
     * @param page
    //     * @param
     * @return
     */
    @GetMapping("/paginate")
    @SystemControllerLog(descrption = "分页查询报警数据", actionType = "4")
    public ResponseEntity<PageResult<EnvWarnRecord>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                   @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                   @RequestParam(value = "siteId", required = false) Integer siteId){
        PageResult<EnvWarnRecord> pageResult = warnRecordService.pageQuery(limit, page,siteId);
        return ResponseEntity.ok(pageResult);
    }





}
