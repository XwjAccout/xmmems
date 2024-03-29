package com.xmmems.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.xmmems.common.auth.domain.UserHolder;
import com.xmmems.common.utils.JsonUtils;
import com.xmmems.common.utils.XmRedis;
import com.xmmems.common.utils.XmRedisConstans;
import com.xmmems.common.utils.XmRedisEnum;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public ResponseEntity<Object> waterquality(@RequestParam(value = "siteType", required = false) String siteType) {
        List<BaseSiteDTO> sites = monitorService.getSites();

        List<Map<String, Object>> result = new ArrayList<>();
        List<Map<String, Object>> realTimeData = monitorService.getRealTimeData(siteType);

        for (Map<String, Object> temp : realTimeData) {
            String level = temp.get("level") + "";
            if (!level.contains("-")) {
                Map<String, Object> map = new HashMap<>(16);
                map.put("siteName", temp.get("siteName"));
                map.put("level", level);

                int siteId = Integer.parseInt(temp.get("siteId") + "");
                map.put("siteId", siteId);
                for (BaseSiteDTO site : sites) {
                    if (site.getId() == siteId) {
                        map.put("latitude", site.getLatitude());
                        map.put("longitude", site.getLongitude());
                        sites.remove(site);
                        break;
                    }
                }
                result.add(map);
            }
        }

        //水质比重
        List<Object> waterquality = new ArrayList<>();
        for (Map<String, Object> map : result) {
            waterquality.add(map.get("level"));
        }

        Map<String, Object> comMap = new HashMap<>(4);
        comMap.put("waterquality", waterquality);

        comMap.put("ditu", result);
        return ResponseEntity.ok(comMap);

    }


    //获取监测项目
    @GetMapping("/allItems")
    public ResponseEntity<Object> allItems() {
        String key = XmRedisConstans.common_allItems_ + UserHolder.loginId();
        Object data = XmRedis.get(key);
        if (data != null) {
            return ResponseEntity.ok(data);
        }
        synchronized (key) {
            data = XmRedis.get(key);
            if (data != null) {
                return ResponseEntity.ok(data);
            }
            //获取当前用户所拥有的的站点的对应的监测项目信息，去除重复的项目
            List<Map<String, String>> body = baseSiteitemMapper.selectByAccountId(UserHolder.loginId());
            XmRedis.put(key, body);
            return ResponseEntity.ok(body);
        }
    }

    //获取超标统计数据
    @GetMapping("/exceed")
    public ResponseEntity<Object> exceed(@RequestParam(value = "siteType", required = false) String siteType) {
        String key = XmRedisConstans.common_exceed_ + UserHolder.loginId();
        Object data = XmRedis.get(key);
        if (data != null) {
            return ResponseEntity.ok(data);
        }

        synchronized (key) {
            data = XmRedis.get(key);
            if (data != null) {
                return ResponseEntity.ok(data);
            }
            List<Map<String, Object>> baseSite = baseService.findBaseSiteByAccountId(siteType);
            List<Integer> siteIds = baseSite.stream().map(map -> Integer.valueOf(map.get("id") + "")).collect(Collectors.toList());
            List<ExceedStandard> currentTime = exceedStandardService.findCurrentTime(siteIds);
            List<Map<String, String>> mapList = JsonUtils.nativeRead(JsonUtils.toString(currentTime), new TypeReference<List<Map<String, String>>>() {});
            mapList.forEach(mm -> {
                mm.remove("id");
                mm.remove("mnId");
                mm.remove("itemCode");
                mm.remove("siteId");
                mm.remove("itemId");
                mm.put("itemValue", mm.get("itemValue") + " " + mm.get("itemUnit"));
                mm.remove("itemUnit");
                mm.put("date", mm.get("date").substring(0, 13));
            });
            XmRedis.put(key, mapList, 30L, XmRedisEnum.MINUTE);
            return ResponseEntity.ok(mapList);
        }
    }
}
