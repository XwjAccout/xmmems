package com.xmmems.controller.quality;

import com.xmmems.domain.env.EnvWarningRule;
import com.xmmems.domain.QualityControlSet;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.quality.QualityControlSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qualityControlSet")
public class QualityControlSetController {
    @Autowired
    QualityControlSetService qualityControlSetService;
    /**
     * 分页查询质量设置
     * @param limit
     * @param page
    //     * @param
     * @return
     */
    @GetMapping("/paginate")
    @SystemControllerLog(descrption = "分页查询质量设置", actionType = "4")
    public ResponseEntity<PageResult<QualityControlSet>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                       @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                       @RequestParam(value = "siteId", required = false) Integer siteId,
                                                                       @RequestParam(value = "type", required = false) Integer type){
        PageResult<QualityControlSet> pageResult = qualityControlSetService.pageQuery(limit, page,type,siteId);
        return ResponseEntity.ok(pageResult);
    }
    /**
     * 添加质量设置
     * @param qualityControl
     * @return
     */
    @PostMapping("/save")
    @SystemControllerLog(descrption = "添加质量设置", actionType = "1")
    public ResponseEntity<Void> save(@RequestBody QualityControlSet qualityControl){
        qualityControlSetService.save(qualityControl);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
