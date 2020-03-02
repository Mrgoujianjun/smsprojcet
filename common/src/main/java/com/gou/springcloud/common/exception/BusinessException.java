package com.gou.springcloud.common.exception;

import com.gou.springcloud.common.enums.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author goujianjun
 * @email lygoujianjun@163.com
 * @date 2020-03-01 21:45
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException{
    private String message;
    private Integer code;

    public BusinessException(Throwable throwable) {
        super(throwable);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public BusinessException(ErrorCode errorCode, Object... params) {
        this.message = String.format(errorCode.getMessage(), params);
        this.code = errorCode.getCode();
    }
}
