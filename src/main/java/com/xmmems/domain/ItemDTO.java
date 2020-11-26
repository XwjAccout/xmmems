package com.xmmems.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)  //允许序列化时传递空字符串
public class ItemDTO {
    private String itemId;  //项目id
    private String itemName;  //项目名
    private String nowResult;  //测量结果
    private String lastResult;  //上一次测量结果
    private Integer solution;  //标液浓度
    private String error1;    //误差1
    private String error2;    //误差2
    private Integer span;    //跨度值
    private String qualified1;  //合格1
    private String qualified2;  //合格2
}
