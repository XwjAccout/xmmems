package com.xmmems.material.controller;

import com.xmmems.dto.PageResult;
import com.xmmems.material.domain.Inventorydetails;
import com.xmmems.material.domain.MaterialManagement;
import com.xmmems.material.service.InventorydetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping
public class InventorydetailsContrller {
    @Autowired
    InventorydetailsService inventorydetailsService;

    //添加数量
    @PostMapping("/material/addume")
    @ResponseBody
    public ResponseEntity<Void> addnumber(Inventorydetails inventorydetails) {

        inventorydetailsService.addnumber(inventorydetails);
        return ResponseEntity.ok().build();
    }


    //消耗数量
    @PostMapping("/material/consume")
    public ResponseEntity<Void> consume(@RequestParam(value = "id") Integer id, @RequestParam("num") Integer num, @RequestParam("mId") Integer mId,
                                        @RequestParam("name") String name,
                                        @RequestParam("nextexpendTime") String nextexpendTime) {
        inventorydetailsService.consume(id, num, mId,name,nextexpendTime);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/inventorydetails/findPage")
    public ResponseEntity<PageResult<Inventorydetails>> findPage(
            @RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "mid", required = false) Integer mid) {
        PageResult<Inventorydetails> pageResult = inventorydetailsService.findPage(limit, page, mid);

        return ResponseEntity.ok(pageResult);
    }


    @PostMapping("/inventorydetails/delete")
    public ResponseEntity<Void> delete(@RequestParam(value = "id") Integer id) {
        inventorydetailsService.delete(id);
        return ResponseEntity.ok().build();
    }


}
