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
        return getTL().getType();
    }

    public static double getAll() {
        return getTL().getAll();
    }

    public static Boolean getLimit(){
        return getTL().getLimit();
    }

    public static void setTL(String type, double all,Boolean limit) {
        TL.set(new ReportTempParams(type, all,limit));
    }

    public static ReportTempParams getTL() {
        return TL.get();
    }

    public static void setAll(double all) {
        getTL().setAll(all);
    }

    public static void setType(String type) {
        getTL().setType(type);
    }

    public static void setLimit(Boolean limit) {
        getTL().setLimit(limit);
    }


}

@Getter
@NoArgsConstructor
@AllArgsConstructor
class ReportTempParams {
    private String type;
    private double all;
    private Boolean limit;

    public void setType(String type) {
        this.type = type;
    }

    public void setAll(double all) {
        this.all = all;
    }

    public void setLimit(Boolean limit) {
        this.limit = limit;
    }
}
