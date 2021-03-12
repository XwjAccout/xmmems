package com.xmmems.material.controller;

import com.xmmems.dto.PageResult;
import com.xmmems.material.domain.Cost;
import com.xmmems.material.domain.CostSite;
import com.xmmems.material.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2021.03.01 16:16
 */
@RestController
@RequestMapping
public class CostController {
    @Autowired
    private CostService costService;

    @PostMapping("/cost/add")
    @ResponseBody
    public ResponseEntity<Void> add(Cost cost) {
        costService.add(cost);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/cost/findPage")
    public ResponseEntity<PageResult<Cost>> findPage(
            @RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
            @RequestParam(value = "page", defaultValue = "1") Integer page
//            @RequestParam(value = "type", defaultValue = "1") Integer type,
//           @RequestParam(value = "name", defaultValue = "1") String name
           ) {
        PageResult<Cost> pageResult = costService.findPage(limit, page);
        return ResponseEntity.ok(pageResult);
    }
    @GetMapping("/cost/sitefindPage")
    public ResponseEntity<PageResult<CostSite>> sitefindPage(
            @RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "siteId", defaultValue = "1") Integer siteId) {
        PageResult<CostSite> pageResult = costService.sitefindPage(limit, page,siteId);
        return ResponseEntity.ok(pageResult);
    }
//    @GetMapping("/cost/findCost")
//    public ResponseEntity<Map<String, Object>> findCost(@RequestParam("id") Integer id,
//                                                        @RequestParam("title") String title,
//                                                        @RequestParam("siteId") Integer siteId,
//                                                        @RequestParam("siteName") String siteName,
//            @RequestParam("price") Double price) {
//        return ResponseEntity.ok(costService.findCost(id, title, price,siteId,siteName));
//    }

    @PostMapping("/cost/delete")
    public ResponseEntity<Integer> delete(@RequestParam(value = "id") Integer id) {
        int delete = costService.delete(id);
        return ResponseEntity.ok(delete);
    }

    @PostMapping("/cost/update")
    @ResponseBody
    public ResponseEntity<Integer> update(Cost cost) {
        int delete = costService.update(cost);
        return ResponseEntity.ok(delete);
    }
}
