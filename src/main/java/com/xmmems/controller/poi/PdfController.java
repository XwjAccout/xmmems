package com.xmmems.controller.poi;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.xmmems.common.exception.XMException;
import com.xmmems.dto.BaseSiteitemDTO;
import com.xmmems.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

@Controller
@RequestMapping("/pdf")
public class PdfController {

    @Autowired
    private MonitorService monitorService;

    /**
     * @param pageSize       A4纵向纸张大小  4A 横向纸张大小
     * @param type           1日报表2周报表3月报表4年报表
     * @param isAutoPageSize true 自动设置纸张大小
     */
    @GetMapping("/report")
    public void report(
            @RequestParam(value = "siteId") Integer siteId,
            @RequestParam(value = "siteName") String siteName,
            @RequestParam(value = "startTime") String startTime,
            @RequestParam(value = "endTime", required = false) String endTime,
            @RequestParam(value = "pageSize", defaultValue = "A4") String pageSize,
            @RequestParam(value = "type", defaultValue = "1") Integer type,
            @RequestParam(value = "isAutoPageSize", defaultValue = "true") Boolean isAutoPageSize,
            @RequestParam(value = "statistics", required = false) List<Integer> statistics,
            @RequestParam(value = "limit", defaultValue = "true") Boolean limit,
            @RequestParam(value = "isDayAvg", defaultValue = "false") Boolean isDayAvg, HttpServletResponse response) {

        try {
            //数据列名,设置纸张大小
            List<BaseSiteitemDTO> columnsNames = monitorService.getColumns(siteId);
            if (isAutoPageSize && columnsNames.size() > 11) {//自动设置纸张大小
                pageSize = "4A";
            }

            Rectangle A = null;
            switch (pageSize) {

                case "A3":
                    A = new RectangleReadOnly(842, 1191);
                    break;
                case "A4":
                    A = new RectangleReadOnly(595, 842);
                    break;

                //横向PDF
                case "3A":
                    A = new RectangleReadOnly(1191, 842);
                    break;
                case "4A":
                    A = new RectangleReadOnly(842, 595);
                    break;
                default:
                    A = new RectangleReadOnly(595, 842);
                    break;
            }
            List<Map<String, String>> datas = getDataList(siteId, startTime, endTime, type, statistics, limit, isDayAvg);

            // 1.新建document对象
            Document document = new Document(A);// 建立一个Document对象 a3,横向
            maxWidth = (int)document.getPageSize().getWidth() - 40;

            // 2.建立一个书写器(Writer)与document对象关联
            UUID uuid = UUID.randomUUID();
            File file = new File("./" + uuid.toString() + ".pdf");
            file.createNewFile();
            PdfWriter.getInstance(document, new FileOutputStream(file));

            // 3.打开文档
            document.open();


            // 4.向文档中添加内容
            generatePDF(document, datas, columnsNames, siteName, startTime, endTime, type);

            // 5.关闭文档
            document.close();

            response.setContentType("application/octet-stream;charset=utf-8");
            String returnName = response.encodeURL(new String((siteName + typeName + ".pdf").getBytes(), "iso8859-1"));
            response.setHeader("Content-Disposition", "attachment;filename=" + returnName);
            InputStream in = new FileInputStream(file);
            OutputStream out = response.getOutputStream();
            //创建缓冲区
            byte[] buffer = new byte[1024];
            int len = 0;
            //循环将输入流中的内容读取到缓冲区当中
            while ((len = in.read(buffer)) > 0) {
                //输出缓冲区的内容到浏览器，实现文件下载
                out.write(buffer, 0, len);
            }
            //关闭文件输入流
            in.close();
            //关闭输出流
            out.flush();
            out.close();
            file.delete();
        } catch (Exception e) {
            throw new XMException(500, e.getMessage());
        }

    }

    private List<Map<String, String>> getDataList(Integer siteId, String startTime, String endTime, Integer type, List<Integer> statistics, Boolean limit, Boolean isDayAvg) {
        //获取数据
        switch (type) {
            case 1:
                typeName = "时段报表";
                return monitorService.day(siteId, startTime, endTime, statistics, limit);
            case 2:
                typeName = "周报表";
                return monitorService.week(siteId, Integer.parseInt(startTime), Integer.parseInt(endTime), statistics, limit);
            case 3:
                typeName = "日均值报表";
                return monitorService.month(siteId, startTime, endTime, statistics, limit);
            case 4:
                typeName = "月均值报表";
                return monitorService.year(siteId, startTime, endTime, statistics, limit);
            case 5:
                typeName = "季报表";
                return monitorService.seasons(siteId, Integer.parseInt(endTime), Integer.parseInt(startTime), statistics, limit, isDayAvg);
            case 6:
                typeName = "日报表";
                return monitorService.realDay(siteId, startTime, statistics, limit);
            case 7:
                typeName = "月报表";
                return monitorService.realMonth(siteId, Integer.parseInt(startTime), Integer.parseInt(endTime), statistics, limit);
            case 8:
                typeName = "年报表";
                return monitorService.realYear(siteId, Integer.parseInt(startTime), statistics, limit);
            default:
                return new ArrayList<>();
        }
    }

    // 定义全局的字体静态变量
    private static Font bigTitleFont;  //大标题
    private static Font smallTitleFont;  //大标题下的小标题
    private static Font tableTitleFont;  //表格的小标题
    private static Font textFont;  //普通正文内容
    private static Font textFontSmall;  //普通正文内容
    private static Font textFontRed;  //普通正文内容
    private static Font textFontRedSmall;  //普通正文内容
    // 最大宽度
    private int maxWidth = 500;
    //报表类型
    private String typeName = "日报表";

    // 静态代码块
    static {
        BaseFont bfChinese = null;
        try {
            String path = "C:/WINDOWS/Fonts/simhei.ttf";//windows里的字体资源路径
            bfChinese = BaseFont.createFont(path, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        } catch (Exception e) {
            // 不同字体（这里定义为同一种字体：包含不同字号、不同style）
            try {
                bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            } catch (Exception ex) {
                System.out.println("pdf文件下载字体初始化失败");
                ex.printStackTrace();
            }
        }
        bigTitleFont = new Font(bfChinese, 14, Font.BOLD);
        smallTitleFont = new Font(bfChinese, 8, Font.NORMAL);
        tableTitleFont = new Font(bfChinese, 8, Font.BOLD);
        textFont = new Font(bfChinese, 8, Font.NORMAL);
        textFontSmall = new Font(bfChinese, 6, Font.NORMAL);
        textFontRed = new Font(bfChinese, 8, Font.NORMAL, BaseColor.RED);
        textFontRedSmall = new Font(bfChinese, 7, Font.NORMAL, BaseColor.RED);
    }

    // 生成PDF文件
    public void generatePDF(Document document, List<Map<String, String>> datas, List<BaseSiteitemDTO> columnsNames, String siteName, String startTime, String endTime, Integer type) throws ParseException, DocumentException {


        // 大标题
        Paragraph bigTitle = new Paragraph(siteName + typeName, bigTitleFont);
        bigTitle.setAlignment(1); //设置文字居中 0靠左   1，居中     2，靠右
        bigTitle.setLeading(20f); //行间距
        bigTitle.setSpacingBefore(5f); //设置段落上空白

        // 小标题
        String st = "";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
        switch (type) {
            case 1:
                startTime = sdf2.format(sdf1.parse(startTime));
                endTime = sdf2.format(sdf1.parse(endTime));
                st = startTime + "-" + endTime + "时段报表";
                break;
            case 3:
                startTime = sdf2.format(sdf1.parse(startTime));
                endTime = sdf2.format(sdf1.parse(endTime));
                st = startTime + "-" + endTime + "日均值报表";
                break;
            case 4:
                startTime = sdf2.format(sdf1.parse(startTime));
                endTime = sdf2.format(sdf1.parse(endTime));
                st = startTime + "-" + endTime + "月均值报表";
                break;
            case 2:
                st = startTime + "年第" + endTime + "周报表";
                break;
            case 5:
                st = startTime + "年第" + endTime + "季度报表";
                break;
            case 6:
                st = sdf2.format(sdf1.parse(startTime)) + "日报表";
                break;
            case 7:
                st = startTime + "年" + endTime + "月报表";
                break;
            case 8:
                st = startTime + "年报表";
                break;
            default:
                break;

        }

        typeName = st;
        Paragraph smallTitle = new Paragraph(st, smallTitleFont);
        smallTitle.setAlignment(1); //设置文字居中 0靠左   1，居中     2，靠右
        smallTitle.setLeading(20f); //行间距
        smallTitle.setSpacingAfter(10f); //设置段落下空白

        /*// 直线        Paragraph 直线 = new Paragraph();        直线.add(new Chunk(new LineSeparator()));        // 点线        Paragraph 点线 = new Paragraph();        点线.add(new Chunk(new DottedLineSeparator()));        // 超链接        Anchor 超链接 = new Anchor("baidu");        超链接.setReference("www.baidu.com");      // 定位        Anchor 定位 = new Anchor("goto");        定位.setReference("#top");*/
        List<String> titles = new ArrayList<>();
        titles.add("moniterTime");
        List<String> titlesUnit = new ArrayList<>();
        titlesUnit.add("单位");
        // 表格
        for (BaseSiteitemDTO siteitem : columnsNames) {
            titles.add(siteitem.getItemName());
            titlesUnit.add(siteitem.getUnit() == null ? "-" : siteitem.getUnit());
        }
        StringBuilder sb = new StringBuilder();
        for (String s : titles) {
            if (s.length() > 6) {
                sb.append("123456");
            } else if (s.length() < 4) {
                sb.append("1234");
            } else {
                sb.append(s);
            }
        }
        //一个字的宽度
        int singleLength = maxWidth / sb.length();

        float[] columnNum = new float[titles.size()];
        for (int i = 0; i < titles.size(); i++) {
            String title = titles.get(i);
            //设置每一列的宽度
            if (title.length() >= 6) {
                columnNum[i] = singleLength * 7;
            } else if (title.length() <= 3) {
                columnNum[i] = singleLength * 4;
            } else {
                columnNum[i] = singleLength * title.length();
            }
        }

        PdfPTable table = createTable(columnNum);

        for (String title : titles) {
            if ("moniterTime".equals(title)) {
                title = "监测时间";
            }
            table.addCell(createCell(title, tableTitleFont));
        }
        for (String title : titlesUnit) {
            table.addCell(createCell(title, tableTitleFont));
        }

        for (Map<String, String> map : datas) {

            for (String title : titles) {
                String value = map.get(title);
                value = value == null ? "" : value;
                if ("水质类别".equals(value) || "主要污染物".equals(value) || "平均数据捕捉率(%)".equals(value) || "平均有效数据获取率(%)".equals(value) || "平均故障率(%)".equals(value)) {

                    String leftTitle = map.get("moniterTime");
                    table.addCell(createCell(leftTitle == null ? "" : leftTitle, textFont));
                    String itemNameFirst = titles.get(1);
                    table.addCell(createCell(map.get(itemNameFirst), textFont, titles.size() - 1, false));
                    break;
                } else {
                    PdfPCell cell = createCell(value, textFont);
                    table.addCell(cell);
                }
            }

        }

        //其他信息
        table.addCell(createCell("备注", tableTitleFont));
        table.addCell(createCell("", textFont, titles.size() - 1, false));


        int numberOfColumns = table.getNumberOfColumns();
        if (numberOfColumns >= 6) {

            table.addCell(createCell("制表:", tableTitleFont, "right"));
            table.addCell(createCell("", textFont, "both"));
            table.addCell(createCell("复核:", tableTitleFont, "both"));
            table.addCell(createCell("", textFont, "both"));
            table.addCell(createCell("签发:", tableTitleFont, "both"));
            table.addCell(createCell("", textFont, titles.size() - 5, true));
        }

        document.add(bigTitle);
        document.add(smallTitle);
        document.add(table);
    }


    /**------------------------创建表格单元格的方法start----------------------------*/
    /**
     * 创建单元格(指定字体)
     */
    public static PdfPCell createCell(String value, Font font) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        if (value.contains("$$")) {
            value = value.replace("$$", "");
            font = textFontRed;
            if (value.length() > 6 && value.length() < 10) {
                font = textFontRedSmall;
            }
        }
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    public static PdfPCell createCell(String value, Font font, String s) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        if ("left".equals(s)) {
            cell.setBorderWidthLeft(0);
        } else if ("right".equals(s)) {
            cell.setBorderWidthRight(0);
        } else if ("both".equals(s)) {
            cell.setBorderWidthLeft(0);
            cell.setBorderWidthRight(0);
        }
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    /**
     * 创建单元格（指定字体、水平居..、单元格跨x列合并、设置单元格内边距）
     */
    public static PdfPCell createCell(String value, Font font, int colspan, boolean flag) {

        PdfPCell cell = new PdfPCell();
        cell.setColspan(colspan);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPhrase(new Phrase(value, font));
        if (flag) {
            cell.setBorderWidthLeft(0);
        }
        return cell;
    }

    /**------------------------创建表格单元格的方法end----------------------------*/


    /**--------------------------创建表格的方法start------------------- ---------*/

    /**
     * 创建指定列宽、列数的表格
     */
    public PdfPTable createTable(float[] widths) {
        PdfPTable table = new PdfPTable(widths);
        try {
            table.setTotalWidth(maxWidth);
            table.setLockedWidth(true);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setBorder(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }

    /**--------------------------创建表格的方法end------------------- ---------*/


}