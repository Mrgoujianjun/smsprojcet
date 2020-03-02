package com.gou.springcloud.common.enums;

/**
 * @author goujianjun
 * @date 2020-03-01 21:48
 */
public interface BaseEnum<K, V>{
    /**
     * 编码
     * @return
     */
    K getCode();

    /**
     * 消息
     * @return
     */
    V getMessage();
}
