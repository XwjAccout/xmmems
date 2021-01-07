package com.xmmems.forecast.controller;

import com.xmmems.forecast.service.ForecastService;
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
 * @创建时间 2020.08.26 18:27
 */
@RestController
@RequestMapping("/forecast")
public class ForecastController {

    @Autowired
    private ForecastService forecastService;

    @GetMapping("/arima")
    public ResponseEntity<List<Map<String, String>>> preValue(@RequestParam("siteId") Integer siteId,@RequestParam("itemId") Integer itemId,
                                                           @RequestParam("start") String start,@RequestParam("end") String end,
                                                           @RequestParam(value = "type",defaultValue = "1") Integer type){
        List<Map<String, String>> list = forecastService.preValue(siteId,itemId,start,end,type);
        return ResponseEntity.ok(list);
    }


}
