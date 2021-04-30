package com.xmmems.service.warning;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.CustomUtils;
import com.xmmems.domain.env.EnvAddressBook;
import com.xmmems.domain.env.EnvAddressBookExample;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.EnvAddressBookMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(rollbackFor = Exception.class)
public class AddressBookService {
    @Autowired
   private EnvAddressBookMapper envAddressBookMapper;


    public PageResult<EnvAddressBook> pageQuery(Integer limit, Integer page, String name) {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            EnvAddressBookExample example = new EnvAddressBookExample();
            EnvAddressBookExample.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(name)) {
                criteria.andNameLike(CustomUtils.likeValue(name));
            }
            List<EnvAddressBook> baseSites = envAddressBookMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<EnvAddressBook> pageInfo = new PageInfo<>(baseSites);
            //封装自定义的分页对象
            PageResult<EnvAddressBook> pageResult =
                    new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());

            return pageResult;
    }

    public EnvAddressBook findById(Integer id) {
        EnvAddressBook envAddressBook = envAddressBookMapper.selectByPrimaryKey(id);
        return envAddressBook;
    }

    public int save(EnvAddressBook envAddressBook) {
        int result = envAddressBookMapper.insertSelective(envAddressBook);
        return result;
    }

    public void update( EnvAddressBook envAddressBook) {
        int i = envAddressBookMapper.updateByPrimaryKeySelective(envAddressBook);
        if (i != 1) {
            throw new XMException(ExceptionEnum.UPDATE_OPERATION_FAIL);
        }
    }

    public void delete(Integer id) {
        int i = envAddressBookMapper.deleteByPrimaryKey(id);
        if (i != 1) {
            throw new XMException(ExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }

}
