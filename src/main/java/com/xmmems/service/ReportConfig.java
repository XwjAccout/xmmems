package com.xmmems.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "report")
@Component
public class ReportConfig {
    private List<String> zeroCheck;  //零点核查比较值
    private List<String> zeroDrift;  //零店漂移比较值
    private List<String> spanCheck;  //跨度核查比较值
    private List<String> spanDrift;  //跨度漂移比较值

    private static Map<String, String> zeroCheckCompare = new HashMap<>();  //零点核查比较值
    private static Map<String, String> zeroDriftCompare = new HashMap<>();  //零店漂移比较值
    private static Map<String, String> spanCheckCompare = new HashMap<>();  //跨度核查比较值
    private static Map<String, String> spanDriftCompare = new HashMap<>();  //跨度漂移比较值

    @PostConstruct
    public void init() {
        zeroCheck.forEach(temp->{
            String[] split = temp.split("=");
            zeroCheckCompare.put(split[0], split[1]);
        });
        zeroDrift.forEach(temp->{
            String[] split = temp.split("=");
            zeroDriftCompare.put(split[0], split[1]);
        });
        spanCheck.forEach(temp->{
            String[] split = temp.split("=");
            spanCheckCompare.put(split[0], split[1]);
        });
        spanDrift.forEach(temp->{
            String[] split = temp.split("=");
            spanDriftCompare.put(split[0], split[1]);
        });
    }

    public static Map<String, String> getZeroCheckCompare() {
        return zeroCheckCompare;
    }

    public static Map<String, String> getZeroDriftCompare() {
        return zeroDriftCompare;
    }

    public static Map<String, String> getSpanCheckCompare() {
        return spanCheckCompare;
    }

    public static Map<String, String> getSpanDriftCompare() {
        return spanDriftCompare;
    }
}
