package com.xmmems.controller;

import com.xmmems.service.DataAnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2020.07.02 17:50
 */
@RestController
@RequestMapping("/analyze")
public class DataAnalyzeController {
    @Autowired
    private DataAnalyzeService dataAnalyzeService;


    @GetMapping("/getMonthAnalyze")
    public ResponseEntity<List<Map<String, String>>> getMonthAnalyze(@RequestParam(value = "siteId") Integer siteId,
                                                                     @RequestParam(value = "startTime") String startTime,
                                                                     @RequestParam(value = "endTime") String endTime,
      @RequestParam(value = "limit", defaultValue = "true") Boolean limit) {
        List<Map<String, String>> list = dataAnalyzeService.monthDataAnalyze(siteId, startTime, endTime,limit);
        return ResponseEntity.ok(list);
    }
}
