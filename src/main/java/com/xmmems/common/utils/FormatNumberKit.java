package com.xmmems.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * 格式化数值
 */
public class FormatNumberKit {

    /**
     * @param value    实际值
     * @param digitStr 保留小数位 水站要求的是4舍6入5留双
     * @return
     */
    public static String format(String value, String digitStr) {

        if (StringUtils.isNotBlank(digitStr) && StringUtils.isNotBlank(value)) {
            value = getValInScience(value, Integer.valueOf(digitStr));
        }
        return value;
    }

    /**
     * 得到科学计数法中的数值
     *
     * @return
     */
    private static String getValInScience(String val, int digit) {
        try {
            return new BigDecimal(val).setScale(digit, BigDecimal.ROUND_HALF_EVEN).toPlainString();
        } catch (Exception ignore) {
            return "";
        }
    }

    /**
     * 银行家算法
     *
     * @param value 原始值
     * @param digit 保留小数位
     * @return 保留后的值
     */
    public static String scale(String value, String digit) {
        try {
            //if(digit==null||digit.trim().length()==0) digit = "5";
            return new BigDecimal(value.replace(",", "").trim()).setScale(Integer.valueOf(digit), BigDecimal.ROUND_HALF_EVEN).toPlainString();
        } catch (NumberFormatException e) {
            System.out.println("数据解析异常--->" + value);
            e.printStackTrace();
            return "";
        }
    }

    public static String scale(BigDecimal bd, String digit) {
        try {
            return bd.setScale(Integer.valueOf(digit), BigDecimal.ROUND_HALF_EVEN).toPlainString();
        } catch (NumberFormatException e) {
            System.out.println("数据解析异常--->" + bd.toPlainString());
            e.printStackTrace();
            return "";
        }
    }
}
