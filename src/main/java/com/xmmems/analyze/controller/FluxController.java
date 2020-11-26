package com.xmmems.analyze.controller;

import com.xmmems.analyze.service.FluxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2020.09.22 13:19
 */
@RestController
@RequestMapping("/")
public class FluxController {

    @Autowired
    private FluxService fluxService;

    //通量k线图数据或表格
    @GetMapping("/fluxKdiagram")
    public ResponseEntity<Object> fluxKdiagram(@RequestParam("siteId") Integer siteId,
                                               @RequestParam("itemId") Integer itemId,
                                               @RequestParam("start") String start,
                                               @RequestParam("end") String end,
                                               @RequestParam("type") Integer type) {
        return ResponseEntity.ok(fluxService.fluxKdiagram(siteId, itemId, start, end,type));
    }
}
