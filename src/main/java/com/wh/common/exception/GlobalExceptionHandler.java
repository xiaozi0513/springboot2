package com.wh.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常捕获处理
 *
 * @author: wang_hui
 * @date: 2018/9/12 下午5:49
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Throwable.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public void throwableHandler(Throwable e) {
        log.error("Internal Server Error.", e);
    }

    // add other exception handler
    // ...
}
