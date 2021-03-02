package com.xmmems.material.controller;

import com.xmmems.dto.PageResult;
import com.xmmems.material.domain.Cost;
import com.xmmems.material.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public ResponseEntity<Void> add(
            @RequestParam("title") String title,
            @RequestParam("price") Double price, @RequestParam(value = "pid", defaultValue = "0") Integer pid) {
        costService.add(title, price, pid);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/cost/findPage")
    public ResponseEntity<PageResult<Cost>> findPage(
            @RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "title", required = false) String title) {
        PageResult<Cost> pageResult = costService.findPage(limit, page, title);

        return ResponseEntity.ok(pageResult);
    }

    @GetMapping("/cost/findCost")
    public ResponseEntity<Map<String, Object>> findCost(@RequestParam("id") Integer id,
                                                        @RequestParam("title") String title,
            @RequestParam("price") Double price) {
        return ResponseEntity.ok(costService.findCost(id, title, price));
    }

    @PostMapping("/cost/delete")
    public ResponseEntity<Integer> delete(@RequestParam(value = "id") Integer id) {
        int delete = costService.delete(id);
        return ResponseEntity.ok(delete);
    }

    @PostMapping("/cost/update")
    public ResponseEntity<Integer> update(
            @RequestParam(value = "id") Integer id,
            @RequestParam("title") String title,
            @RequestParam("price") Double price, @RequestParam(value = "pid") Integer pid) {
        int delete = costService.update(id, title, price, pid);
        return ResponseEntity.ok(delete);
    }
}
