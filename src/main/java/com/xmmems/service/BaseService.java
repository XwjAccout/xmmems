package com.xmmems.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.auth.domain.UserHolder;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.CustomUtils;
import com.xmmems.domain.base.*;
import com.xmmems.domain.env.EnvKpiType;
import com.xmmems.domain.env.EnvKpiTypeExample;
import com.xmmems.domain.env.EnvQualityConf;
import com.xmmems.domain.env.EnvQualityConfExample;
import com.xmmems.dto.BaseSiteitemDTO;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class BaseService {

    @Autowired
    private BaseSiteMapper baseSiteMapper;
    @Autowired
    private BaseAreaMapper baseAreaMapper;
    @Autowired
    private EnvKpiTypeMapper envKpiTypeMapper;
    @Autowired
    private BaseItemMapper baseItemMapper;
    @Autowired
    private EnvQualityConfMapper envQualityConfMapper;
    @Autowired
    private BaseSiteitemMapper baseSiteitemMapper;
    @Autowired
    private CommonService commonService;

    //分页查询
    public PageResult<BaseSite> sitePageQuery(Integer limit, Integer page, String siteName, String siteType) {

        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            List<BaseSite> baseSites = baseSiteMapper.selectByExampleByAccountId(UserHolder.loginId(), siteName, siteType);

            //得到pageHelper的分页对象
            PageInfo<BaseSite> pageInfo = new PageInfo<>(baseSites);
            //封装自定义的分页对象
            return new PageResult<>(pageInfo.getSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {

            throw new XMException(ExceptionEnum.BASESITE_NOT_FOUND);
        }
    }

    public PageResult<BaseArea> baseAreaPageQuery(Integer limit, Integer page, String areaName, String provinceCode) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            BaseAreaExample example = new BaseAreaExample();
            BaseAreaExample.Criteria criteria = example.createCriteria();


            if (!StringUtils.isBlank(provinceCode)) {
                criteria.andCodeLike(CustomUtils.likeRightValue(provinceCode));
            }
            if (!StringUtils.isBlank(areaName)) {
                criteria.andNameLike(CustomUtils.likeValue(areaName));
            }

            List<BaseArea> baseAreas = baseAreaMapper.selectByExample(example);
            //得到pageHelper的分页对象
            PageInfo<BaseArea> pageInfo = new PageInfo<>(baseAreas);
            //封装自定义的分页对象
            return new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.BASEAREA_NOT_FOUND);
        }
    }

    public PageResult<EnvKpiType> baseKpitypePageQuery(Integer limit, Integer page, String kpiTypeName) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            EnvKpiTypeExample example = new EnvKpiTypeExample();
            EnvKpiTypeExample.Criteria criteria = example.createCriteria();
            if (!StringUtils.isBlank(kpiTypeName)) {
                criteria.andNameLike(CustomUtils.likeValue(kpiTypeName));
            }
            List<EnvKpiType> envKpiTypes = envKpiTypeMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<EnvKpiType> pageInfo = new PageInfo<>(envKpiTypes);
            //封装自定义的分页对象
            return new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.ENVKPITYPE_NOT_FOUND);
        }
    }

    public PageResult<BaseItem> baseItemPageQuery(Integer limit, Integer page, String typeName, String itemName) {

        PageHelper.startPage(page, limit);
        //封装查询条件
        BaseItemExample example = new BaseItemExample();
        example.setOrderByClause("rank asc");
        BaseItemExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isBlank(typeName)) {
            criteria.andTypeNameLike(CustomUtils.likeValue(typeName));
        }
        if (!StringUtils.isBlank(itemName)) {
            criteria.andNameLike(CustomUtils.likeValue(itemName));
        }
        List<BaseItem> baseItems = baseItemMapper.selectByExample(example);

        //得到pageHelper的分页对象
        PageInfo<BaseItem> pageInfo = new PageInfo<>(baseItems);
        //封装自定义的分页对象
        return new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
    }

    public PageResult<EnvQualityConf> baseQualityconfPageQuery(Integer limit, Integer page, String kpiName) {
        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            EnvQualityConfExample example = new EnvQualityConfExample();
            EnvQualityConfExample.Criteria criteria = example.createCriteria();
            if (!StringUtils.isBlank(kpiName)) {
                criteria.andKpiNameLike(CustomUtils.likeValue(kpiName));
            }
            List<EnvQualityConf> envQualityConfs = envQualityConfMapper.selectByExample(example);

            //得到pageHelper的分页对象
            PageInfo<EnvQualityConf> pageInfo = new PageInfo<>(envQualityConfs);
            //封装自定义的分页对象
            return new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.ENVQUALITYCONF_NOT_FOUND);
        }
    }

    //添加数据
    public void siteSave(BaseSite baseSite) {
        baseSite.setIsvalid("1");
        try {
            baseSiteMapper.insertSelective(baseSite);
            commonService.initBaseSite();
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.INSERT_ERROR);
        }
    }

    public void baseKpitypeSave(EnvKpiType envKpiType) {
        int i = envKpiTypeMapper.insertSelective(envKpiType);
        if (i < 1) {
            throw new XMException(ExceptionEnum.INSERT_ERROR);
        }
    }

    public void baseItemSave(BaseItem baseItem) {
        try {
            baseItemMapper.insertSelective(baseItem);
            commonService.initBaseItem();
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.INSERT_ERROR);
        }
    }

    public void baseQualityconfSave(EnvQualityConf envQualityConf) {
        try {
            envQualityConfMapper.insertSelective(envQualityConf);
            commonService.initEnvQualityConf();
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.INSERT_ERROR);
        }
    }

    //根据id查询数据
    public BaseSite siteFindById(Integer id) {
        BaseSite baseSite = baseSiteMapper.selectByPrimaryKey(id);
        if (baseSite == null) {
            throw new XMException(ExceptionEnum.BASESITE_NOT_FOUND);
        }
        return baseSite;
    }

    public BaseItem baseItemFindById(Integer id) {
        BaseItem baseItem = baseItemMapper.selectByPrimaryKey(id);
        if (baseItem == null) {
            throw new XMException(ExceptionEnum.BASEITEM_NOT_FOUND);
        }
        return baseItem;
    }

    public EnvKpiType baseKpitypeFindById(Integer id) {
        EnvKpiType envKpiType = envKpiTypeMapper.selectByPrimaryKey(id);
        if (envKpiType == null) {
            throw new XMException(ExceptionEnum.ENVKPITYPE_NOT_FOUND);
        }
        return envKpiType;
    }

    public EnvQualityConf baseQualityconfFindById(Integer id) {
        EnvQualityConf envQualityConf = envQualityConfMapper.selectByPrimaryKey(id);
        if (envQualityConf == null) {
            throw new XMException(ExceptionEnum.ENVQUALITYCONF_NOT_FOUND);
        }
        return envQualityConf;
    }

    public BaseArea baseAreaFindById(Integer id) {
        return baseAreaMapper.selectByPrimaryKey(Long.valueOf(id));
    }

    //根据id更新数据
    public void siteUpdate(BaseSite baseSite) {
        try {
            baseSiteMapper.updateByPrimaryKeySelective(baseSite);
            commonService.initBaseSite();
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.UPDATE_ERROR);
        }
    }

    public void baseAreaUpdate(BaseArea baseSite) {
        int i = baseAreaMapper.updateByPrimaryKeySelective(baseSite);
        if (i < 1) {
            throw new XMException(ExceptionEnum.UPDATE_ERROR);
        }
    }

    public void baseItemUpdate(BaseItem baseSite) {
        try {
            baseItemMapper.updateByPrimaryKeySelective(baseSite);
            commonService.initBaseItem();
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.UPDATE_ERROR);
        }
    }

    public void baseKpitypeUpdate(EnvKpiType envKpiType) {
        try {
            envKpiTypeMapper.updateByPrimaryKeySelective(envKpiType);
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.UPDATE_ERROR);
        }
    }

    public void baseQualityconfUpdate(EnvQualityConf envQualityConf) {
        try {
            envQualityConfMapper.updateByPrimaryKeySelective(envQualityConf);
            commonService.initEnvQualityConf();
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.UPDATE_ERROR);
        }
    }

    //根据id删除数据
    public void siteDelete(Integer id) {
        try {
            baseSiteMapper.deleteByPrimaryKey(id);
            commonService.initBaseSite();
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.DELETE_ERROR);
        }

    }

    public void baseAreaDelete(Integer id) {
        int i = baseAreaMapper.deleteByPrimaryKey(Long.valueOf(id));
        if (i < 1) {
            throw new XMException(ExceptionEnum.DELETE_ERROR);
        }
    }

    public void baseItemDelete(Integer id) {
        try {
            baseItemMapper.deleteByPrimaryKey(id);
            commonService.initBaseItem();
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.DELETE_ERROR);
        }
    }

    public void baseKpitypeDelete(Integer id) {
        try {
            envKpiTypeMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.DELETE_ERROR);
        }
    }

    public void baseQualityconfDelete(Integer id) {
        try {
            envQualityConfMapper.deleteByPrimaryKey(id);
            commonService.initEnvQualityConf();
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.DELETE_ERROR);
        }
    }

    //查询站点site 与 监测项目item 的中间表数据
    public List<BaseSiteitemDTO> siteItemGetItemsBySiteId(Integer siteId) {
        return commonService.getBaseSiteItemBySiteId(siteId);
//        return baseSiteitemMapper.siteItemGetItemsBySiteId(siteId);
    }

    public List<Map<String, String>> findAll(String siteType) {
        List<BaseSite> baseSites = commonService.getBaseSiteList();
        if (CollectionUtils.isEmpty(baseSites)) {
            return new ArrayList<>();
        }
        List<Map<String, String>> mapList = new ArrayList<>();
        //转换为map减少数据传输量
        for (BaseSite baseSite : baseSites) {
            if (siteType != null && !siteType.equals(baseSite.getSiteType())) {
                continue;
            }
            Map<String, String> map = new HashMap<>(8);
            map.put("id", baseSite.getId() + "");
            map.put("siteName", baseSite.getSiteName());
            map.put("mn", baseSite.getMN());
            mapList.add(map);
        }
        return mapList;
    }

    public List<Map<String, Object>> findBaseSiteByAccountId(String siteType) {
        return baseSiteMapper.getSiteIdAndNameByAccountId(UserHolder.loginId(), siteType);
    }

    public List<Map<String, Object>> findAccountId(Integer id, String siteType) {
        return baseSiteMapper.getSiteIdAndNameByAccountId(id, siteType);
    }

    public List<BaseSiteitem> getSiteItem(Integer siteId) {
        return baseSiteitemMapper.getSiteItem(siteId);
    }

    public Integer updateBybaseSiteitem(Integer upAndDown, Integer siteId, Integer id) {

        int result = 0;
        //查询当前
        BaseSiteitem baseSiteitem = baseSiteitemMapper.selectByPrimaryKey(id);
        if (upAndDown == 0) {
            //获取上一个
            BaseSiteitem baseSit = null;
            if (baseSiteitem.getSort().intValue() == 1) {
                baseSit = baseSiteitemMapper.getSiteItemsort(baseSiteitem.getSiteId(), baseSiteitem.getSort().intValue());
            } else {
                baseSit = baseSiteitemMapper.getSiteItemsort(baseSiteitem.getSiteId(), baseSiteitem.getSort().intValue() - 1);
            }
            if (baseSit != null) {
                //更新 当前要改的
                BaseSiteitem baseSiteitemup1 = new BaseSiteitem();
                baseSiteitemup1.setSort(baseSit.getSort());
                baseSiteitemup1.setId(id);
                result = baseSiteitemMapper.updateByPrimaryKeySelective(baseSiteitemup1);
                //更新 上一个要改的
                BaseSiteitem baseSiteitemup2 = new BaseSiteitem();
                baseSiteitemup2.setSort(baseSiteitem.getSort());
                baseSiteitemup2.setId(baseSit.getId());

                result = baseSiteitemMapper.updateByPrimaryKeySelective(baseSiteitemup2);

                commonService.initBaseSiteItemMap(siteId);
            } else {
                throw new XMException(ExceptionEnum.ERROR1);
            }

        } else if (upAndDown == 1) {
            //获取下一个
            BaseSiteitem baseSitDown = baseSiteitemMapper.getSiteItemsort(baseSiteitem.getSiteId(), baseSiteitem.getSort().intValue() + 1);
            //更新 当前要改的
            BaseSiteitem baseSiteitemupDown1 = new BaseSiteitem();
            baseSiteitemupDown1.setSort(baseSitDown.getSort());
            baseSiteitemupDown1.setId(id);
            result = baseSiteitemMapper.updateByPrimaryKeySelective(baseSiteitemupDown1);

            //更新 下一个要改的
            BaseSiteitem baseSiteitemupDown2 = new BaseSiteitem();
            baseSiteitemupDown2.setSort(baseSiteitem.getSort());
            baseSiteitemupDown2.setId(baseSitDown.getId());
            result = baseSiteitemMapper.updateByPrimaryKeySelective(baseSiteitemupDown2);

            commonService.initBaseSiteItemMap(siteId);
        }
        return result;
    }

    public List<Map<String, Object>> findAllByOften(String often) {
        return baseItemMapper.findAllByOftaa(often);
    }

    public void addItem(Integer siteId, String siteName, Integer itemId, String itemName) {
        try {
            baseSiteitemMapper.insertBaseSiteItem(siteId, itemId, siteName, itemName);
            commonService.initBaseSiteItemMap(siteId);
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.INSERT_ERROR);
        }
    }

    public void delItem(Integer siteId, Integer itemId) {
        try {
            baseSiteitemMapper.delItem(siteId, itemId);
            commonService.initBaseSiteItemMap(siteId);
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.DELETE_ERROR);
        }

    }

    public List<Map<String, Object>> getSiteIdAndNameExcludeZeroCheck() {
        return baseSiteMapper.getSiteIdAndNameExcludeZeroCheck(UserHolder.loginId());
    }

    public void updateDetectionLimit(Integer siteId, Integer itemId, String limit) {
        try {
            baseSiteitemMapper.updateDetectionLimit(siteId, itemId, limit);
            commonService.initBaseSiteItemMap(siteId);
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.UPDATE_ERROR);
        }
    }

    public void updateSort(Integer siteId, Integer itemId, Double sort) {
        try {
            baseSiteitemMapper.updateSort(siteId, itemId, sort);
            commonService.initBaseSiteItemMap(siteId);
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.UPDATE_ERROR);
        }
    }

    public void updateNumber(Integer siteId, Integer itemId, Integer number) {
        try {
            baseSiteitemMapper.updateNumber(siteId, itemId, number);
            commonService.initBaseSiteItemMap(siteId);
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.UPDATE_ERROR);
        }
    }

    public List<BaseSiteitem> selectBysite() {
        return baseSiteitemMapper.selectBysite();
    }

    public ArrayList<Object> siteSort(String siteType) {
        Integer userId = UserHolder.loginId();
        List<Map<String, Object>> datas = baseSiteMapper.getSiteIdAndNameByAccountId(userId, siteType);

        Map<String, List<Map<String, Object>>> map = new HashMap<>();

        //分类
        for (Map<String, Object> data : datas) {
            String cityName = (String)data.get("cityName");
            List<Map<String, Object>> list = map.get(cityName);
            if (list == null) {
                list = new ArrayList<>();
                map.put(cityName, list);
            }
            data.put("name", data.get("siteName"));
            data.remove("cityName");
            data.remove("siteName");

            list.add(data);
        }
        //计算个数


        //转换为父子结构集合
        Map<String, Object> map1 = new HashMap<>();

        map1.put("name", "地区");
        List<Object> tt = new ArrayList<>();
        map1.put("menu", tt);
        for (Map.Entry<String, List<Map<String, Object>>> entry : map.entrySet()) {

            Map<String, Object> map2 = new HashMap<>();
            List<Map<String, Object>> siteList = entry.getValue();
            map2.put("name", entry.getKey() + " (" + siteList.size() + '/' + siteList.size() + ')');
            map2.put("menu", siteList);

            tt.add(map2);
        }

        ArrayList<Object> objects = new ArrayList<>();
        objects.add(map1);
        return objects;

    }
}
