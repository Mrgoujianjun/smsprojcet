package com.gou.springcloud.nacosconsuer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author goujianjun
 * @date 2019/5/29 10:21
 */
@RestController
public class ConsummerController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "helloRestTemplate")
    public String helloRestTemplate() {
        String rest = restTemplate.getForObject("http://localhost:8762/getUserInfo", String.class);
        return rest;
    }
}
