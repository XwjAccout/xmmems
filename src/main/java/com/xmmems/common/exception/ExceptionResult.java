package com.xmmems.common.exception;

import lombok.Getter;
import org.joda.time.DateTime;


@Getter
public class ExceptionResult {
    private int status;
    private String message;
    private String timestamp;

    public ExceptionResult(XMException e) {
        this.status = e.getStatus();
        this.message = e.getMessage();
        this.timestamp = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
        e.printStackTrace();
    }

    public ExceptionResult(NullPointerException e) {
        this.status = 500;
        this.message = "空指针异常:"+e.getLocalizedMessage();
        this.timestamp = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
        e.printStackTrace();
    }
}