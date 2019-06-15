package com.gou.springcloud.common.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Set;

/**
 * @author goujianjun
 * @date 2019/5/29 21:46
 */
public class RedisUtilTool {
    @Autowired
    private RedisTemplate<Serializable, Object> redisTemplate;
    @Autowired
    private ValueOperations valueOperations;
    @Autowired
    private HashOperations hashOperations;
    @Autowired
    private ZSetOperations zSetOperations;
    @Autowired
    private ListOperations listOperations;
    @Autowired
    private SetOperations setOperations;

    /**
     * 字符串添加操作
     *
     * @param key
     * @param value
     */
    public void addString(Serializable key, Object value) {
        valueOperations.set(key, value);
    }

    /**
     * @param key
     * @return
     */
    public Object getValueByKey(Serializable key) {
        return valueOperations.get(key);
    }

    /**
     * 删除相应的值
     *
     * @param key
     */
    public void rmString(Serializable key) {
        redisTemplate.delete(key);
    }

    /**
     * 散列添加对应的值
     *
     * @param key
     * @param key1
     * @param value
     */
    public void addHmset(Serializable key, Serializable key1, Object value) {
        hashOperations.put(key, key1, value);
    }

    /**
     * 散列获取指定key的值
     *
     * @param key
     * @param key1
     * @return
     */
    public Object getHmset(Serializable key, Serializable key1) {
        return hashOperations.get(key, key1);
    }

    /**
     * 有序集合添加元素
     */
    public void addZset(Serializable key, Object value, Double core) {
        zSetOperations.add(key, value, core);
    }

    /**
     * 有序集合，获取区间的值
     *
     * @param key
     * @param mix
     * @param max
     * @return
     */
    public Set getZset(Serializable key, Long mix, Long max) {
        return zSetOperations.range(key, mix, max);
    }

    /**
     * 从左侧推入元素
     *
     * @param key
     * @param value
     */
    public void addLeftPushList(Serializable key, Object value) {
        listOperations.leftPush(key, value);
    }

    /**
     * 从左侧取出第一个元素，并且从redis中删除
     *
     * @param key
     */
    public Object leftPop(Serializable key) {
        return listOperations.leftPop(key);
    }

    /**
     * set 添加元素
     *
     * @param key
     * @param value
     */
    public void addSet(Serializable key, Object value) {
        setOperations.add(key, value);
    }

    /**
     * 删除指定的值，返回删除个数
     *
     * @param key
     * @param value
     * @return
     */
    public Long rmSet(Serializable key, Object value) {
        return setOperations.remove(key, value);
    }

}
