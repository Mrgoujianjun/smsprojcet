package com.gou.springcloud.nacosprovider.controller;

import com.gou.springcloud.nacosprovider.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author goujianjun
 * @date 2019/5/29 10:12
 */
@RestController
@Slf4j
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("getUserInfo")
    public String getUserInfo() {
        return userInfoService.userInfo();
    }
}
