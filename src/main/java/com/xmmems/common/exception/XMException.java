package com.xmmems.common.exception;

import lombok.Getter;

@Getter
public class XMException extends RuntimeException{
    private Integer status;

    public XMException(Integer status, String message) {
        super(message);
        this.status = status;
    }

    public XMException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.status = exceptionEnum.getStatus();
    }

}
