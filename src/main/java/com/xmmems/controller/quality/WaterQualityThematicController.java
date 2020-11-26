package com.xmmems.controller.quality;

import com.xmmems.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述 水质专题图
 * @创建人 ithxw
 * @创建时间 2020.10.22 13:12
 */
@RestController
@RequestMapping("/")
public class WaterQualityThematicController {
    @Autowired
    private MonitorService monitorService;

    @GetMapping("/analyze/tmowq")
    public Object tmowq(@RequestParam("siteId") Integer siteId,
                        @RequestParam(value = "day",required = false) String day,
                        @RequestParam(value = "month",required = false) String month) {
        Object o = monitorService.tmowq(siteId, day, month);
        return ResponseEntity.ok(o);
    }
}
