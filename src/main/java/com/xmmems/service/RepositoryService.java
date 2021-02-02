package com.xmmems.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.XMException;
import com.xmmems.domain.Repository;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.RepositoryMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional
public class RepositoryService {
    @Autowired
    private RepositoryMapper repositoryMapper;
    @Autowired
    private UploadService uploadService;

    public PageResult<Repository> pageQuery(Integer limit, Integer page, Integer type, String essayTitle) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件

            Example example = new Example(Repository.class);
            Example.Criteria criteria = example.createCriteria();
            if (type != null) {
                criteria.andEqualTo("type", type);
            }
            if (StringUtils.isNotBlank(essayTitle)) {
                criteria.andLike("essayTitle", "%" + essayTitle + "%");
            }
            List<Repository> repositories = repositoryMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<Repository> pageInfo = new PageInfo<>(repositories);
            //封装自定义的分页对象
            return new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            throw new XMException(404, "知识库暂无内容");
        }
    }

    public int save(Repository repository, MultipartFile file) {
        if (file != null) {

            String url = uploadService.file(file);
            repository.setUrl(url);
        }
        return repositoryMapper.insertSelective(repository);
    }


    public int update(Repository repository, MultipartFile file) {
        if (file != null) {

            String url = uploadService.file(file);
            repository.setUrl(url);
        }
        return repositoryMapper.updateByPrimaryKeySelective(repository);
    }

    public void delete(Integer id) {
        repositoryMapper.deleteByPrimaryKey(id);
    }

    public Integer updateUrl(Integer id, MultipartFile file) {
        String url = uploadService.file(file);
        return repositoryMapper.updateUrl(id, url);
    }
}
