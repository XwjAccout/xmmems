package com.xmmems.controller;

import com.xmmems.domain.Repository;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/repository")
public class RepositoryController {
    @Autowired
    RepositoryService repositoryService;

    /**
     * 分页查询质量设置
     *
     * @param limit
     * @param page  //     * @param
     * @return
     */
    @GetMapping("/paginate")
    @SystemControllerLog(descrption = "分页查询知识库", actionType = "4")
    public ResponseEntity<PageResult<Repository>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                @RequestParam(value = "type", defaultValue = "1") Integer type,
                                                                @RequestParam(value = "essayTitle", required = false) String essayTitle) {
        PageResult<Repository> pageResult = repositoryService.pageQuery(limit, page, type, essayTitle);
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 添加质量设置
     */
    @PostMapping("/save")
    @SystemControllerLog(descrption = "添加知识库", actionType = "1")
    public ResponseEntity<Void> save(@RequestBody Repository repository,@RequestParam(value = "file",required = false) MultipartFile file) {
        repositoryService.save(repository,file);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/update")
    @SystemControllerLog(descrption = "修改知识库", actionType = "2")
    public ResponseEntity<Void> update(@RequestBody Repository repository,@RequestParam(value = "file",required = false) MultipartFile file) {
        repositoryService.update(repository,file);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PostMapping("/delete")
    @SystemControllerLog(descrption = "删除知识库", actionType = "3")
    public ResponseEntity<Void> delete(Integer id) {
        repositoryService.delete(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
