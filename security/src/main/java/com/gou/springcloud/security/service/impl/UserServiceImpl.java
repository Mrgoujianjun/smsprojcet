package com.gou.springcloud.security.service.impl;

import com.gou.springcloud.common.enums.ErrorCode;
import com.gou.springcloud.common.exception.BusinessException;
import com.gou.springcloud.security.comm.bean.EmergencyUserDetails;
import com.gou.springcloud.security.dao.UserDao;
import com.gou.springcloud.security.model.domain.User;
import com.gou.springcloud.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @author goujianjun
 * @email lygoujianjun@163.com
 * @date 2020-03-01 21:57
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Example example = new Example(User.class);
        example.and().andEqualTo("username", username);
        User user = userDao.selectOneByExample(example);
        if (user != null) {
            EmergencyUserDetails emergencyUserDetails = new EmergencyUserDetails();
            emergencyUserDetails.setPassword(user.getPassword());
            emergencyUserDetails.setUsername(user.getUsername());
            emergencyUserDetails.setExpired(user.getExpired());
            emergencyUserDetails.setLocked(user.getLocked());
            emergencyUserDetails.setEnable(user.getStatus());
            return emergencyUserDetails;
        }
        return null;
    }

    @Override
    public void registerUser(User user) {
        int isContain = userDao.getUserByUsername(user.getUsername());
        if (isContain > 0) {
            throw new BusinessException(ErrorCode.USER_REGISTER,user.getUsername());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(false);
        user.setCreateTime(new Date());
        user.setModifyTime(new Date());
        user.setId(String.valueOf(System.currentTimeMillis()));
        userDao.addUser(user);
    }

    @Override
    public String updateUserInfo(User user) {
        user.setModifyTime(new Date());
        userDao.updateById(user);
        return "success";
    }
}
