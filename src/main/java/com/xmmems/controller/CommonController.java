package com.xmmems.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.xmmems.common.auth.domain.UserHolder;
import com.xmmems.common.utils.DateFormat;
import com.xmmems.common.utils.FileLog;
import com.xmmems.common.utils.JsonUtils;
import com.xmmems.domain.ExceedStandard;
import com.xmmems.dto.BaseSiteDTO;
import com.xmmems.mapper.BaseSiteitemMapper;
import com.xmmems.service.BaseService;
import com.xmmems.service.ExceedStandardService;
import com.xmmems.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @描述 使用多线程进行效率的控制层接口
 * @创建人 ithxw
 * @创建时间 2020.11.17 15:45
 */
@RestController
@RequestMapping("/common")
public class CommonController {
    @Autowired
    private ExceedStandardService exceedStandardService;
    @Autowired
    private BaseService baseService;
    @Autowired
    private MonitorService monitorService;
    @Autowired
    private BaseSiteitemMapper baseSiteitemMapper;

    @GetMapping("/waterquality")
    public ResponseEntity<Object> waterquality() {
        List<BaseSiteDTO> sites = monitorService.getSites();

        List<Map<String, Object>> result = new ArrayList<>();
        List<Map<String, Object>> realTimeData = monitorService.getRealTimeData();
        FileLog.info("com.xmmems.controller.CommonController   48行"+JsonUtils.toString(realTimeData));
        for (Map<String, Object> realTimeDatum : realTimeData) {
            FileLog.info("com.xmmems.controller.CommonController   50行"+JsonUtils.toString(realTimeDatum));
        }
        realTimeData.forEach(temp -> {
            String level = temp.get("level") + "";
            if (!level.contains("-")) {
                Map<String, Object> map = new HashMap<>();
                map.put("siteName", temp.get("siteName"));
                map.put("level", level);
                FileLog.info("com.xmmems.controller.CommonController  map.put(\"level\", level);  55行"+level);
                int siteId = Integer.parseInt(temp.get("siteId")+"");
                map.put("siteId", siteId);
                for (BaseSiteDTO site : sites) {
                    if (site.getId()==siteId) {
                        map.put("latitude", site.getLatitude());
                        map.put("longitude", site.getLongitude());
                        sites.remove(site);
                        break;
                    }
                }
                result.add(map);
            }
        });

        //水质比重
        List<Object> waterquality = new ArrayList<>();
        for (Map<String, Object> map : result) {
            waterquality.add(map.get("level"));
        }

        Map<String, Object> comMap = new HashMap<>();
        comMap.put("waterquality", waterquality);

        comMap.put("ditu", result);
        return ResponseEntity.ok(comMap);

    }


    //获取监测项目
    @GetMapping("/allItems")
    public ResponseEntity<Object> allItems() {

        //获取当前用户所拥有的的站点的对应的监测项目信息，去除重复的项目
        return ResponseEntity.ok(baseSiteitemMapper.selectByAccountId(UserHolder.loginId()));
    }


    //获取超标统计数据
    @GetMapping("/exceed")
    public ResponseEntity<Object> exceed() {
        //根据账户id查找站点名称集合
        List<Map<String, Object>> baseSite = baseService.findBaseSiteByAccountId();
        String day = DateFormat.formatSome(System.currentTimeMillis());
        List<ExceedStandard> list = new ArrayList<>();
        baseSite.parallelStream().map(map -> map.get("id") + "").map(id -> exceedStandardService.findByDateAndSiteName(day + " 00:00:00", day + " 23:59:59", id, true)).forEach(list::addAll);
        List<Map<String, String>> mapList = JsonUtils.nativeRead(JsonUtils.toString(list), new TypeReference<List<Map<String, String>>>() {
        });
        mapList.parallelStream().forEach(mm -> {
            mm.remove("id");
            mm.remove("mnId");
            mm.remove("itemCode");
            mm.remove("siteId");
            mm.remove("itemId");
            mm.put("itemValue", mm.get("itemValue") + " " + mm.get("itemUnit"));
            mm.remove("itemUnit");
            mm.put("date", mm.get("date").substring(0, 13));
        });

        //获取当前用户所拥有的的站点的对应的监测项目信息，去除重复的项目
        return ResponseEntity.ok(mapList);
    }
}
