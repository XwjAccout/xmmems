package com.xmmems.common.utils;

import com.xmmems.common.exception.XMException;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @描述 日期格式化工具
 * @创建人 ithxw
 * @创建时间 2020.03.13 10:15
 */
@Getter
public class DateFormat {
    public static final SimpleDateFormat yyyy_MM_dd_HH_mm_ss_SSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    public static final SimpleDateFormat yyyy_MM_dd_HH_mm_ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat yyyy_MM_dd_HH_mm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final SimpleDateFormat yyyy_MM_dd_HH = new SimpleDateFormat("yyyy-MM-dd HH");
    public static final SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat yyyy_MM = new SimpleDateFormat("yyyy-MM");
    public static final SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");
    public static final SimpleDateFormat MM = new SimpleDateFormat("MM");
    public static final SimpleDateFormat mm = new SimpleDateFormat("mm");
    public static final SimpleDateFormat HH_mm_ss = new SimpleDateFormat("HH:mm:ss");
    public static final SimpleDateFormat HH_mm = new SimpleDateFormat("HH:mm");
    public static final SimpleDateFormat HH = new SimpleDateFormat("HH");

    public static final SimpleDateFormat yyyy_MM_dd_00_00_00 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
    public static final SimpleDateFormat yyyy_MM_dd_23_59_59 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");


    private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);

    public static String formatAll(Object date) {
        if (date == null) {
            return null;
        }
        synchronized (yyyy_MM_dd_HH_mm_ss) {
            return yyyy_MM_dd_HH_mm_ss.format(date);
        }
    }

    public static Date parseAll(String DateStr) {
        if (DateStr == null) {
            return new Date();
        }
        try {
            synchronized (yyyy_MM_dd_HH_mm_ss) {
                return yyyy_MM_dd_HH_mm_ss.parse(DateStr);
            }
        } catch (ParseException e) {
            log.error("日期格式化出错，格式应该为：" + yyyy_MM_dd_HH_mm_ss.toPattern(), e);
            throw new XMException(500, ("日期格式化出错，格式应该为：" + yyyy_MM_dd_HH_mm_ss.toPattern()));
        }
    }

    public static String formatSome(Date date) {
        if (date == null) {
            return null;
        }
        synchronized (yyyy_MM_dd) {
            return yyyy_MM_dd.format(date);
        }
    }

    public static String formatSome(Long date) {
        if (date == null) {
            return null;
        }

        synchronized (yyyy_MM_dd) {
            return yyyy_MM_dd.format(date);
        }
    }

    public static Date parseSome(String DateStr) {
        if (DateStr == null) {
            return null;
        }

        try {
            synchronized (yyyy_MM_dd) {
                return yyyy_MM_dd.parse(DateStr);
            }
        } catch (ParseException e) {
            log.error("日期格式化出错，格式应该为 ：" + yyyy_MM_dd.toPattern(), e);
            return null;
        }
    }

    public static Date parse(SimpleDateFormat simpleDateFormat, String DateStr) {
        try {
            synchronized (simpleDateFormat) {
                return simpleDateFormat.parse(DateStr);
            }
        } catch (ParseException e) {
            log.error("日期格式化出错，格式应该为：" + simpleDateFormat.toPattern(), e);
            return null;
        }
    }

    public static String format(SimpleDateFormat simpleDateFormat, Date date) {
        synchronized (simpleDateFormat) {
            return simpleDateFormat.format(date);
        }
    }

    public static Map<String, String> splitToMap(Date dateTime) {
        synchronized (yyyy_MM_dd_HH_mm_ss) {
            String format = yyyy_MM_dd_HH_mm_ss.format(dateTime);
            return splitToMap(format);
        }
    }

    /**
     * yyyy-MM-dd HH:mm:ss  字符串格式
     */
    public static Map<String, String> splitToMap(String format) {
        String[] s = format.split(" ");
        String[] date = s[0].split("-");
        String[] time = s[1].split(":");
        Map<String, String> map = new HashMap<>(16);
        map.put("year", date[0]);
        map.put("month", date[1]);
        map.put("day", date[2]);
        map.put("hour", time[0]);
        map.put("minute", time[1]);
        map.put("second", time[2]);

        map.put("yyyy", date[0]);
        map.put("MM", date[1]);
        map.put("dd", date[2]);
        map.put("HH", time[0]);
        map.put("mm", time[1]);
        map.put("ss", time[2]);

        return map;
    }

}
