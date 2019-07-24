package com.gou.springcloud.common.common;

import lombok.Data;

/**
 * @author goujianjun
 * @date 2019-06-04 15:51
 */
@Data
public class Response<T> {
    public static String SUCCESS_CODE = "200";
    public static String SUCCESS_CONTEXT = "处理成功";
    private String code;
    private String message;
    private T context;

    public Response() {
        this.code = SUCCESS_CODE;
        this.message = SUCCESS_CONTEXT;
    }

    public Response(String code, String message) {
        this(code, message, null);
    }

    public Response(String code, String message, T context) {
        this.code(code).message(message).context(context);
    }

    public Response<T> code(String code) {
        this.code = code;
        return this;
    }

    public Response<T> message(String message) {
        this.message = message;
        return this;
    }

    public Response<T> context(T context) {
        this.context = context;
        return this;
    }
}
