package com.gou.springcloud.common.common;

/**
 * @author goujianjun
 * @date 2019-07-24 15:33
 */

public class ResponseWrapper {
    private ResponseWrapper() {

    }

    public static <E> Response<E> ok() {
        return new Response<>();
    }

    public static <E> Response<E> ok(E result) {
        return new Response<E>(Response.SUCCESS_CODE, Response.SUCCESS_CONTEXT, result);
    }

    public static <E> Response<E> wrap(String code, String messaeg, E context) {
        return new Response<>(code, messaeg, context);
    }

    public static <E> Response<E> wrap(String code, String messaeg) {
        return new Response<>(code, messaeg);
    }
}
