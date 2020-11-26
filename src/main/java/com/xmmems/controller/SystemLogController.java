package com.xmmems.controller;

import com.xmmems.dto.PageResult;
import com.xmmems.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @描述 系统日志
 * @创建人 ithxw
 * @创建时间 2020.03.03 17:43
 */
@RestController
@RequestMapping("/log")
public class SystemLogController {
    @Autowired
    private SystemLogService systemLogService;

    @GetMapping("/paginate")
    //@SystemControllerLog(descrption = "分页查询操作日志列表", actionType = "4")  这里如果设置就不能成为白名单路径
    public ResponseEntity<PageResult<Map<String, Object>>> baseAreaPageQuery(
            @RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "type" ,required = false) String type,
            @RequestParam(value = "userId",required = false) String userId,
            @RequestParam(value = "description" ,required = false) String description,
            @RequestParam(value = "start" ,required = false) String start,
            @RequestParam(value = "end",required = false) String end
    ) {
        PageResult<Map<String, Object>> pageResult = systemLogService.paginate(limit, page, type, userId, description, start, end);
        return ResponseEntity.ok(pageResult);
    }
}
