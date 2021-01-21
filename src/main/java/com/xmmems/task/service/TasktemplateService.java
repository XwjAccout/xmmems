package com.xmmems.task.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.TasktemplateMapper;
import com.xmmems.task.domain.Tasktemplate;
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
@Transactional
public class TasktemplateService {

    @Autowired
    private TasktemplateMapper tasktemplateMapper;

    public void insertSelective(Tasktemplate tasktemplate) {
        tasktemplateMapper.insertSelective(tasktemplate);
    }

    public PageResult<Tasktemplate> selectByExample(Integer limit, Integer page) {
        PageHelper.startPage(page, limit);
        Example example = new Example(Tasktemplate.class);
        List<Tasktemplate> tasktemplates = tasktemplateMapper.selectByExample(example);

        PageInfo<Tasktemplate> pageInfo = new PageInfo<>(tasktemplates);
        PageResult<Tasktemplate> pageResult = new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        return pageResult;
    }
}
