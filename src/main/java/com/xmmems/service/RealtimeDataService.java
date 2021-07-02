package com.xmmems.service;

import cn.hutool.core.util.StrUtil;
import com.xmmems.common.exception.XMException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional(rollbackFor = Exception.class)
public class RealtimeDataService {

    @Autowired
    private CommonService commonService;

    public String formatValue(String itemName, String itemValue) {
        if (StringUtils.isBlank(itemName) || StringUtils.isBlank(itemValue)) {
            return "";
        }

        if (itemName.contains("$$")) {
            itemName = StrUtil.subBefore(itemName, "$$", true);
            throw new XMException(500, "RealtimeDataService 56 行出错哦");
        }

        Integer digits = commonService.getItemDigitsByItemNameOrItemId(itemName);
        //        List<Integer> digits = baseItemMapper.selectDigitByName(itemName);
        //        if (digits.size() > 0) {
        //            Integer i = digits.get(0);
        //            if (i != null) {
        //                return formatVal(itemValue, i.toString());
        //            }
        //        }

        return formatVal(itemValue, digits);
    }

    private static String formatVal(String value, int scale) {
        try {
            return new BigDecimal(value.replace(",", "").trim()).setScale(scale, BigDecimal.ROUND_HALF_EVEN).toPlainString();
        } catch (Exception e) {
            System.out.println("数据解析异常--->" + value);
            e.printStackTrace();
            return "";
        }
    }

    private static String formatVal(String value, String scale) {
        try {
            return new BigDecimal(value.replace(",", "").trim()).setScale(Integer.parseInt(scale), BigDecimal.ROUND_HALF_EVEN).toPlainString();
        } catch (Exception e) {
            System.out.println("数据解析异常--->" + value);
            e.printStackTrace();
            return "";
        }
    }

}
