package com.xmmems.task.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.TasktemplateMapper;
import com.xmmems.task.domain.Tasktemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2021.01.20 16:47
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class TasktemplateService {

    @Autowired
    private TasktemplateMapper tasktemplateMapper;

    public void insertSelective(String taskName, String title, String content, String sendUser) {
        Tasktemplate tasktemplate = new Tasktemplate();
        tasktemplate.setTaskName(taskName);
        tasktemplate.setTitle(title);
        tasktemplate.setContent(content);
        tasktemplate.setSendUser(sendUser);

        try {
            tasktemplateMapper.insertSelective(tasktemplate);
        } catch (Exception e) {
            log.error(tasktemplate.toString());
            log.error(e.getMessage());
            throw new XMException(ExceptionEnum.INSERT_ERROR);
        }
    }

    public PageResult<Tasktemplate> selectByExample(Integer limit, Integer page) {
        PageHelper.startPage(page, limit);
        Example example = new Example(Tasktemplate.class);
        List<Tasktemplate> tasktemplates = null;
        try {
            tasktemplates = tasktemplateMapper.selectByExample(example);
        } catch (Exception e) {
            log.error(example.getPropertyMap().toString());
            log.error(e.getMessage());
            throw new XMException(ExceptionEnum.UPDATE_ERROR);
        }

        PageInfo<Tasktemplate> pageInfo = new PageInfo<>(tasktemplates);
        return new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
    }

    public void deleteByTaskName(String taskName) {
        try {
            tasktemplateMapper.deleteByPrimaryKey(taskName);
        } catch (Exception e) {
            log.error(taskName);
            log.error(e.getMessage());
            throw new XMException(ExceptionEnum.DELETE_ERROR);
        }
    }

    public void updateByTasktemplate(String taskName, String title, String content, String sendUser) {
        Tasktemplate tasktemplate = new Tasktemplate();
        tasktemplate.setTaskName(taskName);
        tasktemplate.setTitle(title);
        tasktemplate.setContent(content);
        tasktemplate.setSendUser(sendUser);

        try {
            tasktemplateMapper.updateByPrimaryKeySelective(tasktemplate);
        } catch (Exception e) {
            log.error(tasktemplate.toString());
            log.error(e.getMessage());
            throw new XMException(ExceptionEnum.UPDATE_ERROR);
        }
    }
}
