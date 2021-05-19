package com.xmmems.controller;

import com.xmmems.domain.ExceedStandard;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.ExceedStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/exceed")
public class ExceedStandardController {
    @Autowired
    private ExceedStandardService exceedStandardService;

    @GetMapping("/findByDateAndSiteName")
    @SystemControllerLog(descrption = "查询超标情况统计", actionType = "4")
    public ResponseEntity<List<ExceedStandard>> findByDateAndSiteName(
            @RequestParam("start") String start,
            @RequestParam("end") String end,
            @RequestParam(value = "siteId") String siteId,
            @RequestParam(value = "scale", defaultValue = "false") Boolean scale) {
        List<ExceedStandard> list = exceedStandardService.findByDateAndSiteName(start, end, siteId, scale);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/realtime")
    @SystemControllerLog(descrption = "实时达标情况", actionType = "4")
    public ResponseEntity<List<Map<String, Object>>> realtime(
            @RequestParam(value = "siteType", required = false) String siteType) {
        List<Map<String, Object>> realtime = exceedStandardService.realtime(siteType);
        return ResponseEntity.ok(realtime);
    }

    @GetMapping("/qualityEvaluation")
    @SystemControllerLog(descrption = "查询质量评价", actionType = "4")
    public Object qualityEvaluation(@RequestParam(value = "siteId", required = false) String siteId) {
        return exceedStandardService.qualityEvaluation(siteId);
    }
}
