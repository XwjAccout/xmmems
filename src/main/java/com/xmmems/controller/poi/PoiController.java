package com.xmmems.controller.poi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xmmems.common.exception.ExceptionResult;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.DateFormat;
import com.xmmems.common.utils.DownloadUtil;
import com.xmmems.domain.ExceedStandard;
import com.xmmems.dto.BaseSiteitemDTO;
import com.xmmems.dto.PageResult;
import com.xmmems.service.ExceedStandardService;
import com.xmmems.service.MonitorService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/poi")
public class PoiController {

    @Autowired
    private MonitorService monitorService;

    @Autowired
    private ExceedStandardService exceedStandardService;

    //    @Autowired
    //    private ExcelFileMapper excelFileMapper;

    @Value("${poipath.excel}")
    private String excelPath;

    /**
     * 四季报表
     */
    @RequestMapping("/printSeasonsExcel")
    public void printSeasonsExcel(
            @RequestParam(value = "siteId") Integer siteId,
            @RequestParam(value = "seasons") Integer seasons,
            @RequestParam(value = "year") Integer year,
            @RequestParam(value = "statistics", required = false) List<Integer> statistics,
            @RequestParam(value = "isDayAvg", defaultValue = "false") Boolean isDayAvg, HttpServletResponse response) {

        //第1步：导出第一行标题
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        List<BaseSiteitemDTO> columns = monitorService.getColumns(siteId);
        String siteName = columns.get(0).getSiteName();
        String fileName = siteName + "水质季报表(" + year + "年第" + seasons + "季度" + (isDayAvg ? "日均值报表)" : "月均值报表)");
        setAllTitle(siteId, workbook, sheet, fileName);

        List<Map<String, String>> mapList = monitorService.seasons(siteId, seasons, year, statistics, false, isDayAvg);
        setDataValue(workbook, sheet, (List)mapList, siteId);
        //第2步：  下载文件
        download(response, workbook, fileName);
    }

    private void setAllTitle(Integer siteId, Workbook workbook, Sheet sheet, String title) {
        List<BaseSiteitemDTO> list = monitorService.getColumns(siteId);
        Row row = setTitle(workbook, sheet, list, title);

        Stream<BaseSiteitemDTO> stream = list.stream();
        LinkedHashMap<String, String> collect = stream.collect(Collectors.toMap(BaseSiteitemDTO::getItemName, v -> v.getUnit() == null ? "" : "(" + v.getUnit() + ")", (t1, t2) -> t1, LinkedHashMap::new));
        Iterator<Map.Entry<String, String>> iterator = collect.entrySet().iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            Map.Entry<String, String> next = iterator.next();
            //第3-10列
            Cell cell = row.createCell(i + 1);
            cell.setCellValue(next.getKey() + next.getValue());
        }
    }

    private Row setTitle(Workbook workbook, Sheet sheet, List<BaseSiteitemDTO> list, String title) {
        //初始化样式
        initStyle(workbook);
        Row row;
        Cell cell;
        row = sheet.createRow(0);
        cell = row.createCell(0);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, list.size()));
        cell.setCellValue(title);
        cell.setCellStyle(getStyleStr("title"));

        row = sheet.createRow(1); // 创建第二行
        cell = row.createCell(0);
        cell.setCellValue("自动站名称： " + list.get(0).getSiteName());
        cell.setCellStyle(getStyleStr("title"));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 3));
        cell = row.createCell(4);

        sheet.addMergedRegion(new CellRangeAddress(1, 1, 4, list.size()));
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy.MM.dd");// 设置日期格式
        cell.setCellValue("上报时间：" + df1.format(System.currentTimeMillis()));
        cell.setCellStyle(getStyleStr("title"));

        row = sheet.createRow(2);
        cell = row.createCell(0);
        cell.setCellValue("监测时间");
        return row;
    }

    private static void initStyle(Workbook workbook) {
        CellStyle title = title(workbook);
        CellStyle textno = textno(workbook);
        CellStyle textBlue = textBlue(workbook);
        CellStyle textRed = textRed(workbook);
        Map<String, CellStyle> value = new HashMap<>(8);
        value.put("title", title);
        value.put("textno", textno);
        value.put("textBlue", textBlue);
        value.put("textRed", textRed);
        TL.set(value);
    }

    private static CellStyle getStyleStr(String str) {
        return TL.get().get(str);
    }

    /**
     * 月均值报表
     */
    @RequestMapping("/printYearExcel")
    public void printYearExcel(
            @RequestParam(value = "siteId") Integer siteId,
            @RequestParam(value = "startTime") String startTime,
            @RequestParam(value = "endTime") String endTime, @RequestParam(value = "statistics", required = false)
                    List<Integer> statistics, HttpServletResponse response) {

        List<BaseSiteitemDTO> columns = monitorService.getColumns(siteId);
        String siteName = columns.get(0).getSiteName();
        String fileName = siteName + "水质月均值报表(" + formatStrDate(startTime, endTime) + ")";

        //第1步：导出第一行标题
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        setAllTitle(siteId, workbook, sheet, fileName);

        List<Map<String, String>> mapList = monitorService.year(siteId, startTime, endTime, statistics, false);
        setDataValue(workbook, sheet, (List)mapList, siteId);
        //第2步：  下载文件
        download(response, workbook, fileName);

    }

    /**
     * 日均值报表
     */
    @RequestMapping("/printMonthExcel")
    public void printMonthExcel(
            @RequestParam(value = "siteId") Integer siteId,
            @RequestParam(value = "startTime") String startTime,
            @RequestParam(value = "endTime") String endTime, @RequestParam(value = "statistics", required = false)
                    List<Integer> statistics, HttpServletResponse response) {

        List<BaseSiteitemDTO> columns = monitorService.getColumns(siteId);
        String siteName = columns.get(0).getSiteName();
        String fileName = siteName + "水质日均值报表(" + formatStrDate(startTime, endTime) + ")";

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        setAllTitle(siteId, workbook, sheet, fileName);

        List<Map<String, String>> mapList = monitorService.month(siteId, startTime, endTime, statistics, false);
        setDataValue(workbook, sheet, (List)mapList, siteId);
        //日报表，月报表，年报表均完成，周报表因为比较少用，直接用日报表自行选择即可 admin 2020/6/19 16:58
        //第2步：  下载文件
        download(response, workbook, fileName);
    }

    /**
     * 时段报表
     */
    @RequestMapping("/printDayExcel")
    public void printDayExcel(
            @RequestParam(value = "siteId") Integer siteId,
            @RequestParam(value = "startTime") String startTime,
            @RequestParam(value = "endTime") String endTime,
            @RequestParam(value = "statistics", required = false) List<Integer> statistics,
            @RequestParam(value = "limit", defaultValue = "false") Boolean limit, HttpServletResponse response) {
        List<BaseSiteitemDTO> columns = monitorService.getColumns(siteId);
        String siteName = columns.get(0).getSiteName();
        String fileName = siteName + "水质时段报表(" + formatStrDate(startTime, endTime, true) + ")";

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        setAllTitle(siteId, workbook, sheet, fileName);

        List<Map<String, String>> day = monitorService.day(siteId, startTime, endTime, statistics, limit);
        setDataValue(workbook, sheet, (List)day, siteId);
        //第2步：  下载文件
        download(response, workbook, fileName);
    }

    /**
     * 周报表下载
     */
    @RequestMapping("/printWeekExcel")
    public void printWeekExcel(
            @RequestParam(value = "siteId") Integer siteId,
            @RequestParam(value = "week") Integer week,
            @RequestParam(value = "year") Integer year, @RequestParam(value = "statistics", required = false)
                    List<Integer> statistics, HttpServletResponse response) {

        List<BaseSiteitemDTO> columns = monitorService.getColumns(siteId);
        String siteName = columns.get(0).getSiteName();
        String fileName = siteName + "水质周报表(" + year + "年第" + week + "周)";

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        setAllTitle(siteId, workbook, sheet, fileName);

        List<Map<String, String>> mapList = monitorService.week(siteId, year, week, statistics, false);
        setDataValue(workbook, sheet, (List)mapList, siteId);

        //第2步：  下载文件
        download(response, workbook, fileName);
    }

    //月报表查询功能,其实就是获取某个月的日均值报表
    @GetMapping("/printRealMonthExcel")
    public void realMonth(
            @RequestParam(value = "siteId") Integer siteId,
            @RequestParam(value = "year") Integer year,
            @RequestParam(value = "month") Integer month, @RequestParam(value = "statistics", required = false)
                    List<Integer> statistics, HttpServletResponse response) {

        List<BaseSiteitemDTO> columns = monitorService.getColumns(siteId);
        String siteName = columns.get(0).getSiteName();
        String fileName = siteName + "水质月报表(" + year + "年第" + month + "月)";

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        setAllTitle(siteId, workbook, sheet, fileName);

        //第二行到 mapList.size()-1+2行：具体数据展示，导出数据行
        List<Map<String, String>> mapList = monitorService.realMonth(siteId, year, month, statistics, false);
        setDataValue(workbook, sheet, (List)mapList, siteId);

        //第2步：  下载文件
        download(response, workbook, fileName);
    }


    //年报表查询功能，其实就是获取某一年的月均值报表
    @GetMapping("/printRealYearExcel")
    public void realYear(
            @RequestParam(value = "siteId") Integer siteId,
            @RequestParam(value = "year") Integer year, @RequestParam(value = "statistics", required = false)
                    List<Integer> statistics, HttpServletResponse response) {

        List<BaseSiteitemDTO> columns = monitorService.getColumns(siteId);
        String siteName = columns.get(0).getSiteName();
        String fileName = siteName + "水质年报表(" + year + "年)";

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        setAllTitle(siteId, workbook, sheet, fileName);

        List<Map<String, String>> mapList = monitorService.realYear(siteId, year, statistics, false);
        setDataValue(workbook, sheet, (List)mapList, siteId);

        //第2步：  下载文件
        download(response, workbook, fileName);
    }

    //日报表查询功能，其实就是某一天的时段报表
    @GetMapping("/printRealDayExcel")
    public void realDay(
            @RequestParam(value = "siteId") Integer siteId,
            @RequestParam(value = "day") String day,
            @RequestParam(value = "statistics", required = false) List<Integer> statistics,
            @RequestParam(value = "limit", defaultValue = "false") Boolean limit, HttpServletResponse response) {

        List<BaseSiteitemDTO> columns = monitorService.getColumns(siteId);
        String siteName = columns.get(0).getSiteName();
        String fileName = siteName + "水质日报表(" + day.replaceFirst("-", "年").replace('-', '月') + "日)";

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        setAllTitle(siteId, workbook, sheet, fileName);

        //第二行到 mapList.size()-1+2行：具体数据展示，导出数据行
        List<Map<String, String>> mapList = monitorService.realDay(siteId, day, statistics, limit);
        setDataValue(workbook, sheet, (List)mapList, siteId);

        //第2步：  下载文件
        download(response, workbook, fileName);
    }

    /**
     * 设置表格主要内容
     */
    private void setDataValue(Workbook workbook, Sheet sheet, List<Map<String, Object>> mapList, Integer siteId) {
        //列名标题（对应key值）
        String moniterTime = "moniterTime";

        //第2列
        List<BaseSiteitemDTO> list = monitorService.getColumns(siteId);
        List<String> itemNames = list.stream().map(BaseSiteitemDTO::getItemName).collect(Collectors.toList());

        for (int i = 0; i < mapList.size(); i++) {
            int rowIndex = i + 3;
            Row row = sheet.createRow(rowIndex);

            Map<String, Object> map = mapList.get(i);

            String s2 = getValue(moniterTime, map);     //"moniterTime  监测时间";
            //第一列
            setCell(workbook, row, s2, 0);
            //setCell(workbook, row, s3, 2);
            if ("水质类别".equals(s2) || "主要污染物".equals(s2) || "平均数据捕捉率(%)".equals(s2) || "平均有效数据获取率(%)".equals(s2) || "平均故障率(%)".equals(s2) || "平均数据捕捉率".equals(s2) || "平均有效数据获取率".equals(s2) || "平均故障率".equals(s2)) {
                // 合并单元格
                sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 1, itemNames.size()));
                //continue;
            }
            //第三列
            for (int j = 0; j < itemNames.size(); j++) {
                //第2--列以上
                String itemName = itemNames.get(j);
                String value = getValue(itemName, map);
                setCell(workbook, row, value, j + 1);
            }
        }

        // 设置列宽
        setColumnWidth(sheet);
    }

    @Autowired
    private HttpServletRequest request;

    /**
     * 下载
     */
    private void download(HttpServletResponse response, Workbook workbook, String fileName) {
        DownloadUtil downloadUtil = new DownloadUtil();
        // excel文件流---->bos------>response
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            workbook.write(bos);
            downloadUtil.download(bos, response, fileName + ".xlsx", request);
            workbook.close();
        } catch (IOException e) {
            throw new XMException(500, e.getMessage());
        } finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        TL.remove();
    }


    /**
     * 设置列宽度
     */
    private void setColumnWidth(Sheet sheet) {

        for (int i = 0; i < 20; i++) {
            //设置宽度自适应
            sheet.autoSizeColumn(i, true);
        }
    }

    private String getValue(String key, Map<String, Object> map) {
        return map.get(key) == null ? "-" : map.get(key).toString();
    }

    //用来保存当前线程所生成的单元格样式对象
    private static ThreadLocal<Map<String, CellStyle>> TL = new ThreadLocal<>();

    /**
     * 设置单元格数据，样式
     *
     * @param row       哪一行
     * @param value     数据
     * @param cellIndex 单元格索引
     */
    private void setCell(Workbook workbook, Row row, String value, int cellIndex) {
        Cell cell = row.createCell(cellIndex);
        if (value.contains("$$")) {
            value = value.replace("$$", "");
            //设置警告红色字体
            cell.setCellStyle(getStyleStr("textRed"));
        } else {
            //正常数据
            if (row.getRowNum() % 2 == 0) {

                cell.setCellStyle(getStyleStr("textno"));
            } else {
                cell.setCellStyle(getStyleStr("textBlue"));
            }
        }
        cell.setCellValue(value);
    }


    //小标题的样式
    private static CellStyle title(Workbook wb) {
        //设置字体;
        Font font = wb.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());

        CellStyle style = getCellStyle(wb, "黑体", (short)12);
        style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());  //设置天空蓝填充前景颜色
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  //设置填充图案
        style.setFont(font);
        return style;
    }

    //正常文字样式 == 浅蓝色背景
    private static CellStyle textBlue(Workbook wb) {
        CellStyle style = getCellStyle(wb, "Times New Roman", (short)10);
        style.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());  //设置天空蓝填充前景颜色
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  //设置填充图案
        return style;
    }

    //正常文字样式 ==背景不设置
    private static CellStyle textno(Workbook wb) {
        return getCellStyle(wb, "Times New Roman", (short)10);
    }

    private static CellStyle getCellStyle(Workbook wb, String s, short i) {
        Font font = wb.createFont();
        font.setFontName(s);
        font.setFontHeightInPoints(i);

        CellStyle style = wb.createCellStyle();
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);                //横向居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);        //纵向居中
        return style;
    }

    //红色警告文字样式
    private static CellStyle textRed(Workbook wb) {

        Font font = wb.createFont();
        font.setColor(Font.COLOR_RED);
        font.setFontName("Times New Roman");
        font.setFontHeightInPoints((short)10);

        CellStyle style = wb.createCellStyle();
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);                //横向居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);        //纵向居中
        style.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());  //设置天空蓝填充前景颜色
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  //设置填充图案
        return style;
    }


    /**
     * 下载历史数据
     */
    @RequestMapping("/printHistory")
    public void printHistory(
            @RequestParam(value = "siteId") Integer siteId,
            @RequestParam(value = "startTime") String startTime,
            @RequestParam(value = "endTime") String endTime, HttpServletResponse response) {
        List<BaseSiteitemDTO> columns = monitorService.getColumns(siteId);
        String siteName = columns.get(0).getSiteName();
        String fileName = siteName + "水质历史报表(" + formatStrDate(startTime, endTime, true) + ")";

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        setAllTitle(siteId, workbook, sheet, fileName);

        PageResult<Map<String, Object>> pageResult = monitorService.getHistoryData(Integer.MAX_VALUE, 1, siteId, startTime, endTime, "ASC", false);
        List<Map<String, Object>> mapList = pageResult.getRows();

        setDataValue(workbook, sheet, mapList, siteId);

        //第2步：  下载文件
        download(response, workbook, fileName);

    }

    @RequestMapping("/printExceed")
    public void printExceed(
            @RequestParam(value = "start") String start,
            @RequestParam(value = "end") String end,
            @RequestParam(value = "siteId") String siteId, HttpServletResponse response) {

        List<ExceedStandard> exceedStandards = exceedStandardService.findByDateAndSiteName(start, end, siteId, false);
        if (exceedStandards.size() > 0) {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet();

            //第一行
            int rownum = 0;
            Row row = sheet.createRow(rownum);
            row.setRowStyle(getStyleStr("title"));
            Cell cell;
            //设置标题
            cell = row.createCell(0);
            cell.setCellValue("");
            cell = row.createCell(1);
            cell.setCellValue("监测时间");
            cell = row.createCell(2);
            cell.setCellValue("站点名称");
            cell = row.createCell(3);
            cell.setCellValue("监测因子");
            cell = row.createCell(4);
            cell.setCellValue("监测值");
            cell = row.createCell(5);
            cell.setCellValue("单位");
            cell = row.createCell(6);
            cell.setCellValue("标准限值");
            cell = row.createCell(7);
            cell.setCellValue("水质类别(超标倍数)");

            //设置主体内容数据
            for (int i = 0; i < exceedStandards.size(); i++) {
                row = sheet.createRow(i + rownum + 1);
                ExceedStandard exceedStandard = exceedStandards.get(i);
                setCell(workbook, row, i + 1 + "", 0);
                setCell(workbook, row, DateFormat.formatAll(exceedStandard.getDate()), 1);
                setCell(workbook, row, exceedStandard.getSiteName(), 2);
                setCell(workbook, row, exceedStandard.getItemName(), 3);
                setCell(workbook, row, exceedStandard.getItemValue(), 4);
                setCell(workbook, row, exceedStandard.getItemUnit(), 5);
                setCell(workbook, row, exceedStandard.getItemStandard(), 6);
                setCell(workbook, row, exceedStandard.getWaterType(), 7);
            }

            setColumnWidth(sheet);
            String siteName = exceedStandards.get(0).getSiteName();
            download(response, workbook, siteName + "水质超标情况统计(" + formatStrDate(start, end, true) + ")");

        } else {
            try {
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(500);
                PrintWriter out = response.getWriter();
                ExceptionResult result = new ExceptionResult(new XMException(500, "从" + start + "到" + end + "时间段内不存在超标情况。"));
                out.write(new ObjectMapper().writeValueAsString(result));
                out.flush();
                out.close();
            } catch (IOException e) {
                throw new XMException(500, e.getMessage());
            }
        }
    }

    //2020-01-01 转换为 2020年01月01日
    private static String formatStrDate(String str) {
        return str.replaceFirst("-", "年").replace('-', '月') + '日';
    }

    private static String formatStrDate(String s, String e) {
        return s.replaceFirst("-", "年").replace('-', '月') + "日至" + e.replaceFirst("-", "年").replace('-', '月') + '日';
    }

    private static String formatStrDate(String s, String e, boolean min) {
        String st = s.replaceFirst("-", "年").replaceFirst("-", "月").replace(' ', '日').replaceFirst(":", "时").replace(':', '分');
        //        + "秒至" +
        if (st.contains("分")) {
            st += "秒至";
        } else {
            st += "日至";
        }
        String et = e.replaceFirst("-", "年").replaceFirst("-", "月").replace(' ', '日').replaceFirst(":", "时").replace(':', '分');
        //        + '秒';
        if (et.contains("分")) {
            et += "秒";
        } else {
            et += "日";
        }

        return st + et;
    }
}
