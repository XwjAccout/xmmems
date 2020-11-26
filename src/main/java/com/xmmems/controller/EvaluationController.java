package com.xmmems.controller;

import com.xmmems.domain.Evaluation;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("evaluation")
public class EvaluationController {
    @Autowired
    EvaluationService evaluationService;

    /**
     * 分页查询角色
     */
    @GetMapping("/paginate")
    @SystemControllerLog(descrption = "分页查询质量评价", actionType = "1")
    public ResponseEntity<PageResult<Evaluation>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                      @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                      @RequestParam(value = "siteId", defaultValue = "1") Integer siteId){
        PageResult<Evaluation> pageResult = evaluationService.pageQuery(limit, page,siteId);
        return ResponseEntity.ok(pageResult);
    }

}
