package com.xmmems.service;

import com.xmmems.common.utils.JsonUtils;
import com.xmmems.domain.base.BaseItem;
import com.xmmems.domain.base.BaseItemExample;
import com.xmmems.domain.base.BaseSite;
import com.xmmems.domain.env.EnvQualityConf;
import com.xmmems.domain.env.EnvQualityConfExample;
import com.xmmems.dto.BaseSiteitemDTO;
import com.xmmems.mapper.BaseItemMapper;
import com.xmmems.mapper.BaseSiteMapper;
import com.xmmems.mapper.BaseSiteitemMapper;
import com.xmmems.mapper.EnvQualityConfMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @描述 初始化并保存常用的数据（从数据库获取的）
 * @创建人 ithxw
 * @创建时间 2020.07.01 16:30
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CommonService {
    @Autowired
    private BaseSiteMapper baseSiteMapper;
    @Autowired
    private EnvQualityConfMapper envQualityConfMapper;
    @Autowired
    private BaseItemMapper baseItemMapper;
    @Autowired
    private BaseSiteitemMapper baseSiteitemMapper;

    private static List<BaseSite> BASE_SITE_LIST = new ArrayList<>();
    private static Map<String, BaseSite> ALL_SITE_MAP = new HashMap<>(16);

    private static List<EnvQualityConf> ENV_QUALITY_CONF_LIST = new ArrayList<>();
    private static Map<String, List<EnvQualityConf>> ITEMNAME_QUALITYCONF_MAP = new HashMap<>(16);

    private static List<BaseItem> BASE_ITEM_LIST = new ArrayList<>();
    private static Map<String, BaseItem> BASE_ITEM_MAP = new HashMap<>(256);
    //保留位数
    private static Map<String, Integer> ITEM_DIGITS = new HashMap<>(256);

    private static Map<Integer, List<BaseSiteitemDTO>> BASE_SITE_ITEM_MAP = new HashMap<>(16);

    @PostConstruct
    public synchronized void initBaseSite() {
        List<BaseSite> baseSites = baseSiteMapper.getBaseSites();
        BASE_SITE_LIST = baseSites;
        for (BaseSite value : baseSites) {
            ALL_SITE_MAP.put(value.getId() + "", value);
            ALL_SITE_MAP.put(value.getSiteName(), value);
        }
    }

    @PostConstruct
    public synchronized void initItemMap(){
        List<BaseSiteitemDTO> items = baseSiteitemMapper.getAllColumns();
        Map<Integer, List<BaseSiteitemDTO>> tempMap = new HashMap<>(16);
        for (BaseSiteitemDTO item : items) {
            Integer siteId = item.getSiteId();
            List<BaseSiteitemDTO> list = tempMap.get(siteId);
            if (list == null) {
                list = new ArrayList<>();
                tempMap.put(siteId, list);
            }
            list.add(item);
        }
        BASE_SITE_ITEM_MAP = tempMap;
    }

    @PostConstruct
    public synchronized void initEnvQualityConf() {
        ENV_QUALITY_CONF_LIST = envQualityConfMapper.selectByExample(new EnvQualityConfExample());
        //2、查询所有指标的质量类别集合,查询全部 一次性查询，在根据项目名进行处理
        Map<String, List<EnvQualityConf>> allEnvQualityConfs = ITEMNAME_QUALITYCONF_MAP;
        for (EnvQualityConf envQualityConf : ENV_QUALITY_CONF_LIST) {
            String kpiName = envQualityConf.getKpiName();
            allEnvQualityConfs.computeIfAbsent(kpiName, k -> new ArrayList<>()).add(envQualityConf);
        }
    }

    @PostConstruct
    public synchronized void initBaseItem() {
        List<BaseItem> baseItems = baseItemMapper.selectByExample(new BaseItemExample());
        BASE_ITEM_LIST = baseItems;
        for (BaseItem baseItem : baseItems) {
            BaseItem put = BASE_ITEM_MAP.put(baseItem.getName(), baseItem);
            BASE_ITEM_MAP.put(baseItem.getId() + "", baseItem);
            ITEM_DIGITS.put(baseItem.getName(), baseItem.getDigits());
            ITEM_DIGITS.put(baseItem.getId() + "", baseItem.getDigits());
            if (put != null) {
                System.out.println("*******替换前*********" + JsonUtils.toString(put));
                System.out.println("*******替换后*********" + JsonUtils.toString(baseItem));
            }
        }
    }

    public synchronized void initBaseSiteItemMap(Integer siteId) {
        List<BaseSiteitemDTO> items = baseSiteitemMapper.getColumns(siteId);
        BASE_SITE_ITEM_MAP.put(siteId, items);
    }

    public synchronized void initBaseSiteItemMap2(Integer siteId) {
        if (!BASE_SITE_ITEM_MAP.containsKey(siteId)) {
            List<BaseSiteitemDTO> items = baseSiteitemMapper.getColumns(siteId);
            BASE_SITE_ITEM_MAP.put(siteId, items);
        }
    }

    //获取有效的站点集合
    public List<BaseSite> getBaseSiteList() {
        return BASE_SITE_LIST;
    }

    //获取站点map集合
    public Map<String, BaseSite> getAllSiteMap() {
        return ALL_SITE_MAP;
    }

    //获取所有的质量类别集合
    public List<EnvQualityConf> getEnvQualityConfList() {
        return ENV_QUALITY_CONF_LIST;
    }

    public BaseItem getBaseItemByItemNameOrItemId(String itemNameOrItemId) {
        return BASE_ITEM_MAP.get(itemNameOrItemId);
    }

    public Integer getItemDigitsByItemNameOrItemId(String itemNameOrItemId) {
        Integer digits = ITEM_DIGITS.get(itemNameOrItemId);
        return digits == null ? 5 : digits;
    }

    public List<BaseItem> getBaseItemList() {
        return BASE_ITEM_LIST;
    }

    public List<BaseSiteitemDTO> getBaseSiteItemBySiteId(Integer siteId) {
        initBaseSiteItemMap2(siteId);
        return BASE_SITE_ITEM_MAP.get(siteId);
    }

    public Map<String, List<EnvQualityConf>> getItemNameQualityConfMap() {
        return ITEMNAME_QUALITYCONF_MAP;
    }
}
