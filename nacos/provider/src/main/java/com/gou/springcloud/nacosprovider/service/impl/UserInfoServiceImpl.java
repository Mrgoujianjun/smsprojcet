package com.gou.springcloud.nacosprovider.service.impl;

import com.alibaba.fastjson.JSON;
import com.gou.springcloud.nacosprovider.dao.UserInfoDao;
import com.gou.springcloud.nacosprovider.entity.UserInfo;
import com.gou.springcloud.nacosprovider.service.UserInfoService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author goujianjun
 * @date 2019-06-10 15:45
 */

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public String userInfo() {
        List<UserInfo> userInfoList = userInfoDao.selectAll();
        if (CollectionUtils.isNotEmpty(userInfoList)) {
            return JSON.toJSONString(userInfoList);
        }
        return null;
    }
}
