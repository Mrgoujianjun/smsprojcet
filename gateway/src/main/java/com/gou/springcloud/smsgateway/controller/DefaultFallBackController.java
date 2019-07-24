package com.gou.springcloud.smsgateway.controller;

import com.gou.springcloud.common.common.Response;
import com.gou.springcloud.common.common.ResponseWrapper;
import com.gou.springcloud.common.context.ResponseEnum;
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
    public Response defaultFallback() {
        return ResponseWrapper.wrap(ResponseEnum.TIMEOUT.code(), ResponseEnum.TIMEOUT.description());
    }
}
