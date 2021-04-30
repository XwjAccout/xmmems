package com.xmmems.service.warning;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.CustomUtils;
import com.xmmems.domain.EnvWarningMsg;
import com.xmmems.domain.EnvWarningMsgExample;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.EnvWarningMsgMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(rollbackFor = Exception.class)
public class WarningMsgService {

    @Autowired
    EnvWarningMsgMapper envWarningMsgMapper;

    public PageResult<EnvWarningMsg> pageQuery(Integer limit, Integer page, String phoneNum) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            EnvWarningMsgExample example = new EnvWarningMsgExample();
            EnvWarningMsgExample.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(phoneNum)) {
                criteria.andPhoneNumLike(CustomUtils.likeValue(phoneNum));
            }
            List<EnvWarningMsg> baseSites = envWarningMsgMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<EnvWarningMsg> pageInfo = new PageInfo<>(baseSites);
            //封装自定义的分页对象
            PageResult<EnvWarningMsg> pageResult =
                    new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());

            return pageResult;
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.DATA_NOT_FOUND);
        }
    }
    public int save( EnvWarningMsg envWarningMsg) {
        int result = envWarningMsgMapper.insertSelective(envWarningMsg);
        return result;
    }

}
