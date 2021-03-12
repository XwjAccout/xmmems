package com.xmmems.service.maintenance;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.domain.Reagent;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.ReagentMapper;
import com.xmmems.task.domain.Sendnotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional

public class ReagentService {
    @Autowired
    ReagentMapper reagentMapper;

    /**
     * 添加
     * @param reagent
     * @return
     */
    public Integer save(Reagent reagent) {
        return  reagentMapper.insertSelective(reagent);
    }

    public PageResult<Reagent> pageQuery(Integer limit, Integer page) {
        //封装分页信息
        PageHelper.startPage(page, limit);
        Example example = new Example(Sendnotice.class);
        Example.Criteria criteria = example.createCriteria();
        List<Reagent> sendnotices = reagentMapper.selectByExample(example);
        PageInfo<Reagent> pageInfo = new PageInfo<>(sendnotices);
        return new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
    }

    public Integer delete(Integer id) {
        try {
            return reagentMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.DELETE_ERROR);
        }
    }
    public Integer update( Reagent reagent) {

        //更新通知状态
        try {
            return reagentMapper.updateByPrimaryKeySelective(reagent);
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.UPDATE_ERROR);
        }
    }
}
