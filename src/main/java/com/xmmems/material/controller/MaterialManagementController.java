package com.xmmems.material.controller;

import com.xmmems.dto.PageResult;
import com.xmmems.material.domain.MaterialManagement;
import com.xmmems.material.service.MaterialManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2021.02.23 09:56
 */
@RestController
@RequestMapping("/")
public class MaterialManagementController {
    @Autowired
    private MaterialManagementService materialManagementService;

    @GetMapping("/material/findPage")
    public ResponseEntity<PageResult<MaterialManagement>> findPage(
            @RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "siteId", required = false) Integer siteId,
            @RequestParam(value = "warnType", required = false) String warnType,
            @RequestParam(value = "type", required = false) String type) {
        PageResult<MaterialManagement> pageResult = materialManagementService.findPage(limit, page, name, siteId, type,warnType);

        return ResponseEntity.ok(pageResult);
    }

    //    @PostMapping("/material/addOrUpdate")
//    public ResponseEntity<Void> addOrUpdate(
//            @RequestParam(value = "name") String name,
//            @RequestParam(value = "count") Integer count,
//            @RequestParam(value = "siteId") Integer siteId,
//            @RequestParam(value = "siteName") String siteName,
//            @RequestParam(value = "id", required = false) Integer id,
//            @RequestParam(value = "unit", required = false) String unit,
//            @RequestParam(value = "warnCount", required = false) Integer warnCount,
//            @RequestParam(value = "remarks", required = false) String remarks) {
//
//        materialManagementService.addOrUpdate(name, unit, count, warnCount, siteId, siteName, remarks, id);
//        return ResponseEntity.ok().build();
//    }
    @PostMapping("/material/addOrUpdate")
    @ResponseBody
    public ResponseEntity<Void> addOrUpdate(@RequestBody List<MaterialManagement> list) {

        materialManagementService.addOrUpdate(list);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/material/delete")
    public ResponseEntity<Void> delete(@RequestParam(value = "ids") List<Integer> ids) {
        materialManagementService.delete(ids);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/material/add")
    @ResponseBody
    public ResponseEntity<Void> addOrUpdate(MaterialManagement materialManagement) {
        materialManagementService.add(materialManagement);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/material/update")
    @ResponseBody
    public ResponseEntity<Void> update(MaterialManagement materialManagement) {
        materialManagementService.update(materialManagement);
        return ResponseEntity.ok().build();
    }



}
