package com.gou.springcloud.common.basic;

import com.gou.springcloud.common.common.ResponseWrapper;
import com.gou.springcloud.common.enums.ErrorCode;
import com.gou.springcloud.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author goujianjun
 * @date 2019-07-09 16:16
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = BusinessException.class)
    public ResponseWrapper businessExceptionHandler(BusinessException ex) {
        return new ResponseWrapper(ex.hashCode(), ex.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseWrapper unknownException(Exception ex) {
        log.error(ex.getMessage());
        return new ResponseWrapper(ErrorCode.UNKNOWN_ERROR.getCode(), ErrorCode.UNKNOWN_ERROR.getMessage());
    }
}
