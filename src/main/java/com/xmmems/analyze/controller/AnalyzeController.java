package com.xmmems.analyze.controller;

import com.xmmems.analyze.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @描述 多元统计分析
 * @创建人 ithxw
 * @创建时间 2020.07.16 11:48
 */
@RestController
@RequestMapping("/analyze")
public class AnalyzeController {

    @Autowired
    private AnalyzeService analyzeService;
    @Autowired
    private PcaService pcaService;
    @Autowired
    private QualityAnalysisService qualityAnalysisService;

    /**
     * 基于一整年（按月分析）的一个站点的聚类分析（K-means）
     *
     * @param siteId 站点id
     * @param year   年
     * @param kernal 几个聚类核心
     * @return
     */
    @GetMapping("/analyzeKmeans")
    public Map<String, List<List<Double>>> analyzeKmeans(@RequestParam("siteId") Integer siteId,
                                                         @RequestParam("year") String year,
                                                         @RequestParam("kernal") Integer kernal) {
        return analyzeService.analyzeKmeans(siteId, year, kernal);
    }

    /**
     * 基于一整年（按站点分析）
     *
     * @param year
     * @param kernal
     * @return
     */
    @GetMapping("/analyzeKmeansForSite")
    public Map<String, List<List<Double>>> analyzeKmeansForSite(String year, Integer kernal) {
        return analyzeService.analyzeKmeansForSite(year, kernal);
    }

    /**
     * 基于月份每个站点的聚类预数据
     *
     * @param siteId  站点id
     * @param year    年份
     * @param itemIds 指标id集合
     * @return
     */
    @GetMapping("/clusterGroupByMonth")
    public Map<String, List<Object>> clusterGroupByMonth(@RequestParam("siteId") Integer siteId, @RequestParam("year") Integer year, @RequestParam("itemIds") List<Integer> itemIds) {
        return analyzeService.clusterGroupByMonth(siteId, year, itemIds, "聚类分析");
    }

    /**
     * 基于站点的每年的聚类预数据
     *
     * @param year    年份
     * @param itemIds 指标id集合
     * @return
     */
    @GetMapping("/clusterGroupBySite")
    public Map<String, List<Object>> clusterGroupBySite(@RequestParam("year") Integer year, @RequestParam("itemIds") List<Integer> itemIds) {
        return analyzeService.clusterGroupBySite(year, itemIds);
    }

    /**
     * 主成分分析
     *
     * @param year    年份
     * @param itemIds 指标id集合
     * @param siteIds 站点id集合
     * @param type    分析类型 ： 时间分析 空间分析
     * @return pca降维后的结果集合，可能是一维，二维，三维等数组结果
     */
    @GetMapping("/pca")
    public Object pca(@RequestParam("year") Integer year, @RequestParam("itemIds") List<Integer> itemIds, @RequestParam("siteIds") List<Integer> siteIds, @RequestParam("type") String type) {
        return pcaService.pca(year, itemIds, siteIds, type);
    }

    @Autowired
    private FactorService factorService;

    //因子分析
    @GetMapping("/factorCu")
    public Object factorCu(@RequestParam("siteId") Integer siteId, @RequestParam("year") Integer year, @RequestParam("itemIds") List<Integer> itemIds) {
        return factorService.factorCu(siteId, year, itemIds);
    }

    @Autowired
    private LinearRegressionService linearRegressionService;

    @GetMapping("/linearRegression")
    public Object linearRegression(@RequestParam("siteId") Integer siteId,
                                   @RequestParam("itemId") Integer itemId,
                                   @RequestParam("start") String start,
                                   @RequestParam("end") String end) {
        return linearRegressionService.linearRegression(siteId, start, end, itemId);
    }

    @GetMapping("/levelPercent")
    public Object levelPercent(@RequestParam("siteId") Integer siteId, @RequestParam("year") Integer year, @RequestParam("itemIds") List<Integer> itemIds) {
        return ResponseEntity.ok(qualityAnalysisService.levelPercent(year, siteId, itemIds));
    }

    @GetMapping("/mainTroubleList")
    public Object mainTroubleList(@RequestParam("siteId") Integer siteId, @RequestParam("year") Integer year, @RequestParam("itemIds") List<Integer> itemIds) {
        return ResponseEntity.ok(qualityAnalysisService.mainTroubleList(year, siteId, itemIds));
    }

}
