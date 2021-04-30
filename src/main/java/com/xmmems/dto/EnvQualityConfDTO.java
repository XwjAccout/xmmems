package com.xmmems.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class EnvQualityConfDTO {
    private Integer itemId;

    private String itemName;
    //就是 kpiName

    private String level;

    private String minVal;

    private String maxVal;

    private Integer levelNum;

    //获取找最小值的BigDecimal对象
    public BigDecimal getMinValBigDecimal() {
        return new BigDecimal(this.minVal);
    }

    //获取找最大值的BigDecimal对象
    public BigDecimal getMaxValBigDecimal() {
        return new BigDecimal(this.maxVal);
    }

    //获取找最小值的Double对象
    public double getMinValDouble() {
        return Double.parseDouble(this.minVal);
    }

    public double getMaxValDouble() {
        return Double.parseDouble(this.maxVal);
    }

    /**
     * 是否属于当前级别
     *
     * @param bigDecimal 比较的值
     * @return true or false
     */
    public boolean compareTo(BigDecimal bigDecimal) {
        int b0 = bigDecimal.compareTo(new BigDecimal(this.maxVal));
        int b1 = bigDecimal.compareTo(new BigDecimal(this.minVal));
        boolean b = b1 > 0 && b0 <= 0;
        if (!b) {
            boolean b2 = "pH".equals(this.itemName);
            boolean b3 = "溶解氧".equals(this.itemName);
            if ("I".equals(this.level) && !b3 && !b2 && b1 == 0) {
                return true;
            } else {
                if ("劣V".equals(this.level) && (b3 || b2) && b1 == 0) {
                    return true;
                }
            }
        }
        return b;
    }
}
