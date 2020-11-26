package com.xmmems.common.utils;

import com.xmmems.common.exception.XMException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

@Component
public class FileLog {

    private static final String fileUrl = "D:\\";

    private static PrintWriter writer;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss.SSS");

    @Scheduled(cron = "0 0 0 * * ?")
    @Scheduled(fixedRate = 24*60*60*1000)
    public void init () {
        if (writer != null) {
            writer.close();
        }
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(fileUrl + sdf.format(System.currentTimeMillis()) + ".log", true)),true);
        } catch (IOException e) {
            throw new XMException(500, e.getMessage());
        }
    }

    public static void sendToServer(String msg){
        String x = dateFormat.format(System.currentTimeMillis()) + "-->发送：" + msg;
        writer.println(x);
        //System.err.println(x);
    }

    public static void receiveFromServer(String msg){
        String x = dateFormat.format(System.currentTimeMillis()) + "-->接收：" + msg + "\r\n";
        writer.println(x);
        //System.err.println(x);
    }

    public static void info(String msg){
        String x = dateFormat.format(System.currentTimeMillis()) + "-->其他信息：" + msg;
        writer.println(x);
        //System.err.println(x);
    }
    public static void error(String msg){
        String x = dateFormat.format(System.currentTimeMillis()) + "-->错误信息：" + msg;
        writer.println(x);
        //System.err.println(x);
    }

}
