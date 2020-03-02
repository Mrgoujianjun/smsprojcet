package com.gou.springcloud.smsgateway.controller;

import com.gou.springcloud.common.common.ResponseWrapper;
import com.gou.springcloud.common.enums.ErrorCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author goujianjun
 * @date 2019-06-17 14:24
 * 自定义服务降级处理
 */
@RestController
public class DefaultFallBackController {
    @RequestMapping("defaultFallback")
    public ResponseWrapper defaultFallback() {
        return ResponseWrapper.wrap(ErrorCode.SERVER_NOT_FIND.getCode(), ErrorCode.SERVER_NOT_FIND.getMessage());
    }
}
