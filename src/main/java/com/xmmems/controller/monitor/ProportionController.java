package com.xmmems.controller.monitor;

import com.xmmems.service.MonitorService;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/monitor/report")
@Slf4j
public class ProportionController {
    @Autowired
    private MonitorService monitorService;

    @GetMapping("/Proportion")
    public List Proportion(@RequestParam(value = "siteType", required = false) String siteType) {
        List<String> result = new ArrayList<>();
       //测试拉取
        List<Map<String, Object>> realTimeData = monitorService.getRealTimeData(siteType);
        realTimeData.forEach(temp->{
            String level = temp.get("level")+"";
            if (!level.contains("-")) {
                result.add(level);
            }
        });
        return result;
    }

    @GetMapping("/waterAnalysis")
    public ResponseEntity<List<Map<String,String>>> waterAnalysis(){
        return ResponseEntity.ok(monitorService.waterAnalysis());
    }
}
