package com.xmmems.service;

import com.xmmems.common.auth.domain.UserHolder;
import com.xmmems.common.utils.DateFormat;
import com.xmmems.domain.NetWork;
import com.xmmems.mapper.NetWorkMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @描述 联网统计类
 * @创建人 ithxw
 * @创建时间 2020.03.06 14:53
 */
@Service
@Transactional
public class NetWorkService {
    @Autowired
    private NetWorkMapper netWorkMapper;

    public List<NetWork> findNetWorks(String siteName, String start, String end, String siteId) {
        List<NetWork> list = netWorkMapper.selectByExampleByAccountId(UserHolder.loginId(), start, end);
        if (StringUtils.isNotBlank(siteName)) {
            list = list.stream().filter(temp -> temp.getSiteName().equals(siteName)).collect(Collectors.toList());
        }
        if (StringUtils.isNotBlank(siteId)) {
            list = list.stream().filter(temp -> temp.getSiteId().equals(siteId)).collect(Collectors.toList());
        }
        return list;

    }


    public Map<String, Integer> findNetWorksNumber() {
        Map<String, Integer> map = new HashMap<>();
        //今天的联网情况
        String format = DateFormat.formatSome(new Date());
        List<NetWork> netWorks = findNetWorks(null, format, format, null);
        map.put("all", netWorks.size());
        map.put("onLine", 0);
        map.put("offLine", 0);
        netWorks.forEach(netWork -> {
            if (netWork.getFlow() == 1) {
                map.put("onLine", map.get("onLine") + 1);
            } else {
                map.put("offLine", map.get("offLine") + 1);
            }
        });
        return map;
    }
}
