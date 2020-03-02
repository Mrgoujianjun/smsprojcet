package com.gou.springcloud.security.dao;

import com.gou.springcloud.security.model.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author goujianjun
 * @date 2020-03-01 21:58
 */
@Component
@Mapper
public interface UserDao extends BaseDao<User> {
    /**
     * 用户查询
     *
     * @param userDO
     * @return
     */
    List<User> findUsers(User userDO);

    /**
     * 判断当前数据库中是否存在用户信息
     * @param username
     * @return
     */
    Integer getUserByUsername(String username);

    /**
     * 新增用户
     * @param user
     * @return
     */
    Integer addUser(User user);

    /**
     * 用户信息更新
     * @param user
     */
    void updateById(User user);

    /**
     * 删除用户信息
     * @param id
     */
    void deleteById(String id);
}
