package com.xmmems.analyze.controller;

import com.xmmems.analyze.service.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述  趋势分析
 * @创建人 ithxw
 * @创建时间 2020.09.10 11:05
 */
@RestController
@RequestMapping("/")
public class TrendController {
    @Autowired
    private TrendService trendService;

    /**
     *
     * @param siteId 站点id
     * @param itemId 指标id
     * @param start 开始时间
     * @param end 结束时间
     * @param space 当原始数据条数太多时，为了不影响计算，前端可指定间隔 space 条数据获取一条 ，举例子：总条数500，space = 5 ，则实际取得条数为 500/5 = 100
     * @return Mann-Kendall系数
     */
    //Mann-Kendall统计分析结果
    @GetMapping("/mannKendall")
    public Object mannKendall(@RequestParam("siteId") Integer siteId, @RequestParam("itemId") Integer itemId,
                              @RequestParam("start") String start, @RequestParam("end") String end, @RequestParam("space") Integer space) {
        return ResponseEntity.ok(trendService.mannKendall(siteId, itemId, start, end, space));
    }

    /**
     *
     * @param siteId 站点id
     * @param itemId 指标id
     * @param start 开始时间
     * @param end 结束时间
     * @param space 当原始数据条数太多时，为了不影响计算，前端可指定间隔 space 条数据获取一条 ，举例子：总条数500，space = 5 ，则实际取得条数为 500/5 = 100
     * @param compareItemId 用来跟 itemId 做比较的指标id -1代表时间，升序
     * @return spearman系数
     */
    @GetMapping("/spearman")
    public Object spearman(@RequestParam("siteId") Integer siteId, @RequestParam("itemId") Integer itemId,
                           @RequestParam("start") String start, @RequestParam("end") String end,
                           @RequestParam("space") Integer space,
                           @RequestParam(value = "compareItemId",defaultValue = "-1") Integer compareItemId){

        return ResponseEntity.ok(trendService.spearman(siteId, itemId, start, end, space));
    }
}

