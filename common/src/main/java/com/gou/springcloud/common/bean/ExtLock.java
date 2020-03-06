package com.gou.springcloud.common.bean;

/**
 * @author goujianjun
 * @email lygoujianjun@163.com
 * @date 2020-03-03 10:56
 */

public interface ExtLock {
    void getLock();
    void unLock();
}
