package com.gou.springcloud.common.basic;

import com.gou.springcloud.common.context.ResponseEnum;

/**
 * @author goujianjun
 * @date 2019-07-09 16:21
 */

public class CustomizeException extends Exception {
    private ResponseEnum responseEnum;

    public CustomizeException(ResponseEnum responseEnum) {
        this.responseEnum = responseEnum;
    }

    public ResponseEnum getResponseEnum() {
        return this.responseEnum;
    }
}
