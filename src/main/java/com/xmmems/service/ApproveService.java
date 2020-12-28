package com.xmmems.service;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xmmems.common.auth.domain.UserHolder;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
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
        PageResult<Map<String, Object>> pageResult = monitorService.getHistoryData(limit, page, siteId, startTime, endTime,"DESC",false);

        List<Map<String, Object>> siteList = pageResult.getRows();

        //List<Record> siteList = Record.listMapToListRecord(maps);
        for (Map<String, Object> site : siteList) {
            //处理数据(比查询历史数据多了这个操作)
            handleApproveItem(site);
        }
        return pageResult;
    }

    /**
     * 处理数据
     */
    public Map<String, Object> handleApproveItem(Map<String, Object> record) {

        List<Map<String, String>> monitorItemList = JsonUtils.nativeRead(record.get("content").toString(), new TypeReference<List<Map<String, String>>>() {
        });
        for (Map<String, String> monitorItem : monitorItemList) {
            /*if (ProConstant.existModifyItem(monitorItem.get("itemName"))) {
                monitorItem.put("itemName", ProConstant.getModifyValueByKey(monitorItem.get("itemName")));
            }*/
            String v = monitorItem.get("value");
            String value = rds.formatValue(monitorItem.get("itemName"), v);
            if (!StringUtils.isBlank(monitorItem.get("troubleCode")) && !"N".equals(monitorItem.get("troubleCode"))&& !" N".equals(monitorItem.get("troubleCode"))) {
                value = value + "$$" + monitorItem.get("troubleCode");
            }
            record.put(monitorItem.get("itemName"), value+"^"+v);
        }

        record.remove("content");
        return record;
    }

    //保存处理修正的数据1
    public void saveAdjust(String adjust, Integer siteId, Integer recordId, String adjustKey, String adjustValue, String originValue,
                           String troubleCode, String troubleName, String multipleAdjust, String startTime, String endTime, String multipleParam) {


        List<Map<String, Object>> hourDatas = new ArrayList<>();
        if ("true".equals(multipleAdjust)) {
            //hourDatas = Record.listMapToListRecord(list);
            hourDatas = envHourDataMapper.selectHistoryData(siteId, startTime, endTime,"desc");
        } else {
            //单个修正
            EnvHourData envHourData = envHourDataMapper.selectByPrimaryKey(recordId);
            Map<String, Object> map = JsonUtils.toMap(JsonUtils.toString(envHourData), String.class, Object.class);
            hourDatas.add(map);
            //Record record = new Record(JsonUtils.toMap(JsonUtils.toString(envHourData), String.class, Object.class));
            //hourDatas.add(record);
        }

        for (Map<String, Object> hourData : hourDatas) {
            Map item = null;
            List<Map> monitorItems = JsonUtils.nativeRead(hourData.get("content") + "", new TypeReference<List<Map>>() {
            });

            for (Map map : monitorItems) {
                item = map;
                if (StrUtil.equals("3", adjust)) {
                    if (adjustKey.equals(map.get("itemName"))) {
                        map.put("troubleCode", troubleCode); //"N"
                        map.put("troubleName", troubleName); //正常
                    }
                } else {
                    if ("true".equals(multipleAdjust) && "true".equals(multipleParam)) {
                        map.put("troubleCode", troubleCode);
                        map.put("troubleName", troubleName);
                        if (!StringUtils.isBlank(adjustValue)) {
                            map.put("value", adjustValue);
                        }
                    } else if (adjustKey.equals(map.get("itemName"))) {
                        map.put("troubleCode", troubleCode);
                        map.put("troubleName", troubleName);
                        if (!StringUtils.isBlank(adjustValue)) {
                            map.put("value", adjustValue);
                        }
                        break;
                    }
                }

            }
            if (item != null) {
                //System.out.println(JsonUtils.toString(monitorItems));
                hourData.put("content", monitorItems);
                EnvHourData envHourData = EnvHourData.builder().id((Integer) hourData.get("id")).content(JsonUtils.toString(monitorItems)).build();

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

        List<Map<String, Object>> hourDatas = envHourDataMapper.selectHistoryData(siteId, startTime, endTime,"desc");
        for (Map<String, Object> hourData : hourDatas) {
            String content = hourData.get("content") + "";
            if (StringUtils.isNotBlank(content)) {
                List<Map> monitorItems = JsonUtils.nativeRead(content, new TypeReference<List<Map>>() {                });
                for (Map map : monitorItems) {
                    if (StringUtils.isBlank(adjustKey)) {
                        // itemId = String.valueOf(map.get("itemId"));
                        map.put("troubleCode", "");
                        map.put("troubleName", "");
                        map.put("value", map.get("originValue"));
                    }else {
                        if (map.get("itemName").equals(adjustKey)) {
                            itemId = String.valueOf(map.get("itemId"));
                            map.put("troubleCode", "");
                            map.put("troubleName", "");
                            map.put("value", map.get("originValue"));
                        }
                    }
                }
                //hourData.put("content", monitorItems); 不要这行代码也行
                EnvHourData envHourData = EnvHourData.builder().id((Integer) hourData.get("id")).content(JsonUtils.toString(monitorItems)).build();
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
        Gson gson = new Gson();
        EnvHourData envHourData = envHourDataMapper.selectByPrimaryKey(id);
        List<Map<String, String>> columns = new ArrayList<>();

        if (envHourData != null) {
            List<Map<String, String>> monitorItemList = gson.fromJson(envHourData.getContent(),
                    new TypeToken<List<Map<String, String>>>() {
                    }.getType());

            for (Map<String, String> monitorItem : monitorItemList) {
                Map<String, String> param = new HashMap<>();
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
        Map<String, Object> ret = new HashMap<>();
        List<Map<String, String>> columns = getColumns(id);

        String genTime = columns.get(0).get("genTime");
        ret.put("genTime", genTime);
        ret.put("siteId", siteId);
        ret.put("siteName", siteName);
        ret.put("columns", columns);
        return ret;
    }

    public boolean addDataSave(Integer siteId, String siteName, String monitorTime, String itemData, String[] times) {

        String mtime = null;
        boolean flag = true;

        for (String m : times) {
            mtime = monitorTime + " " + m + ":00:00";

            EnvHourData envHourData = envHourDataMapper.selectBySiteIdAndGenTime(siteId, mtime);
            if (envHourData == null) {
                envHourData = new EnvHourData();
                envHourData.setSiteId(siteId);
                envHourData.setSiteName(siteName);
                try {
                    envHourData.setGenTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(mtime));
                } catch (ParseException e) {
                    throw new XMException(500, "字符串转换成日期异常");
                }

                envHourData.setContent(itemData);
                int i = envHourDataMapper.insertSelective(envHourData);
                flag = i == 1;
            } else {
                envHourData.setContent(itemData);
                int i = envHourDataMapper.updateByPrimaryKeyWithBLOBs(envHourData);

                flag = i == 1;
            }
        }
        return flag;
    }

    public void deleteByIds(Integer[] ids) {
        for (Integer id : ids) {
            int i = envHourDataMapper.deleteByPrimaryKey(id);
            if (i < 1) throw new XMException(ExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }
}
