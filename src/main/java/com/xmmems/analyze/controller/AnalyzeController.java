package com.xmmems.analyze.controller;

import com.xmmems.analyze.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @描述 多元统计分析
 * @创建人 ithxw
 * @创建时间 2020.07.16 11:48
 */
@RestController
@RequestMapping("/analyze")
public class AnalyzeController {

    @Autowired
    private QualityAnalysisService qualityAnalysisService;

    @Autowired
    private LinearRegressionService linearRegressionService;

    @GetMapping("/linearRegression")
    public Object linearRegression(@RequestParam("siteId") Integer siteId,
                                   @RequestParam("itemId") Integer itemId,
                                   @RequestParam("start") String start,
                                   @RequestParam("end") String end) {
        return linearRegressionService.linearRegression(siteId, start, end, itemId);
    }

    @GetMapping("/levelPercent")
    public Object levelPercent(@RequestParam("siteId") Integer siteId, @RequestParam("year") Integer year, @RequestParam("itemIds") List<Integer> itemIds) {
        return ResponseEntity.ok(qualityAnalysisService.levelPercent(year, siteId, itemIds));
    }

    @GetMapping("/mainTroubleList")
    public Object mainTroubleList(@RequestParam("siteId") Integer siteId, @RequestParam("year") Integer year, @RequestParam("itemIds") List<Integer> itemIds) {
        return ResponseEntity.ok(qualityAnalysisService.mainTroubleList(year, siteId, itemIds));
    }

}
