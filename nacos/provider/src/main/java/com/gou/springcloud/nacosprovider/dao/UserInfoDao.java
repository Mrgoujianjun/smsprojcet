package com.gou.springcloud.nacosprovider.dao;

import com.gou.springcloud.nacosprovider.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * @author goujianjun
 * @date 2019-06-10 15:46
 */
@Component
@Mapper
public interface UserInfoDao extends BaseMapper<UserInfo> {
}
