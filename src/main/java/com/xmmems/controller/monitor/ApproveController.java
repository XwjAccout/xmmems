package com.xmmems.controller.monitor;

import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.ApproveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/monitor/approve")
@Slf4j
public class ApproveController {

    @Autowired
    private ApproveService approveService;

    /**
     * 审核数据查询
     */
    ///monitor/approve/siteMonitoring
    @GetMapping("/siteMonitoring")
    @SystemControllerLog(descrption = "分页查询审批数据", actionType = "4")
    public ResponseEntity<PageResult<Map<String, Object>>> siteMonitoring(
            @RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "siteId") Integer siteId,
            @RequestParam(value = "startTime") String startTime,
            @RequestParam(value = "endTime") String endTime) {
        PageResult<Map<String, Object>> historyData = approveService.getHistoryDataHandled(limit, page, siteId, startTime, endTime);
        return ResponseEntity.ok(historyData);
    }

    // /monitor/approve/saveAdjust

    /**
     * 保存修正后的数据
     */
    @PostMapping("/saveAdjust")
    @SystemControllerLog(descrption = "保存修正后补录数据", actionType = "1")
    public ResponseEntity<PageResult<Map<String, Object>>> saveAdjust(
            @RequestParam("adjust") String adjust,
            @RequestParam("siteId") Integer siteId,
            @RequestParam(value = "recordId",required = false) Integer recordId,
            @RequestParam(value = "adjustKey",required = false) String adjustKey,
            @RequestParam("troubleCode") String troubleCode,
            @RequestParam("troubleName") String troubleName,
            @RequestParam("multipleAdjust") String multipleAdjust,
            @RequestParam(value = "adjustValue", required = false) String adjustValue,
            @RequestParam(value = "originValue", required = false) String originValue,
            @RequestParam(value = "startTime", required = false) String startTime,
            @RequestParam(value = "endTime", required = false) String endTime,
            @RequestParam(value = "multipleParam", required = false) String multipleParam
    ) {
        approveService.saveAdjust(adjust, siteId, recordId, adjustKey, adjustValue, originValue, troubleCode, troubleName, multipleAdjust, startTime, endTime, multipleParam);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8089/xmmems/monitor/approve/resetAdjust

    /**
     * 还原修正过的数据
     *
     * @param siteId
     * @param adjustKey
     * @param startTime
     * @param endTime
     * @author: ithxw
     * @Date: 2020/2/26
     * @return: org.springframework.http.ResponseEntity<com.xmmems.dto.PageResult < java.util.Map < java.lang.String, java.lang.Object>>>
     */
    @PostMapping("/resetAdjust")
    @SystemControllerLog(descrption = "还原修正过的补录数据", actionType = "2")
    public ResponseEntity<PageResult<Map<String, Object>>> resetAdjust(
            @RequestParam("siteId") Integer siteId,
            @RequestParam("siteName") String siteName,
            @RequestParam(value = "adjustKey",required = false) String adjustKey,
            @RequestParam("startTime") String startTime,
            @RequestParam("endTime") String endTime
    ) {
        approveService.resetAdjust(siteId, siteName, adjustKey, startTime, endTime);
        return ResponseEntity.ok().build();
    }

    /**
     * 根据id查询数据，这里用来预设要补录的数据
     */
    @GetMapping("/findDate")
    @SystemControllerLog(descrption = "根据id-站点查找预设补录数据", actionType = "4")
    public ResponseEntity<Map<String, Object>> findDate(
            @RequestParam("id") Integer id,
            @RequestParam("siteId") Integer siteId,
            @RequestParam("siteName") String siteName) {
        Map<String, Object> envHourData = approveService.findDate(id, siteId, siteName);
        return ResponseEntity.ok(envHourData);
    }

    /**
     * 保存或修改补录数据
     */
    @PostMapping("/saveDate")
    @SystemControllerLog(descrption = "添加或修改补录数据", actionType = "1")
    public ResponseEntity<Void> saveDate(
            @RequestParam("siteId") Integer siteId,
            @RequestParam("siteName") String siteName,
            @RequestParam("monitorTime") String monitorTime,
            @RequestParam("itemData") String itemData,
            @RequestParam("time") String[] time) {
        approveService.addDataSave(siteId, siteName, monitorTime, itemData, time);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/deleteByIds")
    @SystemControllerLog(descrption = "根据id删除补录数据", actionType = "3")
    public ResponseEntity<Void> deleteByIds(Integer[] ids) {
        approveService.deleteByIds(ids);
        return ResponseEntity.ok().build();
    }


}
