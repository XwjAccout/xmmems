package com.xmmems.controller.quality;

import com.xmmems.domain.InspectData;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.quality.TestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/quality/testdata/zeroDrift")
public class TestDataController {
    @Autowired
    private TestDataService testDataService;


    /**
     * 获取树形列表
     *
     * @return
     */
   /* @GetMapping("/getTreeData")
    @SystemControllerLog(descrption = "查询树形站点列表", actionType = "4")
    public ResponseEntity<List<TreeData>> getTreeData() {
        List<TreeData> list = testDataService.getTreeData();
        return ResponseEntity.ok(list);
    }*/

    /**
     * 查询零点核查，零点漂移数据1
     *
     * @return
     */
    @GetMapping("/zeroData")
    @SystemControllerLog(descrption = "查询零点核查，零点漂移数据", actionType = "4")
    public ResponseEntity<List<Map<String, Object>>> zeroData(@RequestParam("start") String start,
                                                              @RequestParam("end") String end,
                                                              @RequestParam("siteId") Integer siteId) {
        List<Map<String, Object>> list = testDataService.zeroData(start, end, siteId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/spanData")
    @SystemControllerLog(descrption = "查询跨度核查，跨度漂移数据", actionType = "4")
    public ResponseEntity<List<Map<String, Object>>> spanData(@RequestParam("start") String start,
                                                              @RequestParam("end") String end,
                                                              @RequestParam("siteId") Integer siteId) {
        List<Map<String, Object>> list = testDataService.spanData(start, end, siteId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/recoveryData")
    @SystemControllerLog(descrption = "查询加标回收率数据", actionType = "4")
    public ResponseEntity<List<Map<String, Object>>> recoveryData(@RequestParam("start") String start,
                                                                  @RequestParam("end") String end,
                                                                  @RequestParam("siteId") Integer siteId) {
        List<Map<String, Object>> list = testDataService.recoveryData(start, end, siteId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/inspectData")
    @SystemControllerLog(descrption = "查询核查数据", actionType = "4")
    public ResponseEntity<List<InspectData>> inspectData(@RequestParam("start") String start,
                                                         @RequestParam("end") String end,
                                                         @RequestParam("siteId") Integer siteId) {
        List<InspectData> list = testDataService.inspectData(start, end, siteId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/standardVerification")
    @SystemControllerLog(descrption = "查询标样核查数据", actionType = "4")
    public ResponseEntity<Map<String, Object>> standardVerification(@RequestParam("start") String start,
                                                                    @RequestParam("end") String end,
                                                                    @RequestParam("siteId") Integer siteId,
                                                                    @RequestParam("itemId") Integer itemId) {
        Map<String, Object> list = testDataService.standardVerification(start, end, siteId, itemId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/blankTest")
    @SystemControllerLog(descrption = "查询空白测试数据", actionType = "4")
    public ResponseEntity<Map<String, Object>> blankTest(@RequestParam("start") String start,
                                                         @RequestParam("end") String end,
                                                         @RequestParam("siteId") Integer siteId,
                                                         @RequestParam("itemId") Integer itemId) {
        Map<String, Object> list = testDataService.blankTest(start, end, siteId, itemId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/site")
    public ResponseEntity<List<Map<String, Object>>> site(){
        List<Map<String,Object>> maps = testDataService.site();
        return ResponseEntity.ok(maps);
    }
}
