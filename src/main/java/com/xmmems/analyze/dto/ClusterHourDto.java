package com.xmmems.analyze.dto;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;


/**
 * 聚类分析用的dto
 */
@Data
@ToString
public class ClusterHourDto implements Comparable<ClusterHourDto> {
    private String timeStr;
    //时间字符串  yyyy-MM-dd HH:mm:ss
    private Integer itemId;
    //指标id
    private String itemName;
    //指标名称
    private String value;
    //值
    private String troubleCode;
    //异常标识   N 正常

    @Override
    public int compareTo(ClusterHourDto o) {
        return this.getItemId().compareTo(o.getItemId());
    }

    public BigDecimal getValueBigDecimal(){
        return new BigDecimal(this.value);
    }
}
