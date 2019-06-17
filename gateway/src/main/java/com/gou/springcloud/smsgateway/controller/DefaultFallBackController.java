package com.gou.springcloud.smsgateway.controller;

import com.gou.springcloud.common.common.Response;
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
        Response response = new Response();
        return response.buildResponse("505", "请求超时，请稍后重试!");
    }
}
