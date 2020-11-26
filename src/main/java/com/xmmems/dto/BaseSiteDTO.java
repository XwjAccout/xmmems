package com.xmmems.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BaseSiteDTO {
    private Integer id;

    private String siteName;

    private String operCompany;

    private String basinCode;

    private String basinName;

    private String riverCode;

    private String riverName;

    private String sectionCode;

    private String sectionName;

    private String provinceCode;

    private String provinceName;

    private String cityCode;

    private String cityName;

    private String countyCode;

    private String countyName;

    private String status;

    private String siteType;

    private String longitude;

    private String latitude;

    private String contactPerson;

    private String contactTels;

    private Date createStationDate;

    private String levelStandard;

    private String remark;

    private String isvalid;

    private String waterQualityLevel;

    private BigDecimal sort;

    //账户站点
    //private List<Integer> accountId;
    //
    //private Integer siteId;

}