package com.xmmems.controller.monitor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.xmmems.common.utils.JsonUtils;
import com.xmmems.controller.monitor.httpcfg.HttpUtils;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.ApproveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/monitor/approve")
@Slf4j
public class ApproveController {

    @Autowired
    private ApproveService approveService;
    @Autowired
    private HttpUtils httpUtils;

    /**
     * 审核数据查询
     */
    @GetMapping("/siteMonitoring")
    @SystemControllerLog(descrption = "分页查询审批数据", actionType = "4")
    public ResponseEntity<PageResult<Map<String, Object>>> siteMonitoring(
            @RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "siteId") Integer siteId,
            @RequestParam(value = "startTime") String startTime, @RequestParam(value = "endTime") String endTime) {
        PageResult<Map<String, Object>> historyData = approveService.getHistoryDataHandled(limit, page, siteId, startTime, endTime);
        return ResponseEntity.ok(historyData);
    }

    /**
     * 保存修正后的数据
     */
    @PostMapping("/saveAdjust")
    @SystemControllerLog(descrption = "保存修正后补录数据", actionType = "1")
    public ResponseEntity<String> saveAdjust(
            @RequestParam("adjust") String adjust,
            @RequestParam("siteId") Integer siteId,
            @RequestParam(value = "recordId", required = false) Integer recordId,
            @RequestParam(value = "adjustKey", required = false) String adjustKey,
            @RequestParam("troubleCode") String troubleCode,
            @RequestParam("troubleName") String troubleName,
            @RequestParam("multipleAdjust") String multipleAdjust,
            @RequestParam(value = "adjustValue", required = false) String adjustValue,
            @RequestParam(value = "originValue", required = false) String originValue,
            @RequestParam(value = "startTime", required = false) String startTime,
            @RequestParam(value = "endTime", required = false) String endTime,
            @RequestParam(value = "multipleParam", required = false) String multipleParam,
            @RequestParam(value = "itemNameList", required = false) String itemNameListStr,
            @RequestParam(value = "itemNameList", required = false) List<String> itemNameList,
            @RequestParam(value = "dbNameAndHourDataId", defaultValue = "local") String dbNameAndHourDataId) {
        if (dbNameAndHourDataId.contains("$")) {
            //不包含需要同步其他数据库操作
            HashMap<String, String> map = new HashMap<>();
            map.put("adjust", adjust);
            map.put("siteId", siteId + "");
            map.put("recordId", recordId + "");
            map.put("adjustKey", adjustKey);
            map.put("troubleCode", troubleCode);
            map.put("troubleName", troubleName);
            map.put("multipleAdjust", multipleAdjust);
            map.put("adjustValue", adjustValue);
            map.put("originValue", originValue);
            map.put("startTime", startTime);
            map.put("endTime", endTime);
            map.put("multipleParam", multipleParam);
            map.put("itemNameList", itemNameListStr);
            map.put("dbNameAndHourDataId", dbNameAndHourDataId);

            try {
                Boolean aBoolean = httpUtils.postReturnBoolean("/saveAdjust", map);
                if (aBoolean) {
                    approveService.saveAdjust(adjust, siteId, recordId, adjustKey, adjustValue, originValue, troubleCode, troubleName, multipleAdjust, startTime, endTime, multipleParam, itemNameList);
                    return ResponseEntity.ok("数据库同步审批成功");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.ok("数据库同步审批失败，请联系管理员查看具体原因！" + e.getMessage());
            }
            return ResponseEntity.ok("数据库同步审批失败，请联系管理员查看具体原因！");
        }

        approveService.saveAdjust(adjust, siteId, recordId, adjustKey, adjustValue, originValue, troubleCode, troubleName, multipleAdjust, startTime, endTime, multipleParam, itemNameList);
        return ResponseEntity.ok("本地数据库审批成功");
    }

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
    public ResponseEntity<String> resetAdjust(
            @RequestParam("siteId") Integer siteId,
            @RequestParam("siteName") String siteName,
            @RequestParam(value = "adjustKey", required = false) String adjustKey,
            @RequestParam("startTime") String startTime,
            @RequestParam("endTime") String endTime,
            @RequestParam(value = "dbNameAndHourDataId", defaultValue = "local") String dbNameAndHourDataId) {
        if (dbNameAndHourDataId.contains("$")) {
            //不包含需要同步其他数据库操作
            HashMap<String, String> map = new HashMap<>();
            map.put("siteId", siteId + "");
            map.put("siteName", siteName);
            map.put("adjustKey", adjustKey);
            map.put("startTime", startTime);
            map.put("endTime", endTime);
            map.put("dbNameAndHourDataId", dbNameAndHourDataId);

            try {
                Boolean aBoolean = httpUtils.postReturnBoolean("/resetAdjust", map);
                if (aBoolean) {
                    approveService.resetAdjust(siteId, siteName, adjustKey, startTime, endTime);
                    return ResponseEntity.ok("数据同步还原成功");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.ok("数据同步还原失败，请联系管理员查看具体原因！" + e.getMessage());
            }
            return ResponseEntity.ok("数据同步还原失败，请联系管理员查看具体原因！");
        }
        approveService.resetAdjust(siteId, siteName, adjustKey, startTime, endTime);

        return ResponseEntity.ok("本地数据还原成功");
    }

    /**
     * 根据id查询数据，这里用来预设要补录的数据
     */
    @GetMapping("/findDate")
    @SystemControllerLog(descrption = "根据id-站点查找预设补录数据", actionType = "4")
    public ResponseEntity<Map<String, Object>> findDate(
            @RequestParam("id") Integer id,
            @RequestParam("siteId") Integer siteId, @RequestParam("siteName") String siteName) {
        Map<String, Object> envHourData = approveService.findDate(id, siteId, siteName);
        return ResponseEntity.ok(envHourData);
    }

    /**
     * 保存或修改补录数据
     */
    @PostMapping("/saveDate")
    @SystemControllerLog(descrption = "添加或修改补录数据", actionType = "1")
    public ResponseEntity<String> saveDate(
            @RequestParam("siteId") Integer siteId,
            @RequestParam("siteName") String siteName,
            @RequestParam("monitorTime") String monitorTime,
            @RequestParam("itemData") String itemData,
            @RequestParam("time") String[] time,
            @RequestParam(value = "dbNameAndHourDataId", defaultValue = "local") String dbNameAndHourDataId) {
        if (dbNameAndHourDataId.contains("$")) {
            //不包含需要同步其他数据库操作
            HashMap<String, String> map = new HashMap<>();
            map.put("siteId", siteId + "");
            map.put("siteName", siteName);
            map.put("monitorTime", monitorTime);
            map.put("itemData", itemData);
            map.put("time", Arrays.toString(time).replaceAll("[\\[\\] ]", ""));
            map.put("dbNameAndHourDataId", dbNameAndHourDataId);

            try {
                String json = httpUtils.postReturnBody("/saveDate", map);
                if (json != null) {
                    HashMap<String, String> mapBody = JsonUtils.nativeRead(json, new TypeReference<HashMap<String, String>>() {});
                    approveService.addDataSave(siteId, siteName, monitorTime, itemData, time, mapBody);
                    return ResponseEntity.ok("数据库同步补录成功");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.ok("数据库同步补录失败，请联系管理员查看具体原因！" + e.getMessage());
            }
            return ResponseEntity.ok("数据库同步补录失败，请联系管理员查看具体原因！");
        }
        approveService.addDataSave(siteId, siteName, monitorTime, itemData, time);

        return ResponseEntity.ok("本地数据库补录成功");
    }

    @PostMapping("/deleteByIds")
    @SystemControllerLog(descrption = "根据id删除补录数据", actionType = "3")
    public ResponseEntity<String> deleteByIds(
            @RequestParam("ids") Integer[] ids,
            @RequestParam(value = "dbNameAndHourDataId", defaultValue = "local") String dbNameAndHourDataId) {
        if (dbNameAndHourDataId.contains("$")) {
            //不包含需要同步其他数据库操作
            HashMap<String, String> map = new HashMap<>();
            map.put("ids", Arrays.toString(ids).replaceAll("[\\[\\] ]", ""));
            map.put("dbNameAndHourDataId", dbNameAndHourDataId);

            try {
                Boolean aBoolean = httpUtils.postReturnBoolean("/deleteByIds", map);
                if (aBoolean) {
                    approveService.deleteByIds(ids);
                    return ResponseEntity.ok("数据同步删除成功");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.ok("数据同步删除失败，请联系管理员查看具体原因！" + e.getMessage());
            }
            return ResponseEntity.ok("数据同步删除失败，请联系管理员查看具体原因！");
        }
        approveService.deleteByIds(ids);
        return ResponseEntity.ok("本地数据删除成功");
    }
}
