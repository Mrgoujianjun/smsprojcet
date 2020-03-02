package com.gou.springcloud.security.controller;

import com.gou.springcloud.common.common.ResponseWrapper;
import com.gou.springcloud.security.model.domain.User;
import com.gou.springcloud.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author goujianjun
 * @email lygoujianjun@163.com
 * @date 2020-03-01 22:39
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody User user) {
        return null;
    }

    @PostMapping(value = "register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseWrapper registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseWrapper.ok();
    }

    @PostMapping(value = "updateUserInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateUserInfo(@RequestBody User user) {
        return userService.updateUserInfo(user);
    }
}
