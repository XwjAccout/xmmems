package com.xmmems.forecast.controller;

import com.xmmems.common.exception.XMException;
import com.xmmems.forecast.service.ForecastService;
import com.xmmems.mapper.BaseItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.ParseException;
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
    @Autowired
    private BaseItemMapper baseItemMapper;

    @GetMapping("/arima")
    public ResponseEntity<List<Map<String, String>>> preValue(
            @RequestParam("siteId") Integer siteId,
            @RequestParam("itemId") Integer itemId,
            @RequestParam("start") String start,
            @RequestParam("end") String end, @RequestParam(value = "type", defaultValue = "1") Integer type) {
        Integer scale = baseItemMapper.selectScale(itemId);
        if (scale == null) {
            scale = 5;
        }

        List<Map<String, String>> list = null;
        try {
            list = forecastService.preValue(siteId, itemId, start, end, type, scale);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            throw new XMException(200, "该时间段数据太少或没有数据，无法预测");
        }
        for (Map<String, String> map : list) {
            String value = map.get("value");
            if (value != null) {
                map.put("value", setScale(value, scale));
            }
        }
        return ResponseEntity.ok(list);
    }

    private static String setScale(String value, int scale) {
        return new BigDecimal(value).setScale(scale, BigDecimal.ROUND_HALF_EVEN).toPlainString();
    }


}
