package com.xmmems.controller.monitor;

import com.xmmems.domain.env.EnvWarnRecord;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitor/warning")
public class WarningController {

    @Autowired
    private WarningService warningService;

    /**
     * 查询报警数据
     */
    @GetMapping("/getWarningData")
    @SystemControllerLog(descrption = "分页查询报警数据", actionType = "4")
    public ResponseEntity<PageResult<EnvWarnRecord>> getWarningData(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                    @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                    @RequestParam(value = "startTime") String startTime,
                                                                    @RequestParam(value = "endTime") String endTime,
                                                                    @RequestParam(value = "siteId", required = false) String siteId) {
        PageResult<EnvWarnRecord> pageResult = warningService.getWarningData(limit, page, startTime, endTime, siteId);
        return ResponseEntity.ok(pageResult);
    }

}
