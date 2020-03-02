package com.gou.springcloud.common.enums;

/**
 * @author goujianjun
 * @email lygoujianjun@163.com
 * @date 2020-03-01 21:47
 */

public enum  ErrorCode implements BaseEnum<Integer, String> {
    USER_REGISTER(100001, "用户注册失败%s,请重新注册"),
    TOKEN_ERROR(100002, "token认证失败"),
    SERVER_NOT_FIND(100003,"服务不存在"),
    UNKNOWN_ERROR(100003,"未知异常！");
    private Integer code;
    private String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
