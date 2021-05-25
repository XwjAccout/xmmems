package com.xmmems.service;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.xmmems.common.auth.domain.UserHolder;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.DateFormat;
import com.xmmems.common.utils.JsonUtils;
import com.xmmems.domain.base.BaseItem;
import com.xmmems.domain.env.EnvHourData;
import com.xmmems.domain.env.EnvHourDataAuditLog;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.EnvHourDataAuditLogMapper;
import com.xmmems.mapper.EnvHourDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class ApproveService {
    @Autowired
    private EnvHourDataMapper envHourDataMapper;

    @Autowired
    private RealtimeDataService rds;

    @Autowired
    private MonitorService monitorService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private EnvHourDataAuditLogMapper envHourDataAuditLogMapper;

    public PageResult<Map<String, Object>> getHistoryDataHandled(Integer limit, Integer page, Integer siteId, String startTime, String endTime) {
        //查询历史分页数据
        PageResult<Map<String, Object>> pageResult = monitorService.getHistoryData(limit, page, siteId, startTime, endTime, "DESC", false);

        List<Map<String, Object>> siteList = pageResult.getRows();

        for (Map<String, Object> site : siteList) {
            //处理数据(比查询历史数据多了这个操作)
            handleApproveItem(site);
        }
        return pageResult;
    }

    /**
     * 处理数据
     */
    public void handleApproveItem(Map<String, Object> record) {

        List<Map<String, String>> monitorItemList = JsonUtils.nativeRead(record.get("content").toString(), new TypeReference<List<Map<String, String>>>() {});
        for (Map<String, String> monitorItem : monitorItemList) {
            String v = monitorItem.get("value");
            String value = rds.formatValue(monitorItem.get("itemName"), v);
            if (!StringUtils.isBlank(monitorItem.get("troubleCode")) && !"N".equals(monitorItem.get("troubleCode")) && !" N".equals(monitorItem.get("troubleCode"))) {
                value = value + "$$" + monitorItem.get("troubleCode");
            }
            record.put(monitorItem.get("itemName"), value + "^" + v);
        }

        record.remove("content");
    }

    //保存处理修正的数据1
    public void saveAdjust(String adjust, Integer siteId, Integer recordId, String adjustKey, String adjustValue, String originValue, String troubleCode, String troubleName, String multipleAdjust, String startTime, String endTime, String multipleParam) {

        List<Map<String, Object>> hourDatas = new ArrayList<>();
        if ("true".equals(multipleAdjust)) {
            hourDatas = envHourDataMapper.selectHistoryData(siteId, startTime, endTime, "desc");
        } else {
            //单个修正
            EnvHourData envHourData = envHourDataMapper.selectByPrimaryKey(recordId);
            Map<String, Object> map = JsonUtils.toMap(JsonUtils.toString(envHourData), String.class, Object.class);
            hourDatas.add(map);
        }

        for (Map<String, Object> hourData : hourDatas) {
            Map item = null;
            List<Map<String, String>> monitorItems = JsonUtils.nativeRead(hourData.get("content") + "", new TypeReference<List<Map<String, String>>>() {});

            String troubleNameKey = "troubleName";
            String troubleCodeKey = "troubleCode";
            for (Map<String, String> map : monitorItems) {
                item = map;
                if (StrUtil.equals("3", adjust)) {
                    if (adjustKey.equals(map.get("itemName"))) {
                        //"N"//正常
                        map.put(troubleCodeKey, troubleCode);
                        map.put(troubleNameKey, troubleName);
                    }
                } else {
                    if ("true".equals(multipleAdjust) && "true".equals(multipleParam)) {
                        map.put(troubleCodeKey, troubleCode);
                        map.put(troubleNameKey, troubleName);
                        if (!StringUtils.isBlank(adjustValue)) {
                            map.put("value", adjustValue);
                        }
                    } else if (adjustKey.equals(map.get("itemName"))) {
                        map.put(troubleCodeKey, troubleCode);
                        map.put(troubleNameKey, troubleName);
                        if (!StringUtils.isBlank(adjustValue)) {
                            map.put("value", adjustValue);
                        }
                        break;
                    }
                }

            }
            if (item != null) {
                hourData.put("content", monitorItems);
                EnvHourData envHourData = EnvHourData.builder().id((Integer)hourData.get("id")).content(JsonUtils.toString(monitorItems)).build();

                int i = envHourDataMapper.updateByPrimaryKeySelective(envHourData);
                if (i < 1) {
                    log.error("更新envHourData数据失败");
                    throw new XMException(ExceptionEnum.UPDATE_OPERATION_FAIL);
                }

                //创建审核监测项目修改的日志记录表,方便后期的还原操作
                EnvHourDataAuditLog envHourDataAuditLog = new EnvHourDataAuditLog();
                envHourDataAuditLog.setSiteId(envHourData.getSiteId());
                //下面是因为通过gson转换后itemId由integer 转换 为 double，需要去掉小数点之后的数据
                String itemId = item.get("itemId") + "";
                itemId = itemId.split("\\.")[0];
                envHourDataAuditLog.setItemId(Integer.valueOf(itemId));
                envHourDataAuditLog.setSiteName(envHourData.getSiteName());
                envHourDataAuditLog.setGenTime(envHourData.getGenTime());

                if (StrUtil.equals("3", adjust)) {
                    envHourDataAuditLog.setOriginValue(item.get("value") + "");
                } else {
                    envHourDataAuditLog.setOriginValue(originValue);
                }

                envHourDataAuditLog.setModifyTime(new Date());
                envHourDataAuditLog.setModifyFlag(troubleCode);

                envHourDataAuditLog.setPersion(UserHolder.getNickName());
                envHourDataAuditLog.setModifyReason(troubleName);

                int i1 = envHourDataAuditLogMapper.insertSelective(envHourDataAuditLog);
                if (i1 != 1) {
                    throw new XMException(ExceptionEnum.INSERT_OPERATION_FAIL);
                }
            }

        }
    }

    //还原修正过的数据
    public void resetAdjust(Integer siteId, String siteName, String adjustKey, String startTime, String endTime) {
        String itemId = "";

        List<Map<String, Object>> hourDatas = envHourDataMapper.selectHistoryData(siteId, startTime, endTime, "desc");
        for (Map<String, Object> hourData : hourDatas) {
            String content = hourData.get("content") + "";
            if (StringUtils.isNotBlank(content)) {
                List<Map<String, String>> monitorItems = JsonUtils.nativeRead(content, new TypeReference<List<Map<String, String>>>() {});
                for (Map<String, String> map : monitorItems) {
                    if (StringUtils.isBlank(adjustKey)) {
                        map.put("troubleCode", "");
                        map.put("troubleName", "");
                        map.put("value", map.get("originValue"));
                    } else {
                        if (map.get("itemName").equals(adjustKey)) {
                            itemId = String.valueOf(map.get("itemId"));
                            map.put("troubleCode", "");
                            map.put("troubleName", "");
                            map.put("value", map.get("originValue"));
                            break;
                        }
                    }
                }
                EnvHourData envHourData = new EnvHourData();
                envHourData.setId((Integer)hourData.get("id"));
                envHourData.setContent(JsonUtils.toString(monitorItems));
                envHourDataMapper.updateByPrimaryKeySelective(envHourData);
            }
        }

        //还原记录
        EnvHourDataAuditLog envHourDataAuditLog = new EnvHourDataAuditLog();
        envHourDataAuditLog.setSiteId(siteId);
        envHourDataAuditLog.setSiteName(siteName);
        envHourDataAuditLog.setModifyTime(new Date());
        String nickName = UserHolder.getNickName();
        envHourDataAuditLog.setPersion(nickName);
        if (StringUtils.isNotBlank(itemId)) {
            itemId = itemId.split("\\.")[0];
            envHourDataAuditLog.setItemId(Integer.valueOf(itemId));
            envHourDataAuditLog.setModifyReason("恢复" + startTime + "-" + endTime + "的" + adjustKey + "数据");
        } else {
            envHourDataAuditLog.setModifyReason("恢复" + startTime + "-" + endTime + "的所有数据");
        }

        int i1 = envHourDataAuditLogMapper.insertSelective(envHourDataAuditLog);
        if (i1 != 1) {
            throw new XMException(ExceptionEnum.INSERT_OPERATION_FAIL);
        }
    }

    /**
     * 根据id查找监测数据，并处理
     */
    public List<Map<String, String>> getColumns(Integer id) {
        EnvHourData envHourData = envHourDataMapper.selectByPrimaryKey(id);
        List<Map<String, String>> columns = new ArrayList<>();
        if (envHourData != null) {
            List<Map<String, String>> monitorItemList = JsonUtils.nativeRead(envHourData.getContent(), new TypeReference<List<Map<String, String>>>() {});
            for (Map<String, String> monitorItem : monitorItemList) {
                Map<String, String> param = new HashMap<>(8);
                String genTime = new SimpleDateFormat("yyyy-MM-dd").format(envHourData.getGenTime());

                if (!StringUtils.isBlank(monitorItem.get("itemName"))) {
                    param.put("itemName", monitorItem.get("itemName"));
                    BaseItem item = commonService.getBaseItemByItemNameOrItemId(monitorItem.get("itemName"));
                    if (item != null) {
                        param.put("unit", item.getUnit());
                        param.put("itemId", String.valueOf(item.getId()));
                        param.put("value", String.valueOf(monitorItem.get("value")));
                        param.put("genTime", genTime);
                    } else {
                        param.put("unit", "");
                        param.put("itemId", "");
                        param.put("value", "");
                        param.put("genTime", "");
                    }
                    columns.add(param);
                }
            }
        }
        return columns;
    }

    //根据id查询数据
    public Map<String, Object> findDate(Integer id, Integer siteId, String siteName) {
        Map<String, Object> ret = new HashMap<>(8);
        List<Map<String, String>> columns = getColumns(id);

        String genTime = columns.get(0).get("genTime");
        ret.put("genTime", genTime);
        ret.put("siteId", siteId);
        ret.put("siteName", siteName);
        ret.put("columns", columns);
        return ret;
    }

    // 判断一个字符是否是中文
    private static boolean isChinese(char c) {
        return c >= 0x4E00 && c <= 0x9FA5;// 根据字节码判断
    }

    // 判断一个字符串是否含有中文
    private static boolean isChinese(String str) {
        if (str == null) {
            return false;
        }
        for (char c : str.toCharArray()) {
            // 有一个中文字符就返回
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }

    public void addDataSave(Integer siteId, String siteName, String monitorTime, String itemData, String[] times, HashMap<String, String> mapBody) {

        List<BaseItem> baseItems = envHourDataMapper.selectAllBaseItem();
        Map<String, Integer> collect = new HashMap<>();
        for (BaseItem baseItem : baseItems) {
            Integer put = collect.put(baseItem.getName(), baseItem.getId());
            if (put != null) {
                throw new IllegalStateException("数据库存在同名监测项目");
            }
        }
        List<Map<String, String>> mapList = JsonUtils.nativeRead(itemData, new TypeReference<List<Map<String, String>>>() {});
        Iterator<Map<String, String>> iterator = mapList.iterator();
        while (iterator.hasNext()) {
            Map<String, String> map = iterator.next();

            String value = map.get("value");
            if (value == null) {
                iterator.remove();
                continue;
            }
            String itemName = map.get("itemName");
            if (!isChinese(itemName) && !"pH".equalsIgnoreCase(itemName)) {
                iterator.remove();
                continue;
            }
            Integer itemId = collect.get(itemName);
            if (itemId == null) {
                iterator.remove();
                continue;
            }
            map.put("itemId", itemId + "");
            map.put("troubleCode", "");
            map.put("troubleName", "");
            map.put("originValue", map.get("value"));
        }
        for (String m : times) {

            String mtime = monitorTime + " " + m + ":00:00";
            envHourDataMapper.deleteByTime(siteId, mtime);
            EnvHourData envHourData = new EnvHourData();
            envHourData.setSiteId(siteId);
            envHourData.setSiteName(siteName);
            envHourData.setGenTime(DateFormat.parseAll(mtime));
            envHourData.setContent(JsonUtils.toString(mapList));
            if (mapBody.size() > 0) {
                String s = mapBody.get(m);
                envHourData.setHandle(s);
            }
            envHourDataMapper.insertSelective(envHourData);
        }
    }

    public void addDataSave(Integer siteId, String siteName, String monitorTime, String itemData, String[] times) {

        List<BaseItem> baseItems = envHourDataMapper.selectAllBaseItem();
        Map<String, Integer> collect = baseItems.stream().collect(Collectors.toMap(BaseItem::getName, BaseItem::getId));
        List<Map<String, String>> mapList = JsonUtils.nativeRead(itemData, new TypeReference<List<Map<String, String>>>() {});
        Iterator<Map<String, String>> iterator = mapList.iterator();
        while (iterator.hasNext()) {
            Map<String, String> map = iterator.next();


            String value = map.get("value");
            if (value == null) {
                iterator.remove();
                continue;
            }
            String itemName = map.get("itemName");
            if (!isChinese(itemName) && !"pH".equalsIgnoreCase(itemName)) {
                iterator.remove();
                continue;
            }
            Integer itemId = collect.get(itemName);
            if (itemId == null) {
                iterator.remove();
                continue;
            }
            map.put("itemId", itemId + "");
            map.put("troubleCode", "");
            map.put("troubleName", "");
            map.put("originValue", map.get("value"));
        }
        for (String m : times) {
            String mtime = monitorTime + " " + m + ":00:00";
            envHourDataMapper.deleteByTime(siteId, mtime);
            EnvHourData envHourData = new EnvHourData();
            envHourData.setSiteId(siteId);
            envHourData.setSiteName(siteName);
            envHourData.setGenTime(DateFormat.parseAll(mtime));
            envHourData.setContent(JsonUtils.toString(mapList));
            envHourDataMapper.insertSelective(envHourData);
        }
    }

    public void deleteByIds(Integer[] ids) {
        for (Integer id : ids) {
            int i = envHourDataMapper.deleteByPrimaryKey(id);
            if (i < 1) {
                throw new XMException(ExceptionEnum.DELETE_OPERATION_FAIL);
            }
        }
    }
}
