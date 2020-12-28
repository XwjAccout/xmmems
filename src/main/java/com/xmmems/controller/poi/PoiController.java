package com.xmmems.controller.poi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xmmems.common.exception.ExceptionResult;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.DateFormat;
import com.xmmems.common.utils.DownloadUtil;
import com.xmmems.domain.ExceedStandard;
import com.xmmems.domain.ExcelFile;
import com.xmmems.dto.BaseSiteitemDTO;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.ExcelFileMapper;
import com.xmmems.operationlog.annotation.SystemControllerLog;
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

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/poi")
public class PoiController {

    @Autowired
    private MonitorService monitorService;

    @Autowired
    private ExceedStandardService exceedStandardService;

    @Autowired
    private ExcelFileMapper excelFileMapper;

    @Value("${poipath.excel}")
    private String excelPath;

    /**
     * 四季报表
     */
    @RequestMapping("/printSeasonsExcel")
    public void printSeasonsExcel(@RequestParam(value = "siteId") Integer siteId,
                                  @RequestParam(value = "seasons") Integer seasons,
                                  @RequestParam(value = "year") Integer year,
                                  @RequestParam(value = "statistics", required = false) List<Integer> statistics,
                                  @RequestParam(value = "isdisk", defaultValue = "true") Boolean isdisk,
                                  @RequestParam(value = "isDayAvg", defaultValue = "false") Boolean isDayAvg,
                                  HttpServletResponse response, @RequestParam(value = "limit", defaultValue = "true") Boolean limit) {
        //优先磁盘获取
        String anObject = year + "-" + seasons;
        String yyyyStr = DateFormat.format(DateFormat.yyyy, new Date());
        String mmstr = DateFormat.format(DateFormat.MM, new Date());
        int mmi = Integer.parseInt(mmstr);
        String nowseasons = null;
        switch (mmi) {
            case 1:
            case 2:
            case 3:
                nowseasons = yyyyStr + "-1";
                break;
            case 4:
            case 5:
            case 6:
                nowseasons = yyyyStr + "-2";
                break;
            case 7:
            case 8:
            case 9:
                nowseasons = yyyyStr + "-3";
                break;
            case 10:
            case 11:
            case 12:
                nowseasons = yyyyStr + "-4";
                break;
        }

        String type = "seasons" + (isDayAvg ? "日均值" : "月均值");
        if (isdisk && !anObject.equals(nowseasons)) {
            if (getFileFromDisk(siteId, response, anObject, type)) {return;}
        }
        //第1步：导出第一行标题
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        setAllTitle(siteId, workbook, sheet, "地表水环境质量数据季报表");

        List<Map<String, String>> mapList = monitorService.seasons(siteId, seasons, year, statistics, limit, isDayAvg);
        setDataValue(workbook, sheet, (List) mapList, siteId);
        List<BaseSiteitemDTO> columns = monitorService.getColumns(siteId);
        String siteName = columns.get(0).getSiteName();
        String returnName = siteName + "-" + anObject + "季" + (isDayAvg ? "日均值" : "月均值") + "报表.xlsx";
        insertToDBandDisk(siteId, anObject, workbook, returnName, type);
        //第2步：  下载文件
        download(response, workbook, returnName);
    }

    private void insertToDBandDisk(Integer siteId, String timeStr, Workbook workbook, String returnName, String type) {
        File file = new File(excelPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String url = file.getAbsolutePath() + "/" + returnName;
        try (FileOutputStream fileOutputStream = new FileOutputStream(url)) {
            //保存文件到磁盘
            workbook.write(fileOutputStream);

            ExcelFile record = new ExcelFile();
            record.setTimeStr(timeStr);
            record.setSiteId(siteId);
            record.setType(type);
            record.setExcelUrl(url);

            try {
                excelFileMapper.insert(record);
            } catch (Exception e) {
                excelFileMapper.updateByPrimaryKey(record);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new XMException(500, "保存到硬盘失败");
        }
    }

    private void setAllTitle(Integer siteId, Workbook workbook, Sheet sheet, String title) {
        List<BaseSiteitemDTO> list = monitorService.getColumns(siteId);
        Row row = setTitle(workbook, sheet, list, title);
        List<String> itemNames = list.stream().map(BaseSiteitemDTO::getItemName).collect(Collectors.toList());
        List<String> units = list.stream().map(BaseSiteitemDTO::getUnit).collect(Collectors.toList());
        Cell cell = null;
        for (int i = 0; i < itemNames.size(); i++) {
            //第3-10列

            cell = row.createCell(i + 1);
            cell.setCellValue(itemNames.get(i) + (units.get(i) == null ? "" : ("(" + units.get(i) + ")")));
            // cell.setCellStyle(this.title(workbook));
        }
    }

    private Row setTitle(Workbook workbook, Sheet sheet, List<BaseSiteitemDTO> list, String title) {
        Row row;
        Cell cell;
        row = sheet.createRow(0);
        cell = row.createCell(0);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, list.size()));
        cell.setCellValue(title);
        cell.setCellStyle(this.title(workbook));

        row = sheet.createRow(1); // 创建第二行
        cell = row.createCell(0);
        cell.setCellValue("自动站名称： " + list.get(0).getSiteName());
        cell.setCellStyle(this.title(workbook));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 3));
        cell = row.createCell(4);

        //cell.setCellValue("*****");
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 4, list.size()));
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy.MM.dd");// 设置日期格式
        cell.setCellValue("上报时间：" + df1.format(new Date()));
        cell.setCellStyle(this.title(workbook));
        row = sheet.createRow(2);
        cell = row.createCell(0);
        cell.setCellValue("监测时间");
        return row;
    }

    /**
     * 年报表
     */
    @RequestMapping("/printYearExcel")
    public void printYearExcel(@RequestParam(value = "siteId") Integer siteId,
                               @RequestParam(value = "startTime") String startTime,
                               @RequestParam(value = "endTime") String endTime,
                               @RequestParam(value = "statistics", required = false) List<Integer> statistics,
                               HttpServletResponse response
            , @RequestParam(value = "limit", defaultValue = "true") Boolean limit) {
        //第1步：导出第一行标题
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        setAllTitle(siteId, workbook, sheet, "地表水环境质量数据月均值报表");

        List<Map<String, String>> mapList = monitorService.year(siteId, startTime, endTime, statistics, limit);
        setDataValue(workbook, sheet, (List) mapList, siteId);
        //第2步：  下载文件
        download(response, workbook, "月均值报表.xlsx");

    }

    /**
     * 月报表
     */
    @RequestMapping("/printMonthExcel")
    public void printMonthExcel(@RequestParam(value = "siteId") Integer siteId,
                                @RequestParam(value = "startTime") String startTime,
                                @RequestParam(value = "endTime") String endTime,
                                @RequestParam(value = "statistics", required = false) List<Integer> statistics,
                                HttpServletResponse response,
                                @RequestParam(value = "limit", defaultValue = "true") Boolean limit) {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        setAllTitle(siteId, workbook, sheet, "地表水环境质量数据月日均值报表");

        List<Map<String, String>> mapList = monitorService.month(siteId, startTime, endTime, statistics, limit);
        setDataValue(workbook, sheet, (List) mapList, siteId);
        //日报表，月报表，年报表均完成，周报表因为比较少用，直接用日报表自行选择即可 admin 2020/6/19 16:58
        //第2步：  下载文件
        download(response, workbook, "日均值报表.xlsx");

    }

    /**
     * 日报表
     */
    @RequestMapping("/printDayExcel")
    public void printDayExcel(@RequestParam(value = "siteId") Integer siteId,
                              @RequestParam(value = "startTime") String startTime,
                              @RequestParam(value = "endTime") String endTime,
                              @RequestParam(value = "statistics", required = false) List<Integer> statistics,
                              @RequestParam(value = "limit", defaultValue = "true") Boolean limit,
                              HttpServletResponse response) {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        setAllTitle(siteId, workbook, sheet, "地表水环境质量数据时段报表");

        List<Map<String, String>> day = monitorService.day(siteId, startTime, endTime, statistics, limit);
        setDataValue(workbook, sheet, (List) day, siteId);
        //第2步：  下载文件
        download(response, workbook, "时段报表.xlsx");

    }

    /**
     * 周报表下载
     */
    @RequestMapping("/printWeekExcel")
    public void printWeekExcel(@RequestParam(value = "siteId") Integer siteId,
                               @RequestParam(value = "week") Integer week,
                               @RequestParam(value = "year") Integer year,
                               @RequestParam(value = "statistics", required = false) List<Integer> statistics,
                               @RequestParam(value = "isdisk", defaultValue = "true") Boolean isdisk,
                               @RequestParam(value = "limit", defaultValue = "true") Boolean limit, HttpServletResponse response) {
        //优先磁盘获取
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-ww");
        String anObject = year + "-" + week;
        String type = "week";
        if (isdisk && !sdf.format(System.currentTimeMillis()).equals(anObject)) {

            if (getFileFromDisk(siteId, response, anObject, type)) return;
        }
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        setAllTitle(siteId, workbook, sheet, "地表水环境质量数据周报表");

        List<Map<String, String>> week1 = monitorService.week(siteId, year, week, statistics, limit);
        setDataValue(workbook, sheet, (List) week1, siteId);

        List<BaseSiteitemDTO> columns = monitorService.getColumns(siteId);
        String siteName = columns.get(0).getSiteName();
        String returnName = siteName + "-" + year + "年第" + week + "周报表.xlsx";
        insertToDBandDisk(siteId, anObject, workbook, returnName, type);
        //第2步：  下载文件
        download(response, workbook, returnName);
    }

    //月报表查询功能,其实就是获取某个月的日均值报表
    @GetMapping("/printRealMonthExcel")
    public void realMonth(@RequestParam(value = "siteId") Integer siteId,
                          @RequestParam(value = "year") Integer year,
                          @RequestParam(value = "month") Integer month,
                          @RequestParam(value = "statistics", required = false) List<Integer> statistics,
                          @RequestParam(value = "limit", defaultValue = "true") Boolean limit,
                          @RequestParam(value = "isdisk", defaultValue = "true") Boolean isdisk,
                          HttpServletResponse response) {
        //优先磁盘获取
        String anObject = year + "-" + month;
        String type = "month";
        if (isdisk && !DateFormat.format(DateFormat.yyyy_MM, new Date()).equals(anObject)) {

            if (getFileFromDisk(siteId, response, anObject, type)) return;
        }

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        setAllTitle(siteId, workbook, sheet, "地表水环境质量数据月报表");

        //第二行到 mapList.size()-1+2行：具体数据展示，导出数据行
        List<Map<String, String>> week1 = monitorService.realMonth(siteId, year, month, statistics, limit);
        setDataValue(workbook, sheet, (List) week1, siteId);

        List<BaseSiteitemDTO> columns = monitorService.getColumns(siteId);
        String siteName = columns.get(0).getSiteName();
        String returnName = siteName + "-" + year + "年第" + month + "月报表.xlsx";

        insertToDBandDisk(siteId, anObject, workbook, returnName, type);

        //第2步：  下载文件
        download(response, workbook, returnName);
    }


    //年报表查询功能，其实就是获取某一年的月均值报表
    @GetMapping("/printRealYearExcel")
    public void realYear(@RequestParam(value = "siteId") Integer siteId,
                         @RequestParam(value = "year") Integer year,
                         @RequestParam(value = "statistics", required = false) List<Integer> statistics,
                         @RequestParam(value = "limit", defaultValue = "true") Boolean limit,
                         @RequestParam(value = "isdisk", defaultValue = "true") Boolean isdisk,
                         HttpServletResponse response) {
        //优先磁盘获取
        String anObject = year + "";
        String type = "year";
        if (isdisk && !DateFormat.format(DateFormat.yyyy, new Date()).equals(anObject)) {

            if (getFileFromDisk(siteId, response, anObject, type)) return;
        }

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        setAllTitle(siteId, workbook, sheet, "地表水环境质量数据年报表");

        List<Map<String, String>> week1 = monitorService.realYear(siteId, year, statistics, limit);
        setDataValue(workbook, sheet, (List) week1, siteId);

        List<BaseSiteitemDTO> columns = monitorService.getColumns(siteId);
        String siteName = columns.get(0).getSiteName();
        String returnName = siteName + "-" + year + "年报表.xlsx";

        insertToDBandDisk(siteId, anObject, workbook, returnName, type);

        //第2步：  下载文件
        download(response, workbook, returnName);
    }

    private boolean getFileFromDisk(Integer siteId, HttpServletResponse response, String timeStr, String type) {
        ExcelFile oldExcel = new ExcelFile();
        oldExcel.setTimeStr(timeStr);
        oldExcel.setSiteId(siteId);
        oldExcel.setType(type);

        ExcelFile select = excelFileMapper.selectOne(oldExcel);
        if (select != null) {
            try {
                String excelUrl = select.getExcelUrl();
                File file = new File(excelUrl);
                if (file.isFile()) {

                    Workbook wb = WorkbookFactory.create(file); //拿到文件
                    if (wb != null) {
                        download(response, wb, file.getName());
                        wb.close();
                        return true;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //日报表查询功能，其实就是某一天的时段报表
    @GetMapping("/printRealDayExcel")
    public void realDay(@RequestParam(value = "siteId") Integer siteId,
                        @RequestParam(value = "day") String day,
                        @RequestParam(value = "statistics", required = false) List<Integer> statistics,
                        @RequestParam(value = "limit", defaultValue = "true") Boolean limit,
                        @RequestParam(value = "isdisk", defaultValue = "true") Boolean isdisk,
                        HttpServletResponse response) {
        //优先磁盘获取
        String type = "day";
        if (isdisk && !DateFormat.formatSome(System.currentTimeMillis()).equals(day)) {

            if (getFileFromDisk(siteId, response, day, type)) return;
        }

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        setAllTitle(siteId, workbook, sheet, "地表水环境质量数据日报表");

        //第二行到 mapList.size()-1+2行：具体数据展示，导出数据行
        List<Map<String, String>> week1 = monitorService.realDay(siteId, day, statistics, limit);
        setDataValue(workbook, sheet, (List) week1, siteId);

        List<BaseSiteitemDTO> columns = monitorService.getColumns(siteId);
        String siteName = columns.get(0).getSiteName();
        String returnName = siteName + "-" + day + "日报表.xlsx";

        insertToDBandDisk(siteId, day, workbook, returnName, type);

        //第2步：  下载文件
        download(response, workbook, returnName);
    }

    /**
     * 设置表格主要内容
     */
    private void setDataValue(Workbook workbook, Sheet sheet, List<Map<String, Object>> mapList, Integer siteId) {
        //列名标题（对应key值）
        String key2 = "moniterTime";

        //第三列
        List<BaseSiteitemDTO> list = monitorService.getColumns(siteId);
        List<String> itemNames = list.stream().map(BaseSiteitemDTO::getItemName).collect(Collectors.toList());

        Row row = null;
        for (int i = 0; i < mapList.size(); i++) {
            int rowIndex = i + 3;
            row = sheet.createRow(rowIndex);

            Map<String, Object> map = mapList.get(i);

            String s2 = getValue(key2, map);     //"moniterTime  监测时间";
            setCell(workbook, row, s2, 0);
            //setCell(workbook, row, s3, 2);
            if ("水质类别".equals(s2) || "主要污染物".equals(s2) || "平均数据捕捉率(%)".equals(s2) || "平均有效数据获取率(%)".equals(s2) || "平均故障率(%)".equals(s2)
                    || "平均数据捕捉率".equals(s2) || "平均有效数据获取率".equals(s2) || "平均故障率".equals(s2)) {
                // 合并单元格
                sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 1, itemNames.size()));
                //continue;
            }
            //第三列
            for (int j = 0; j < itemNames.size(); j++) {
                //第3-10列
                String itemName = itemNames.get(j);
                String value = getValue(itemName, map);
                setCell(workbook, row, value, j + 1);
            }
        }

        // 设置列宽
        setColumnWidth(sheet);
    }

    /**
     * 下载
     */
    private void download(HttpServletResponse response, Workbook workbook, String returnName) {
        DownloadUtil downloadUtil = new DownloadUtil();
        // excel文件流---->bos------>response
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            workbook.write(bos);
            downloadUtil.download(bos, response, returnName);
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
    }

    /**
     * 设置标题
     */
    private void setTitleValue(Integer siteId, Workbook workbook, Sheet sheet) {

        //第一行
        Row row = sheet.createRow(0);
        Cell cell;
        //第一列,不设置任何东西
        cell = row.createCell(0);
        cell.setCellValue("");
        cell.setCellStyle(title(workbook));
        //第二列
        cell = row.createCell(1);
        cell.setCellValue("监测时间");
        // cell.setCellStyle(this.title(workbook));

        //第三列
        List<BaseSiteitemDTO> list = monitorService.getColumns(siteId);
        List<String> itemNames = list.stream().map(BaseSiteitemDTO::getItemName).collect(Collectors.toList());
        List<String> units = list.stream().map(BaseSiteitemDTO::getUnit).collect(Collectors.toList());
        for (int i1 = 0; i1 < itemNames.size(); i1++) {
            //第3-10列
            cell = row.createCell(i1 + 2);
            cell.setCellValue(itemNames.get(i1) + (units.get(i1) == null ? "" : ("(" + units.get(i1) + ")")));
            // cell.setCellStyle(this.title(workbook));
        }
    }

    /**
     * 设置列宽度
     */
    private void setColumnWidth(Sheet sheet) {
        //int allrows = sheet.getLastRowNum();
        //int maxColumn = 0;
        //for (int i = 0; i < allrows; i++) {
        //
        //    Row row = sheet.getRow(i);
        //    if (row != null) {
        //        int coloumNum = row.getPhysicalNumberOfCells();
        //        if (coloumNum > maxColumn) {
        //            maxColumn = coloumNum;
        //        }
        //    }
        //}
        for (int i = 0; i < 20; i++) {
            //设置宽度自适应
            sheet.autoSizeColumn(i, true);
        }
    }

    private String getValue(String key, Map<String, Object> map) {
        return map.get(key) == null ? "-" : map.get(key).toString();
    }

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
            cell.setCellStyle(this.textRed(workbook));
        } else {
            //正常数据
            if (row.getRowNum() % 2 == 0) {

                cell.setCellStyle(this.textno(workbook));
            } else {
                cell.setCellStyle(this.textblue(workbook));
            }
        }
        cell.setCellValue(value);
    }


    //小标题的样式
    private CellStyle title(Workbook wb) {
        //设置字体;
        Font font = wb.createFont();

        CellStyle style = getCellStyle(wb, "黑体", (short) 12);
        style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());  //设置天空蓝填充前景颜色
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  //设置填充图案
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);
        return style;
    }

    //正常文字样式 == 浅蓝色背景
    private CellStyle textblue(Workbook wb) {
        CellStyle style = getCellStyle(wb, "Times New Roman", (short) 10);
        style.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());  //设置天空蓝填充前景颜色
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  //设置填充图案
        return style;
    }

    //正常文字样式 ==背景不设置
    private CellStyle textno(Workbook wb) {
        return getCellStyle(wb, "Times New Roman", (short) 10);
    }

    private CellStyle getCellStyle(Workbook wb, String s, short i) {
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName(s);
        font.setFontHeightInPoints(i);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);                //横向居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);        //纵向居中
        return style;
    }

    //红色警告文字样式
    private CellStyle textRed(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setColor(Font.COLOR_RED);
        font.setFontName("Times New Roman");
        font.setFontHeightInPoints((short) 10);
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
    @SystemControllerLog(descrption = "历史数据下载", actionType = "6")
    public void printHistory(
            @RequestParam(value = "limit", defaultValue = "1000000") Integer limit,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "siteId") Integer siteId,
            @RequestParam(value = "startTime") String startTime,
            @RequestParam(value = "endTime") String endTime,
            HttpServletResponse response
    ) {
        List<BaseSiteitemDTO> list = monitorService.getColumns(siteId);
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row = setTitle(workbook, sheet, list, "地表水环境质量数据历史报表");
        Cell cell = null;
        List<String> itemNames = list.stream().map(BaseSiteitemDTO::getItemName).collect(Collectors.toList());
        List<String> units = list.stream().map(BaseSiteitemDTO::getUnit).collect(Collectors.toList());
        for (int i1 = 0; i1 < itemNames.size(); i1++) {
            //第3-10列
            cell = row.createCell(i1 + 1);
            cell.setCellValue(itemNames.get(i1) + (units.get(i1) == null ? "" : ("(" + units.get(i1) + ")")));
            // cell.setCellStyle(this.title(workbook));
        }
        PageResult<Map<String, Object>> pageResult = monitorService.getHistoryData(limit, page, siteId, startTime, endTime, "ASC",false);
        List<Map<String, Object>> mapList = pageResult.getRows();


        setDataValue(workbook, sheet, mapList, siteId);

        //第2步：  下载文件
        download(response, workbook, "历史报表.xlsx");
        //        //下载需要的数据
//        List<Map<String, Object>> mapList = pageResult.getRows();
//        //列名标题（对应key值）
//        String key0 = "序号";
//        String key1 = "测点";
//        String key2 = "moniterTime";
//        List<BaseSiteitemDTO> list = monitorService.getColumns(siteId);
//        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet();
//        Row row=null;
//        Cell cell = null;
//        row = sheet.createRow(0);
//        cell = row.createCell(0);
//        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, list.size()+2));
//        cell.setCellValue("地表水环境质量历史数据");
//        cell.setCellStyle(this.title(workbook));
//
//        row = sheet.createRow(1); // 创建第二行
//        cell = row.createCell(0);
//        cell.setCellValue("自动站名称： "+list.get(0).getSiteName());
//        cell.setCellStyle(this.title(workbook));
//        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 3));
//        cell = row.createCell(4);
//        System.out.println(list.size());
//        //cell.setCellValue("*****");
//        sheet.addMergedRegion(new CellRangeAddress(1, 1, 4, list.size()+2));
//        SimpleDateFormat df1 = new SimpleDateFormat("yyyy.MM.dd");// 设置日期格式
//        cell.setCellValue("上报时间："+df1.format(new Date()));
//        cell.setCellStyle(this.title(workbook));
//
//        //第3行
//        row = sheet.createRow(2);
//        //第一列,
//        cell = row.createCell(0);
//        cell.setCellValue(key0);
//        cell.setCellStyle(this.title(workbook));
//        //第二列
//        cell = row.createCell(1);
//        cell.setCellValue(key1);
//        cell.setCellStyle(this.title(workbook));
//
//        cell = row.createCell(2);
//        cell.setCellValue("监测时间");
//        cell.setCellStyle(this.title(workbook));
//
//        //第4列
//
//        List<String> itemNames = list.stream().map(BaseSiteitemDTO::getItemName).collect(Collectors.toList());
//        List<String> units = list.stream().map(BaseSiteitemDTO::getUnit).collect(Collectors.toList());
//        for (int i1 = 0; i1 < itemNames.size(); i1++) {
//            //第4
//            cell = row.createCell(i1 + 3);
//            cell.setCellValue(itemNames.get(i1) + (units.get(i1) == null ? "" : ("(" + units.get(i1) + ")")));
//            cell.setCellStyle(this.title(workbook));
//        }
//
//        //设置表格内容
//
//        for (int i = 0; i < mapList.size(); i++) {
//            row = sheet.createRow(i + 1);
//
//            Map<String, Object> map = mapList.get(i);
//            String s2 = getValue(key2, map);     //"moniterTime  监测时间";
//            setCell(workbook, row, i + 1 + "", 0);
//            String siteName = getValue("siteName", map);
//            setCell(workbook, row, siteName, 1);
//            setCell(workbook, row, s2, 2);
//            for (int i1 = 0; i1 < itemNames.size(); i1++) {
//                //第4-10列
//                String itemName = itemNames.get(i1);
//                String value = getValue(itemName, map);
//                setCell(workbook, row, value, i1 + 3);
//            }
//        }
//        // 设置列宽
//        setColumnWidth(sheet);
//        //下载文件
//        download(response, workbook, "历史数据.xlsx");
    }

    @RequestMapping("/printExceed")
    @SystemControllerLog(descrption = "超标情况统计下载", actionType = "6")
    public void printExceed(
            @RequestParam(value = "start") String start,
            @RequestParam(value = "end") String end,
            @RequestParam(value = "siteId") String siteId,
            HttpServletResponse response
    ) {

        //String start, String end, String siteId, String siteName, Boolean scale, Integer num
        List<ExceedStandard> exceedStandards = exceedStandardService.findByDateAndSiteName(start, end, siteId, false);
        if (exceedStandards.size() > 0) {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet();

            //第一行
            int rownum = 0;
            Row row = sheet.createRow(rownum);

            Cell cell;
            //设置标题
            cell = row.createCell(0);
            cell.setCellValue("");
            cell.setCellStyle(title(workbook));
            cell = row.createCell(1);
            cell.setCellValue("监测时间");
            cell.setCellStyle(title(workbook));
            cell = row.createCell(2);
            cell.setCellValue("站点名称");
            cell.setCellStyle(title(workbook));
            cell = row.createCell(3);
            cell.setCellValue("监测因子");
            cell.setCellStyle(title(workbook));
            cell = row.createCell(4);
            cell.setCellValue("监测值");
            cell.setCellStyle(title(workbook));
            cell = row.createCell(5);
            cell.setCellValue("单位");
            cell.setCellStyle(title(workbook));
            cell = row.createCell(6);
            cell.setCellValue("标准限值");
            cell.setCellStyle(title(workbook));
            cell = row.createCell(7);
            cell.setCellValue("水质类别(超标倍数)");
            cell.setCellStyle(title(workbook));

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

            download(response, workbook, "超标情况统计.xlsx");

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
}
