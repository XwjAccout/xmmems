package com.xmmems.controller;

import com.xmmems.domain.base.BaseRiver;
import com.xmmems.domain.base.BaseSection;
import com.xmmems.domain.role.Permission;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.BaseRiverServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/baseRiver")
public class BaseRiverController {
    @Autowired
    private BaseRiverServer baseRiverServer;

    @GetMapping("/paginateBaseRiver")
    @SystemControllerLog(descrption = "分页查询流域列表", actionType = "4")
    public ResponseEntity<PageResult<BaseRiver>> baseRiverPageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                               @RequestParam(value = "page", defaultValue = "1") Integer page){
        PageResult<BaseRiver> pageResult  = baseRiverServer.baseRiverPageQuery(limit, page);
        return ResponseEntity.ok(pageResult);
    }

    @GetMapping("/paginateBaseSection")
    @SystemControllerLog(descrption = "分页查询河流列表", actionType = "4")
    public ResponseEntity<PageResult<BaseSection>> baseSectionPageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                    @RequestParam(value = "page", defaultValue = "1") Integer page){
        PageResult<BaseSection> pageResult  = baseRiverServer.baseSectionPageQuery(limit, page);
        return ResponseEntity.ok(pageResult);
    }

}
