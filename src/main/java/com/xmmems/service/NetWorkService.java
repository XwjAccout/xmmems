package com.xmmems.service;

import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.DateFormat;
import com.xmmems.common.utils.FileLog;
import com.xmmems.domain.NetWork;
import com.xmmems.domain.NetWorkExample;
import com.xmmems.domain.base.BaseSite;
import com.xmmems.mapper.BaseSiteMapper;
import com.xmmems.mapper.NetWorkMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private BaseSiteMapper baseSiteMapper;

    @Autowired
    private CommonService commonService;

    public List<NetWork> findNetWorks(String siteName, String start, String end,String siteId) {
        NetWorkExample example = new NetWorkExample();
        NetWorkExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(siteName)) {
            criteria.andSiteNameEqualTo(siteName);
        }
        if (StringUtils.isNotBlank(siteId)) {
            criteria.andSiteIdEqualTo(siteId);
        }
        try {
            criteria.andDateGreaterThanOrEqualTo(DateFormat.parseSome(start));
            criteria.andDateLessThanOrEqualTo(DateFormat.parseSome(end));
        } catch (Exception e) {
            throw new XMException(500, "日期解析异常");
        }
        return netWorkMapper.selectByExample(example);

    }

    /**
     * 更新联网情况为断网状态
     */
    private void offLine(NetWork netWork) {
        FileLog.error("断网状态");
        if (netWork.getFlow() == 1) {
            netWork.setOffLineCount(netWork.getOffLineCount() + 1);
            netWork.setFlow(0);
            BaseSite record = new BaseSite();
            String siteId = netWork.getSiteId();
            record.setId(Integer.valueOf(siteId));
            record.setStatus("0");
            baseSiteMapper.updateByPrimaryKeySelective(record);
        }
        netWork.setOffLine(netWork.getOffLine() + 1);
        int i = netWorkMapper.updateByPrimaryKeySelective(netWork);
        if (i < 1) {
            FileLog.info("断网数据更新失败");
        }
    }

    /**
     * 更新联网情况为联网状态
     */
    private void onLine(NetWork netWork) {
        //FileLog.info("onLine");
        if (netWork.getFlow() == 0) {
            netWork.setLoginTime(new Date());
            netWork.setFlow(1);
            BaseSite record = new BaseSite();
            String siteId = netWork.getSiteId();
            record.setId(Integer.valueOf(siteId));
            record.setStatus("1");
            baseSiteMapper.updateByPrimaryKeySelective(record);
        }
        netWork.setOnLine(netWork.getOnLine() + 1);
        int i = netWorkMapper.updateByPrimaryKeySelective(netWork);
        if (i < 1) {
            FileLog.info(netWork.getSiteName() + "联网数据更新失败");
        }
    }

    public Map<String, Integer> findNetWorksNumber() {
        Map<String, Integer> map = new HashMap<>();
        //今天的联网情况
        String format = DateFormat.formatSome(new Date());
        List<NetWork> netWorks = findNetWorks(null, format, format,null);
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
