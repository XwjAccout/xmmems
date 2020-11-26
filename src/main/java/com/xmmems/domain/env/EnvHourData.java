package com.xmmems.domain.env;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnvHourData {
    private Integer id;

    private Integer siteId;

    private String siteName;

    private Date genTime;

    private String handle;

    private String content;

}