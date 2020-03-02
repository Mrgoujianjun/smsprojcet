package com.gou.springcloud.security.dao;

import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author goujianjun
 * @date 2020-03-01 21:59
 */
@Component
public interface BaseDao<T> extends Mapper<T>, MySqlMapper<T> {
}
