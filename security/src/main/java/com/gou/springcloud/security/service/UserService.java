package com.gou.springcloud.security.service;

import com.gou.springcloud.security.model.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author goujianjun
 * @date 2020-03-01 21:52
 */
public interface UserService extends UserDetailsService {
    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    void registerUser(User user);

    /**
     * 用户信息更新
     *
     * @param user
     * @return
     */
    String updateUserInfo(User user);
}
