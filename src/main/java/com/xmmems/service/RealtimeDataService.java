package com.xmmems.service;

import cn.hutool.core.util.StrUtil;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.FormatNumberKit;
import com.xmmems.mapper.BaseItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class RealtimeDataService {

    private static Map<String, String> itemDigitsMap = new HashMap<>();
    private static long effectiveTime = 0;  //itemDigitsMap里面值的更新时间

    @Autowired
    private BaseItemMapper baseItemMapper;

    /**
     * 提前获取监测项目以及对应的保留小数位
     */
    private void getItemValueScale() {

        if (System.currentTimeMillis() - effectiveTime > 2000) {
            List<Map<String, Object>> list = baseItemMapper.selectNameAndDigits();

            list.forEach(itemDigit -> {
                String digits = "5";
                Object o = itemDigit.get("digits");
                if (o != null) {
                    digits = o.toString();
                }
                itemDigitsMap.put(itemDigit.get("name").toString().trim(), digits);
            });

            effectiveTime = System.currentTimeMillis();
        }

    }

    public String formatValue(String itemName, String itemValue) {
        getItemValueScale();
        if (StrUtil.isNotBlank(itemName) && itemName.contains("$$")) {
            itemName = StrUtil.subBefore(itemName, "$$", true);
            throw new XMException(500,"RealtimeDataService 50 行出错哦");
        }
        String digit = itemDigitsMap.get(itemName);
        return FormatNumberKit.format(itemValue, digit);
    }

    public String scale(String itemName, String value) {
        getItemValueScale();
        return FormatNumberKit.scale(value, itemDigitsMap.get(itemName));
    }

    public String scale(String itemName, BigDecimal bd) {
        getItemValueScale();
        return FormatNumberKit.scale(bd, itemDigitsMap.get(itemName));
    }
}
