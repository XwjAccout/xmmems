package com.xmmems.controller.monitor;

import com.xmmems.dto.BaseSiteDTO;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/monitor/report")
public class MonitorReportController {

    @Autowired
    private MonitorService monitorService;

    //根据账户id查询站点列表,日，周，月，报表都需要
    @GetMapping("/getSites")
    @SystemControllerLog(descrption = "查询站点列表", actionType = "4")
    public ResponseEntity<List<BaseSiteDTO>> getSites() {
        List<BaseSiteDTO> list = monitorService.getSites();
        return ResponseEntity.ok(list);
    }

    //时段报表查询功能
    @GetMapping("/day/getData")
    @SystemControllerLog(descrption = "时段报表", actionType = "4")
    public ResponseEntity<List<Map<String, String>>> day(@RequestParam(value = "siteId") Integer siteId,
                                                         @RequestParam(value = "startTime") String startTime,
                                                         @RequestParam(value = "endTime") String endTime,
                                                         @RequestParam(value = "statistics", required = false) List<Integer> statistics,
                                                         @RequestParam(value = "limit", defaultValue = "true") Boolean limit) {
        return ResponseEntity.ok(monitorService.day(siteId, startTime, endTime, statistics, limit));
    }

    //周报表查询功能，其实就是按某一周获取7天的日均值报表
    @GetMapping("/week/getData")
    @SystemControllerLog(descrption = "周报表", actionType = "4")
    public ResponseEntity<List<Map<String, String>>> week(@RequestParam(value = "siteId") Integer siteId,
                                                          @RequestParam(value = "year") Integer year,
                                                          @RequestParam(value = "week") Integer week,
                                                          @RequestParam(value = "statistics", required = false) List<Integer> statistics) {
        return ResponseEntity.ok(monitorService.week(siteId, year, week, statistics, false));
    }

    //日均值报表查询功能
    @GetMapping("/month/getData")
    @SystemControllerLog(descrption = "日均值报表", actionType = "4")
    public ResponseEntity<List<Map<String, String>>> month(@RequestParam(value = "siteId") Integer siteId,
                                                           @RequestParam(value = "startTime") String startTime,
                                                           @RequestParam(value = "endTime") String endTime,
                                                           @RequestParam(value = "statistics", required = false) List<Integer> statistics) {
        return ResponseEntity.ok(monitorService.month(siteId, startTime, endTime, statistics, false));
    }

    //月均值报表查询功能
    @GetMapping("/year/getData")
    @SystemControllerLog(descrption = "月均值报表", actionType = "4")
    public ResponseEntity<List<Map<String, String>>> year(@RequestParam(value = "siteId") Integer siteId,
                                                          @RequestParam(value = "startTime") String startTime,
                                                          @RequestParam(value = "endTime") String endTime,
                                                          @RequestParam(value = "statistics", required = false) List<Integer> statistics) {
        return ResponseEntity.ok(monitorService.year(siteId, startTime, endTime, statistics, false));
    }

    //四季报表查询功能，其实就是按某季度获取3个月均值报表的
    @GetMapping("/seasons/getData/real")
    @SystemControllerLog(descrption = "季报表", actionType = "4")
    public ResponseEntity<List<Map<String, String>>> seasons(@RequestParam(value = "siteId") Integer siteId,
                                                             @RequestParam(value = "year") Integer year,
                                                             @RequestParam(value = "seasons") Integer seasons,
                                                             @RequestParam(value = "statistics", required = false) List<Integer> statistics,
                                                             @RequestParam(value = "isDayAvg", defaultValue = "false") Boolean isDayAvg) {
        return ResponseEntity.ok(monitorService.seasons(siteId, seasons, year, statistics, false, isDayAvg));
    }

    //月报表查询功能,其实就是获取某个月的日均值报表
    @GetMapping("/month/getData/real")
    @SystemControllerLog(descrption = "月报表", actionType = "4")
    public ResponseEntity<List<Map<String, String>>> realMonth(@RequestParam(value = "siteId") Integer siteId,
                                                               @RequestParam(value = "year") Integer year,
                                                               @RequestParam(value = "month") Integer month,
                                                               @RequestParam(value = "statistics", required = false) List<Integer> statistics) {
        return ResponseEntity.ok(monitorService.realMonth(siteId, year, month, statistics, false));
    }


    //年报表查询功能，其实就是获取某一年的月均值报表
    @GetMapping("/year/getData/real")
    @SystemControllerLog(descrption = "年报表", actionType = "4")
    public ResponseEntity<List<Map<String, String>>> realYear(@RequestParam(value = "siteId") Integer siteId,
                                                              @RequestParam(value = "year") Integer year,
                                                              @RequestParam(value = "statistics", required = false) List<Integer> statistics) {
        return ResponseEntity.ok(monitorService.realYear(siteId, year, statistics, false));
    }

    //日报表查询功能，其实就是某一天的时段报表
    @GetMapping("/day/getData/real")
    @SystemControllerLog(descrption = "日报表", actionType = "4")
    public ResponseEntity<List<Map<String, String>>> realDay(@RequestParam(value = "siteId") Integer siteId,
                                                             @RequestParam(value = "day") String day,
                                                             @RequestParam(value = "statistics", required = false) List<Integer> statistics,
                                                             @RequestParam(value = "limit", defaultValue = "true") Boolean limit) {
        return ResponseEntity.ok(monitorService.realDay(siteId, day, statistics, limit));
    }
}
