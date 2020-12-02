package com.xmmems.controller.monitor;

import com.xmmems.domain.base.BaseSiteitem;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.BaseService;
import com.xmmems.service.MonitorService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("monitor/chart")
public class MonitorChartController {
    @Autowired
    private MonitorService monitorService;

    @Autowired
    private BaseService baseService;

    /**
     * 获取监测项目列表
     */
    @GetMapping("/getSiteItem")
    @SystemControllerLog(descrption = "根据站点id获取监测项目列表", actionType = "4")
    public ResponseEntity<List<BaseSiteitem>> getSiteItem(@RequestParam("siteId") Integer siteId) {
        List<BaseSiteitem> list = baseService.getSiteItem(siteId);
        return ResponseEntity.ok(list);
    }

    /**
     * 获取时段曲线数据
     */
    @GetMapping("/dayData")
    @SystemControllerLog(descrption = "获取时段曲线数据", actionType = "4")
    public ResponseEntity<List<Map<String, String>>> dayData(@RequestParam("siteId") Integer siteId,
                                                             @RequestParam("startTime") String startTime,
                                                             @RequestParam("endTime") String endTime) {
        List<Map<String, String>> list = monitorService.day(siteId, startTime, endTime, null, false);
        //List<Map<String, String>> list = monitorService.dayData(siteId, startTime, endTime);
        if ("平均值".equals(list.get(list.size() - 1).get("moniterTime"))) {
            list.remove(list.size() - 1);
        }
        return ResponseEntity.ok(list);
    }

    /**
     * 获取日均值曲线数据
     */
    @GetMapping("/monthData")
    @SystemControllerLog(descrption = "获取日均值曲线数据", actionType = "4")
    public ResponseEntity<List<Map<String, String>>> monthData(@RequestParam("siteId") Integer siteId,
                                                               @RequestParam("startTime") String startTime,
                                                               @RequestParam("endTime") String endTime) {
        List<Map<String, String>> list = monitorService.month(siteId, startTime, endTime, null, false);
        //List<Map<String, String>> list = monitorService.monthData(siteId, startTime, endTime);
        if ("平均值".equals(list.get(list.size() - 1).get("moniterTime"))) {
            list.remove(list.size() - 1);
        }
        return ResponseEntity.ok(list);
    }

    /**
     * 获取月均值曲线数据
     */
    @GetMapping("/yearData")
    public ResponseEntity<List<Map<String, String>>> yearData(@RequestParam("siteId") Integer siteId,
                                                              @RequestParam("startTime") String startTime,
                                                              @RequestParam("endTime") String endTime) {
        List<Map<String, String>> list = monitorService.year(siteId, startTime, endTime, null, false);
        //List<Map<String, String>> list = monitorService.yearData(siteId, startTime, endTime);
        if ("平均值".equals(list.get(list.size() - 1).get("moniterTime"))) {
            list.remove(list.size() - 1);
        }
        return ResponseEntity.ok(list);
    }


    /**
     * 获取日曲线数据
     */
    @GetMapping("/realDay")
    @SystemControllerLog(descrption = "获取日曲线数据", actionType = "4")
    public ResponseEntity<List<Map<String, String>>> realDay(@RequestParam("siteId") Integer siteId,
                                                             @RequestParam("day") String day) {
        List<Map<String, String>> list = monitorService.realDay(siteId, day, null, false);
        if ("平均值".equals(list.get(list.size() - 1).get("moniterTime"))) {
            list.remove(list.size() - 1);
        }
        return ResponseEntity.ok(list);
    }

    /**
     * 获取月曲线数据
     */
    @GetMapping("/realMonth")
    @SystemControllerLog(descrption = "获取月曲线数据", actionType = "4")
    public ResponseEntity<List<Map<String, String>>> realMonth(@RequestParam("siteId") Integer siteId,
                                                               @RequestParam("year") Integer year,
                                                               @RequestParam("month") Integer month) {
        List<Map<String, String>> list = monitorService.realMonth(siteId, year, month, null, false);
        if ("平均值".equals(list.get(list.size() - 1).get("moniterTime"))) {
            list.remove(list.size() - 1);
        }
        return ResponseEntity.ok(list);
    }

    /**
     * 获取年曲线数据
     */
    @GetMapping("/realYear")
    public ResponseEntity<List<Map<String, String>>> realYear(@RequestParam("siteId") Integer siteId,
                                                              @RequestParam("year") Integer year) {
        List<Map<String, String>> list = monitorService.realYear(siteId, year, null, false);
        if ("平均值".equals(list.get(list.size() - 1).get("moniterTime"))) {
            list.remove(list.size() - 1);
        }
        return ResponseEntity.ok(list);
    }

    /**
     * 获取季曲线数据
     */
    @GetMapping("/realSeasons")
    public ResponseEntity<List<Map<String, String>>> seasons(@RequestParam("siteId") Integer siteId,
                                                             @RequestParam("year") Integer year,
                                                             @RequestParam(value = "isDayAvg", defaultValue = "false") Boolean isDayAvg,
                                                             @RequestParam("seasons") Integer seasons) {
        List<Map<String, String>> list = monitorService.seasons(siteId, seasons, year, null, false, isDayAvg);
        if ("平均值".equals(list.get(list.size() - 1).get("moniterTime"))) {
            list.remove(list.size() - 1);
        }
        return ResponseEntity.ok(list);
    }

    /**
     * 获取原始曲线（异常数据不除去）
     */
    @GetMapping("/initData")
    public ResponseEntity<List<Map<String, Object>>> initData(@RequestParam("siteId") Integer siteId,
                                                              @RequestParam("startTime") String startTime,
                                                              @RequestParam("endTime") String endTime) {
        List<Map<String, Object>> list = monitorService.initData(siteId, startTime, endTime);
        return ResponseEntity.ok(list);
    }

    /**
     * 获取周曲线
     */
    @GetMapping("/weekData")
    public ResponseEntity<List<Map<String, String>>> weekData(@RequestParam("siteId") Integer siteId,
                                                              @RequestParam("year") Integer year,
                                                              @RequestParam("week") Integer week) {
        List<Map<String, String>> list = monitorService.week(siteId, year, week, null, false);
        if ("平均值".equals(list.get(list.size() - 1).get("moniterTime"))) {
            list.remove(list.size() - 1);
        }
        return ResponseEntity.ok(list);
    }

    /**
     * 单参数对比
     * type 1 日  2 周   3 月  4 年
     *
     * @return
     */
    @GetMapping("/singleComparison")
    public ResponseEntity<Object> singleComparison(@RequestParam("startTime") String startTime,
                                                   @RequestParam("endTime") String endTime,
                                                   @RequestParam("type") Integer type,
                                                   @RequestParam(value = "itemName", required = false) String itemName) {
        List<Map<String, String>> body = monitorService.singleComparison(startTime, endTime, type);
        if (StringUtils.isBlank(itemName)) {
            return ResponseEntity.ok(body);
        } else {
            for (Map<String, String> map : body) {
                if (itemName.equals(map.get("itemName"))) {
                    List<Object> list = new ArrayList<>();
                    list.add(map);
                    return ResponseEntity.ok(list);
                }
            }
        }
        return ResponseEntity.ok(null);
    }


}
