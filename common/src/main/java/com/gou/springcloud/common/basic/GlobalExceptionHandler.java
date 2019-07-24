package com.gou.springcloud.common.basic;

import com.alibaba.fastjson.JSON;
import com.gou.springcloud.common.common.Response;
import com.gou.springcloud.common.context.ResponseEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author goujianjun
 * @date 2019-07-09 16:16
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = CustomizeException.class)
    public String handleException(CustomizeException customizeException) {
        ResponseEnum responseEnum = customizeException.getResponseEnum();
        Response response = new Response();
        response.setCode(responseEnum.code());
        response.setContext(responseEnum.description());
        return JSON.toJSONString(response);
    }
}
