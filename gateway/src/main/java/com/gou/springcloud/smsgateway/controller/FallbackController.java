package com.gou.springcloud.smsgateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author goujianjun
 * @email lygoujianjun@163.com
 * @date 2020-03-11 15:34
 */
@RestController
public class FallbackController {
    @RequestMapping("fallback")
    public void serverFallBack(){
        System.out.println("------服务降级！");
    }
}
