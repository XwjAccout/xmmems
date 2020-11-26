package com.xmmems.service;

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
@Transactional
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
    private static Map<String, BaseSite> ALL_SITE_MAP = new HashMap<>();
    private static long BASE_SITE_LIST_Effective_Time = 0;

    private static List<EnvQualityConf> ENV_QUALITY_CONF_LIST = new ArrayList<>();
    private static long ENV_QUALITY_CONF_LIST_Effective_Time = 0;

    private static List<BaseItem> BASE_ITEM_LIST = new ArrayList<>();
    private static Map<String, BaseItem> BASE_ITEM_MAP = new HashMap<>();
    private static long BASE_ITEM_MAP_Effective_Time = 0;

    private static Map<Integer, List<BaseSiteitemDTO>> BASE_SITE_ITEM_MAP = new HashMap<>();
    private static long BASE_SITE_ITEM_MAP_Effective_Time = 0;

    private void initSite() {
        //初始化有效的站点集合(超过10秒才会更新)
        if (System.currentTimeMillis() - BASE_SITE_LIST_Effective_Time > 15000) {

            BASE_SITE_LIST = baseSiteMapper.getBaseSites();
            for (BaseSite value : BASE_SITE_LIST) {
                ALL_SITE_MAP.put(value.getId() + "", value);
                ALL_SITE_MAP.put(value.getSiteName(), value);
            }
            BASE_SITE_LIST_Effective_Time = System.currentTimeMillis();
        }
    }

    private void initEnvQualityConf() {
        //初始化所有的质量类别集合(超过10秒才会更新)
        if (System.currentTimeMillis() - ENV_QUALITY_CONF_LIST_Effective_Time > 20000) {

            ENV_QUALITY_CONF_LIST = envQualityConfMapper.selectByExample(new EnvQualityConfExample());
            ENV_QUALITY_CONF_LIST_Effective_Time = System.currentTimeMillis();
        }
    }

    private void initBaseItem() {
        //初始化键值对集合，key值为itemName or itemId ，value 值为BaseItem(超过10秒才会更新)
        if (System.currentTimeMillis() - BASE_ITEM_MAP_Effective_Time > 30000) {

            List<BaseItem> baseItems = baseItemMapper.selectByExample(new BaseItemExample());
            BASE_ITEM_LIST = baseItems;
            for (BaseItem baseItem : baseItems) {
                BASE_ITEM_MAP.put(baseItem.getName(), baseItem);
                BASE_ITEM_MAP.put(baseItem.getId() + "", baseItem);
            }
            BASE_ITEM_MAP_Effective_Time = System.currentTimeMillis();
        }
    }

    //获取有效的站点集合
    public List<BaseSite> getBaseSiteList() {
        initSite();
        return BASE_SITE_LIST;
    }

    //获取站点map集合
    public Map<String, BaseSite> getAllSiteMap() {
        initSite();
        return ALL_SITE_MAP;
    }

    //获取所有的质量类别集合
    public List<EnvQualityConf> getEnvQualityConfList() {
        initEnvQualityConf();
        return ENV_QUALITY_CONF_LIST;
    }

    public BaseItem getBaseItemByItemNameOrItemId(String ItemNameOrItemId) {
        initBaseItem();
        return BASE_ITEM_MAP.get(ItemNameOrItemId);
    }

    public List<BaseItem> getBaseItemList() {
        initBaseItem();
        return BASE_ITEM_LIST;
    }



    private void initBaseSiteItemMap(Integer siteId) {
        if (System.currentTimeMillis() - BASE_SITE_ITEM_MAP_Effective_Time > 60000) {
            List<BaseSiteitemDTO> items = baseSiteitemMapper.getColumns(siteId);
            BASE_SITE_ITEM_MAP.put(siteId, items);
            BASE_SITE_ITEM_MAP_Effective_Time = System.currentTimeMillis();
        }
    }

    public List<BaseSiteitemDTO> getBaseSiteItemBySiteId(Integer siteId) {
        initBaseSiteItemMap(siteId);
        return BASE_SITE_ITEM_MAP.get(siteId);
    }

}
