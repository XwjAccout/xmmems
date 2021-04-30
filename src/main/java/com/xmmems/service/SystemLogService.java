package com.xmmems.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.CustomUtils;
import com.xmmems.common.utils.JsonUtils;
import com.xmmems.domain.SystemLog;
import com.xmmems.domain.SystemLogExample;
import com.xmmems.domain.account.Account;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.AccountMapper;
import com.xmmems.mapper.SystemLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @描述 操作日志业务类
 * @创建人 ithxw
 * @创建时间 2020.03.02 11:24
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class SystemLogService {

    @Autowired
    private SystemLogMapper mapper;

    @Autowired
    private AccountMapper accountMapper;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 操作正常
     */
    public int save(SystemLog systemLog) {
        int i = mapper.insertSelective(systemLog);
        if (i < 1) {
            log.error("操作日志插入失败{}",new Date());
            throw new XMException(ExceptionEnum.INSERT_OPERATION_FAIL);
        }
        return i;
    }

    public PageResult<Map<String, Object>> paginate(Integer limit, Integer page, String type, String userId, String description, String start, String end) {
        //封装分页信息
        PageHelper.startPage(page, limit);

        SystemLogExample example = new SystemLogExample();
        SystemLogExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(type)) {
            criteria.andTypeEqualTo(type);
        }
        if (StringUtils.isNotBlank(userId)) {
            criteria.andUseridEqualTo(userId);
        }
        if (StringUtils.isNotBlank(description)) {
            criteria.andDescriptionLike(CustomUtils.likeValue(description));
        }
        try {
            if (StringUtils.isNotBlank(start)) {
                criteria.andActiondateGreaterThanOrEqualTo(sdf.parse(start));
            }
            if (StringUtils.isNotBlank(end)) {
                criteria.andActiondateLessThanOrEqualTo(sdf.parse(end));
            }
        } catch (ParseException e) {
            throw new XMException(500, "日期解析异常");
        }
        List<SystemLog> systemLogs = mapper.selectByExample(example);
        PageInfo<SystemLog> p = new PageInfo<>(systemLogs);
        List<Map<String, Object>> list = JsonUtils.nativeRead(JsonUtils.toString(systemLogs), new TypeReference<List<Map<String, Object>>>() {
        });
        list.forEach(map->{
            Account user = accountMapper.selectByPrimaryKey(Integer.parseInt(map.get("userid")+""));
            map.put("userName", user.getUserName());
        });

        PageResult<Map<String, Object>> pageResult = null;
        if (systemLogs.size()>0) {
            pageResult = new PageResult<>(p.getSize(), page, p.getTotal(), p.getPages(), list);
        }
        return pageResult;
    }
}
