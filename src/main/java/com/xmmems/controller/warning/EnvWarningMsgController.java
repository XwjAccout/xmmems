package com.xmmems.controller.warning;

import com.xmmems.domain.EnvWarningMsg;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.warning.WarningMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/warningMsg")
public class EnvWarningMsgController {

    @Autowired
    WarningMsgService warningMsgService;

    /**
     * 分页查询短信记录
     * @param limit
     * @param page
     * @param phoneNum
     * @return
     */
    @GetMapping("/paginate")
    @SystemControllerLog(descrption = "分页查询短信记录", actionType = "4")
    public ResponseEntity<PageResult<EnvWarningMsg>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                   @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                   @RequestParam(value = "phoneNum", required = false) String phoneNum){
        PageResult<EnvWarningMsg> pageResult = warningMsgService.pageQuery(limit, page, phoneNum);
        return ResponseEntity.ok(pageResult);
    }

}
