package com.xmmems.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @描述 用来保存报表查询过程中的临时变量
 * @创建人 ithxw
 * @创建时间 2020.10.10 10:10
 */
@Component
public class ReportThreadLocal {

    private static ThreadLocal<ReportTempParams> TL = new ThreadLocal<>();

    public static String getType() {
        return gettl().getType();
    }

    public static double getAll() {
        return gettl().getAll();
    }

    public static boolean getLimit(){
        return gettl().isLimit();
    }

    public static void settl(String type, double all, boolean limit) {
        TL.set(new ReportTempParams(type, all,limit));
    }

    public static ReportTempParams gettl() {
        return TL.get();
    }

    public static void setAll(double all) {
        gettl().setAll(all);
    }

    public static void setType(String type) {
        gettl().setType(type);
    }

    public static void setLimit(boolean limit) {
        gettl().setLimit(limit);
    }


}

@Getter
@NoArgsConstructor
@AllArgsConstructor
class ReportTempParams {
    private String type;
    private double all;
    private boolean limit;

    public void setType(String type) {
        this.type = type;
    }

    public void setAll(double all) {
        this.all = all;
    }

    public void setLimit(boolean limit) {
        this.limit = limit;
    }
}
