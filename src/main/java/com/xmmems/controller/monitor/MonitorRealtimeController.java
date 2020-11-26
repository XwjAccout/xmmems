package com.xmmems.controller.monitor;

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
@RequestMapping("/monitor/realtime")
public class MonitorRealtimeController {

    @Autowired
    private MonitorService monitorService;

    /**
     * 实时监测数据接口
     */
    @GetMapping("/getRealTimeData")
    @SystemControllerLog(descrption = "实时监测数据", actionType = "4")
    public ResponseEntity<List<Map<String, Object>>> getRealTimeData(){
        List<Map<String, Object>> list = monitorService.getRealTimeData();
        return ResponseEntity.ok(list);
    }

    /**
     * 根据站点id查找实时数据
     */
    @GetMapping("/getRealTimeDataBySiteId")
    @SystemControllerLog(descrption = "根据站点id查找实时数据", actionType = "4")
    public ResponseEntity< Map<String, Object>> getRealTimeDataBySiteId(@RequestParam(value = "siteId") String siteId){
        Map<String, Object> map = monitorService.getRealTimeDataBySiteId(siteId);
        return ResponseEntity.ok(map);
    }
}
