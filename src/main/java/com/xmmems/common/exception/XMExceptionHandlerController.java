package com.xmmems.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 有@ControllerAdvice注解的处理器，具有拦截异常的功能
 */
@ControllerAdvice
public class XMExceptionHandlerController {

    /**
     * 当前处理器只处理XMException
     * @return
     */
    @ExceptionHandler(XMException.class)
    public ResponseEntity<ExceptionResult> handlerXMException(XMException e){
        return ResponseEntity.status(e.getStatus()).body(new ExceptionResult(e));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionResult> handlerException(NullPointerException e){
        return ResponseEntity.status(500).body(new ExceptionResult(e));
    }

}
