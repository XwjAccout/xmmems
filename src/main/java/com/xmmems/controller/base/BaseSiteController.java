package com.xmmems.controller.base;

import com.xmmems.domain.base.BaseSite;
import com.xmmems.domain.base.BaseSiteitem;
import com.xmmems.dto.BaseSiteitemDTO;
import com.xmmems.dto.PageResult;
//import com.xmmems.mapper.xmmems.BaseSiteMapper;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BaseSiteController {

    @Autowired
    private BaseService baseService;
    //查询站点列表
    @GetMapping("/site/paginate")
    @SystemControllerLog(descrption = "分页查询站点列表", actionType = "4")
    public ResponseEntity<PageResult<BaseSite>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                              @RequestParam(value = "siteName", required = false) String siteName) {
        PageResult<BaseSite> pageResult = baseService.sitePageQuery(limit, page, siteName);
        return ResponseEntity.ok(pageResult);
    }

    //添加站点
    @PostMapping("/site/save")
    @SystemControllerLog(descrption = "添加站点信息", actionType = "1")
    public ResponseEntity<Void> siteSave(@RequestBody BaseSite baseSite) {
        baseService.siteSave(baseSite);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //根据id查询站点
    @GetMapping("/site/findById")
    @SystemControllerLog(descrption = "根据id查询站点", actionType = "4")
    public ResponseEntity<BaseSite> siteFindById(@RequestParam(value = "id") Integer id) {
        BaseSite baseSite = baseService.siteFindById(id);
        return ResponseEntity.ok(baseSite);
    }

    //根据id更新数据
    @PostMapping("/site/update")
    @SystemControllerLog(descrption = "根据id修改站点", actionType = "2")
    public ResponseEntity<Void> siteUpdate(@RequestBody BaseSite baseSite) {
        baseService.siteUpdate(baseSite);
        return ResponseEntity.ok().build();
    }

    //根据id删除数据
    @PostMapping("/site/delete")
    @SystemControllerLog(descrption = "根据id删除站点", actionType = "3")
    public ResponseEntity<Void> siteDelete(@RequestParam(value = "id") Integer id) {
        baseService.siteDelete(id);
        return ResponseEntity.ok().build();
    }

    //根据站点id查询监测项目
    @GetMapping("/site/item/getItems")
    @SystemControllerLog(descrption = "根据站点id查询监测项目", actionType = "4")
    public ResponseEntity<List<BaseSiteitemDTO>> siteItemGetItemsBySiteId(@RequestParam(value = "siteId") Integer siteId) {
        List<BaseSiteitemDTO> list = baseService.siteItemGetItemsBySiteId(siteId);
        return ResponseEntity.ok(list);
    }

    /**
     * 获取所有有效的站点信息（id，名称）
     */
    @GetMapping("/site/findAll")
    @SystemControllerLog(descrption = "获取所有有效的站点信息（id，名称）", actionType = "4")
    public ResponseEntity<List<Map<String, String>>> findAll() {
        return ResponseEntity.ok(baseService.findAll());
    }

    //根据站点id查询监测项目
    @GetMapping("/site/item/updateBysort")
    public ResponseEntity<Void> updateBybaseSiteitem(@RequestParam(value = "upAndDown") Integer upAndDown, @RequestParam(value = "siteId") Integer siteId, @RequestParam(value = "id") Integer id) {
        baseService.updateBybaseSiteitem(upAndDown, siteId, id);
        return ResponseEntity.ok().build();
    }

    //添加监测项目
    @PostMapping("/site/item/addItem")
    @SystemControllerLog(descrption = "添加站点监测项目", actionType = "1")
    public ResponseEntity<Void> addItem(@RequestParam(value = "siteId") Integer siteId, @RequestParam(value = "siteName") String siteName, @RequestParam(value = "itemId") Integer itemId, @RequestParam(value = "itemName") String itemName) {
        baseService.addItem(siteId, siteName, itemId, itemName);
        return ResponseEntity.ok().build();
    }

    //添加监测项目
    @PostMapping("/site/item/delItem")
    @SystemControllerLog(descrption = "删除站点监测项目", actionType = "3")
    public ResponseEntity<Void> delItem(@RequestParam(value = "siteId") Integer siteId, @RequestParam(value = "itemId") Integer itemId) {
        baseService.delItem(siteId, itemId);
        return ResponseEntity.ok().build();
    }

    //zeroCheck 默认true   传入false时为只查询查询含有零点跨度核查数据的站点
    @GetMapping("/site/byAccountId")
    @SystemControllerLog(descrption = "根据账户id查找站点名称集合", actionType = "4")
    public ResponseEntity<List<Map<String, Object>>> byAccountId(@RequestParam(value = "zeroCheck",defaultValue = "true") Boolean zeroCheck) {
        if (zeroCheck) {
            return ResponseEntity.ok(baseService.findBaseSiteByAccountId());
        } else {
            return ResponseEntity.ok(baseService.getSiteIdAndNameExcludeZeroCheck());
        }
    }
    //修改检出限
    @PostMapping("/site/updateDetectionLimit")
    @SystemControllerLog(descrption = "修改检出限", actionType = "2")
    public ResponseEntity<Void> updateDetectionLimit(@RequestParam(value = "siteId") Integer siteId, @RequestParam(value = "itemId") Integer itemId, @RequestParam(value = "limit")String limit){
        int i =  baseService.updateDetectionLimit(siteId, itemId,limit);
        return ResponseEntity.ok().build();
    }

    //修改排序
    @PostMapping("/site/updateSort")
    @SystemControllerLog(descrption = "修改排序", actionType = "2")
    public ResponseEntity<Void> updateSort(@RequestParam(value = "siteId") Integer siteId, @RequestParam(value = "itemId") Integer itemId, @RequestParam(value = "sort")Double sort){
        baseService.updateSort(siteId, itemId,sort);
        return ResponseEntity.ok().build();
    }

    //修改次数
    @PostMapping("/site/updateNumber")
    @SystemControllerLog(descrption = "修改次数", actionType = "2")
    public ResponseEntity<Void> updateNumber(@RequestParam(value = "siteId") Integer siteId, @RequestParam(value = "itemId") Integer itemId, @RequestParam(value = "number")Integer number){
        baseService.updateNumber(siteId, itemId,number);
        return ResponseEntity.ok().build();
    }

    //修改次数
    @GetMapping("/site/siteByitemId")
    @SystemControllerLog(descrption = "查询有累计流量的站点", actionType = "2")
    public ResponseEntity< List<BaseSiteitem>> selectBysite(){
        List<BaseSiteitem> mapList =  baseService.selectBysite();
        return ResponseEntity.ok(mapList);
    }
}
