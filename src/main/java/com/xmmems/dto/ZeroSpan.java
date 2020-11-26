package com.xmmems.dto;

import com.xmmems.common.utils.JsonUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2020.08.03 15:20
 */
@Data
public class ZeroSpan {

    private Integer id;
    private Integer siteId;
    private String siteName;
    private Date genTime;
    private Integer receiveId;
    private String content;
    private List<Specific> contentList = new ArrayList<>();

    public void addSpecific(Specific specific){
        this.contentList.add(specific);
    }

    public String getContent() {
        return JsonUtils.toString(this.contentList);
    }
}


