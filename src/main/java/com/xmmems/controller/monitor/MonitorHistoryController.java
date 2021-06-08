package com.xmmems.controller.monitor;

import com.xmmems.dto.BaseSiteitemDTO;
import com.xmmems.dto.PageResult;
import com.xmmems.service.MonitorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/monitor/history")
@Slf4j
public class MonitorHistoryController {
    @Autowired
    private MonitorService monitorService;

    /**
     * 获取表头数据，也就是站点项目信息
     */
    @GetMapping("/getColumns")
    public ResponseEntity<List<BaseSiteitemDTO>> getColumns(@RequestParam(value = "siteId") Integer siteId) {
        List<BaseSiteitemDTO> list = monitorService.getColumns(siteId);
        return ResponseEntity.ok(list);
    }

    /**
     * 获取表头数据，也就是站点项目信息
     */
    @GetMapping("/getColumnsAll")
    public ResponseEntity<List<BaseSiteitemDTO>> getColumnsAll(@RequestParam(value = "siteType", required = false) String siteType) {
        List<BaseSiteitemDTO> list = monitorService.getColumnsAll(siteType);
        return ResponseEntity.ok(list);
    }

    /**
     * 分页查询历史数据
     */
    @GetMapping("/getHistoryData")
    public ResponseEntity<PageResult<Map<String, Object>>> getHistoryData(
            @RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "siteId") Integer siteId,
            @RequestParam(value = "startTime") String startTime,
            @RequestParam(value = "endTime") String endTime
    ) {
        log.info("分页查询历史数据");
        PageResult<Map<String, Object>> list = monitorService.getHistoryData(limit, page, siteId, startTime, endTime, "ASC",true);
        return ResponseEntity.ok(list);
    }

    /**
     * 单参数趋势变化分析
     */
    @GetMapping("/trend")
    public ResponseEntity<List<Map<String, Object>>> trend(@RequestParam(value = "itemName", required = false) String itemName,
                                                           @RequestParam(value = "trend", required = false) String trend) {
        List<Map<String, Object>> list = monitorService.trend(itemName, trend);
        return ResponseEntity.ok(list);
    }
}
