package com.gou.springcloud.common.context;

/**
 * @author goujianjun
 * @date 2019-06-04 16:06
 */
public enum ResponseEnum {
    SUCCESS("200", "请求成功"),
    TIMEOUT("20001","请求超时,请稍后再试！"),
    FAILD("401", "处理失败");

    private String code;
    private String description;

    ResponseEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String code() {
        return this.code;
    }

    public String description() {
        return this.description;
    }

}
