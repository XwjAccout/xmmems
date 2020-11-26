package com.xmmems.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.domain.env.EnvWarnRecord;
import com.xmmems.domain.env.EnvWarnRecordExample;
import com.xmmems.dto.BaseSiteDTO;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.EnvWarnRecordMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class WarningService {
    @Autowired
    private EnvWarnRecordMapper envWarnRecordMapper;

    @Autowired
    private MonitorService monitorService;

    public PageResult<EnvWarnRecord> getWarningData(Integer limit, Integer page, String startTime, String endTime, String siteId) {

        //封装查询条件
        EnvWarnRecordExample example = new EnvWarnRecordExample();
        EnvWarnRecordExample.Criteria criteria = example.createCriteria();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            if (StringUtils.isNotBlank(startTime)) {
                //不为空，添加到查询条件里面
                Date start = sdf.parse(startTime);
                criteria.andExcepTimeGreaterThanOrEqualTo(start);
            }
            if (StringUtils.isNotBlank(endTime)) {
                Date end = sdf.parse(endTime);
                criteria.andExcepTimeLessThanOrEqualTo(end);
            }
        } catch (ParseException e) {
            throw new XMException(500, "时间解析出错，格式为  yyyy-MM-dd HH:mm:ss");
        }

        if (StringUtils.isNotBlank(siteId)) {
            criteria.andSiteIdEqualTo(Integer.valueOf(siteId));
        } else {
            List<BaseSiteDTO> baseSiteDTOS = monitorService.getSites();
            List<Integer> collect = baseSiteDTOS.stream().map(BaseSiteDTO::getId).collect(Collectors.toList());
            criteria.andSiteIdIn(collect);
        }
        //封装分页信息
        PageHelper.startPage(page, limit);

        List<EnvWarnRecord> list = envWarnRecordMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new XMException(ExceptionEnum.ENVWARNRECORD_NOT_FOUND);
        }
        //得到pageHelper的分页对象
        PageInfo<EnvWarnRecord> pageInfo = new PageInfo<>(list);
        //封装自定义的分页对象
        return new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
    }
}
