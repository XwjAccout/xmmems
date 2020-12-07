package com.xmmems.controller;

import com.xmmems.domain.NetWork;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.NetWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @描述 联网统计
 * @创建人 ithxw
 * @创建时间 2020.03.06 14:54
 */
@RestController
@RequestMapping("/statis")
public class NetWorkController {

    @Autowired
    private NetWorkService netWorkService;

    /**
     * 联网情况统计
     */
    @GetMapping("/findNetWorks")
    @SystemControllerLog(descrption = "联网情况统计", actionType = "4")
    public ResponseEntity<List<NetWork>> findNetWorks(
            @RequestParam(value = "siteName", required = false) String siteName, @RequestParam(value = "siteId", required = false) String siteId,
            @RequestParam(value = "start") String start, @RequestParam(value = "end") String end) {
        List<NetWork> list = netWorkService.findNetWorks(siteName, start, end, siteId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/findNetWorksNumber")
    @SystemControllerLog(descrption = "联网情况统计", actionType = "4")
    public ResponseEntity<Map<String, Integer>> findNetWorksNumber() {
        Map<String, Integer> list = netWorkService.findNetWorksNumber();
        return ResponseEntity.ok(list);
    }

}
