package com.xmmems.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.IOException;
import java.sql.SQLException;

/**
 * 有@ControllerAdvice注解的处理器，具有拦截异常的功能
 */
@ControllerAdvice
public class XMExceptionHandlerController {

    /**
     * 异常处理器Exception
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResult> handlerException(Exception e) {
        if (e instanceof XMException) {
            XMException exception = (XMException)e;
            return ResponseEntity.status(exception.getStatus()).body(new ExceptionResult(exception));
        } else if (e instanceof SQLException) {
            XMException exception = new XMException(500, "数据库操作异常;" + e.getLocalizedMessage());
            return ResponseEntity.status(500).body(new ExceptionResult(exception));
        } else if (e instanceof IOException) {
            XMException exception = new XMException(500, "文件IO操作异常;" + e.getLocalizedMessage());
            return ResponseEntity.status(500).body(new ExceptionResult(exception));
        } else if (e instanceof MethodArgumentTypeMismatchException) {
            XMException exception = new XMException(400, "客户端请求异常;" + e.getLocalizedMessage());
            return ResponseEntity.status(400).body(new ExceptionResult(exception));
        } else if (e instanceof NullPointerException) {
            XMException exception = new XMException(500, "空指针异常;" + e.getLocalizedMessage());
            return ResponseEntity.status(500).body(new ExceptionResult(exception));
        } else if (e instanceof ArrayIndexOutOfBoundsException) {
            XMException exception = new XMException(500, "数组下标越界异常;" + e.getLocalizedMessage());
            return ResponseEntity.status(500).body(new ExceptionResult(exception));
        } else if (e instanceof ClassCastException) {
            XMException exception = new XMException(500, "类型转换异常;" + e.getLocalizedMessage());
            return ResponseEntity.status(500).body(new ExceptionResult(exception));
        } else if (e instanceof ArithmeticException) {
            XMException exception = new XMException(500, "算术异常;" + e.getLocalizedMessage());
            return ResponseEntity.status(500).body(new ExceptionResult(exception));
        } else if (e instanceof RuntimeException) {
            XMException exception = new XMException(500, "其他运行时异常;" + e.getLocalizedMessage());
            return ResponseEntity.status(500).body(new ExceptionResult(exception));
        } else {
            XMException exception = new XMException(500, "其他异常;" + e.getLocalizedMessage());
            return ResponseEntity.status(500).body(new ExceptionResult(exception));
        }
    }
}
