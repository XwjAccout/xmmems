package com.xmmems.task.controller;

import com.xmmems.dto.PageResult;
import com.xmmems.task.domain.Assessment;
import com.xmmems.task.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2021.01.21 14:49
 */
@RestController
@RequestMapping("/")
public class AssessmentController {
    @Autowired
    private AssessmentService assessmentService;

    @PostMapping("assessment/uploadAssessment")
    public Integer uploadAssessment(Assessment assessment, @RequestParam(value = "file",required = false) MultipartFile file) {
        return assessmentService.uploadAssessment(assessment, file);
    }

    @PostMapping("assessment/delAssessment")
    public Integer delAssessment(Integer id) {
        return assessmentService.delAssessment(id);
    }

    @GetMapping("assessment/findAssessment")
    public PageResult<Assessment> findAssessment(@RequestParam("limit") Integer limit,
                                                 @RequestParam("page") Integer page,
                                                 @RequestParam(value = "fileName", required = false) String fileName,
                                                 @RequestParam(value = "userName", required = false) String userName,
                                                 @RequestParam(value = "uploadTimeStart", required = false) String uploadTimeStart,
                                                 @RequestParam(value = "uploadTimeEnd", required = false) String uploadTimeEnd) {
        return assessmentService.findAssessment(limit, page, fileName, userName, uploadTimeStart, uploadTimeEnd);
    }

    @PostMapping("assessment/updateAssessment")
    public Integer updateAssessment(Assessment assessment, @RequestParam(value = "file",required = false) MultipartFile file) {
        return assessmentService.updateAssessment(assessment, file);
    }
}
