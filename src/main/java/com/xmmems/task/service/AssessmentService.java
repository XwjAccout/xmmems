package com.xmmems.task.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.constant.XmmemsConstants;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.AssessmentMapper;
import com.xmmems.service.UploadService;
import com.xmmems.task.domain.Assessment;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import java.io.File;
import java.util.List;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2021.01.21 14:48
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AssessmentService {
    @Autowired
    private AssessmentMapper assessmentMapper;
    @Autowired
    private UploadService uploadService;

    public Integer uploadAssessment(Assessment assessment, MultipartFile file) {
        if (file != null) {

            String url = uploadService.file(file);
            assessment.setAssessFileUrl(url);
            assessment.setName(file.getOriginalFilename());
        }
        //更新通知状态
        return assessmentMapper.insertSelective(assessment);
    }

    public PageResult<Assessment> findAssessment(Integer limit, Integer page, String fileName, String userName, String uploadTimeStart, String uploadTimeEnd) {
        String end = " 23:59:59";
        //封装分页信息
        PageHelper.startPage(page, limit);
        Example example = new Example(Assessment.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(fileName)) {
            criteria.andLike("name", "%" + fileName + "%");
        }
        if (StringUtils.isNotBlank(userName)) {
            criteria.andLike("userName", "%" + userName + "%");
        }
        if (StringUtils.isNotBlank(uploadTimeStart)) {
            criteria.andGreaterThanOrEqualTo("uploadTime", uploadTimeStart);
        }
        if (StringUtils.isNotBlank(uploadTimeEnd)) {
            criteria.andLessThanOrEqualTo("uploadTime", uploadTimeEnd + end);
        }
        List<Assessment> assessments = assessmentMapper.selectByExample(example);
        PageInfo<Assessment> pageInfo = new PageInfo<>(assessments);
        PageResult<Assessment> pageResult = new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        return pageResult;
    }

    public Integer delAssessment(Integer id) {
        Assessment assessment = assessmentMapper.selectByPrimaryKey(id);
        String assessFileUrl = assessment.getAssessFileUrl();
        String fileUrl = assessFileUrl.replace(XmmemsConstants.UPLOAD_FILE_URL, XmmemsConstants.UPLOAD_FILE_PATH);
        File file = new File(fileUrl);
        if (file.isFile()) {
            //先删文件
            file.delete();
        }
        //再删数据库数据
        return assessmentMapper.deleteByPrimaryKey(id);
    }

    public Integer updateAssessment(Assessment assessment, MultipartFile file) {
        if (file != null) {

            String url = uploadService.file(file);
            assessment.setAssessFileUrl(url);
            assessment.setName(file.getOriginalFilename());
        }
        //更新通知状态
        return assessmentMapper.updateByPrimaryKeySelective(assessment);
    }
}
