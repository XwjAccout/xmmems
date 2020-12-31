package com.xmmems.controller.monitor;

import com.xmmems.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @描述 这个是自主开发的新功能，都是以一个月一天天计算的数据
 * @创建人 ithxw
 * @创建时间 2020.12.28 15:56
 */
@RestController
@RequestMapping("/")
public class NewFunctionController {

    @Autowired
    private MonitorService monitorService;

    /**
     * 月水质达标分类饼图
     *
     * @param siteId
     * @param year
     * @param month
     * @return
     */
    @GetMapping("/month/quality")
    public ResponseEntity<Map> monthQuality(@RequestParam("siteId") Integer siteId, @RequestParam("year") Integer year, @RequestParam("month") Integer month, @RequestParam(value = "isPercent", defaultValue = "false") Boolean isPercent) {
        return ResponseEntity.ok(monitorService.monthQuality(siteId, year, month, isPercent));
    }

    /**
     * 月数据有效个数统计
     *
     * @param siteId
     * @param year
     * @param month
     * @return
     */
    @GetMapping("/month/efficiency")
    public ResponseEntity<Map> monthEfficiency(@RequestParam("siteId") Integer siteId, @RequestParam("year") Integer year, @RequestParam("month") Integer month, @RequestParam(value = "isPercent", defaultValue = "false") Boolean isPercent) {
        return ResponseEntity.ok(monitorService.monthEfficiency(siteId, year, month, isPercent));
    }

    /**
     * 月联网情况统计
     *
     * @param siteId
     * @param year
     * @param month
     * @return
     */
    @GetMapping("/month/onLine")
    public ResponseEntity<Map> monthOnline(@RequestParam("siteId") Integer siteId, @RequestParam("year") Integer year, @RequestParam("month") Integer month, @RequestParam(value = "isPercent", defaultValue = "false") Boolean isPercent) {
        return ResponseEntity.ok(monitorService.monthOnline(siteId, year, month, isPercent));
    }
}
