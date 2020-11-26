package com.xmmems.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.domain.Repository;
import com.xmmems.domain.RepositoryExample;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.RepositoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RepositoryService {
    @Autowired
    RepositoryMapper repositoryMapper;

    public PageResult<Repository> pageQuery(Integer limit, Integer page,Integer type) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            RepositoryExample example = new RepositoryExample();
            RepositoryExample.Criteria criteria = example.createCriteria();
//            if(siteId!=null){
//                criteria.andSiteIdEqualTo(siteId);
//            }
            criteria.andTypeEqualTo(type);
            List<Repository> baseSites = repositoryMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<Repository> pageInfo = new PageInfo<>(baseSites);
            //封装自定义的分页对象

            return new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.ROLE_NOT_FOUND);
        }
    }
    public int save(  Repository repository) {
        return repositoryMapper.insertSelective(repository);
    }


}
