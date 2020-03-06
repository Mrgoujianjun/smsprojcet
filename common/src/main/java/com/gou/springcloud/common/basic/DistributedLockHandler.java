package com.gou.springcloud.common.basic;

import com.gou.springcloud.common.bean.Lock;
import com.gou.springcloud.common.tools.RedisUtilTool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author goujianjun
 * @email lygoujianjun@163.com
 * @date 2020-03-02 16:16
 * redis 分布式锁
 */
@Component
@Slf4j
public class DistributedLockHandler {
    /**
     * 锁的过期时间
     */
    private final static Long LOCK_EXPIRE = 30 * 1000L;
    /**
     * 30ms尝试一次
     */
    private final static Long LOCK_TRY_INTERVAL = 30L;
    /**
     * 20秒超时时间
     */
    private final static Long LOCK_TRY_TIMEOUT = 20 * 1000L;
    @Autowired
    private RedisUtilTool redisUtilTool;

    /**
     * 获取全局锁
     *
     * @param lock 锁
     * @return true获取成功
     */
    public boolean tryLock(Lock lock) {
        return getLock(lock, LOCK_TRY_TIMEOUT, LOCK_TRY_INTERVAL, LOCK_EXPIRE);
    }

    /**
     * 尝试获取全局锁
     *
     * @param lock
     * @param timeout
     * @return
     */
    public boolean tryLock(Lock lock, long timeout) {
        return getLock(lock, timeout, LOCK_TRY_INTERVAL, LOCK_EXPIRE);
    }

    /**
     * 尝试获取全局锁
     *
     * @param lock
     * @param timeout
     * @param tryInterval
     * @return
     */
    public boolean tryLock(Lock lock, long timeout, long tryInterval) {
        return getLock(lock, timeout, tryInterval, LOCK_EXPIRE);
    }

    /**
     * 尝试获取全局锁
     *
     * @param lock
     * @param timeout
     * @param tryInterval
     * @param lockExpireTime
     * @return
     */
    public boolean tryLock(Lock lock, long timeout, long tryInterval, long lockExpireTime) {
        return getLock(lock, timeout, tryInterval, lockExpireTime);
    }

    /**
     * 操作redis获取全局锁
     *
     * @param lock
     * @param timeout
     * @param tryInterval
     * @param lockExpireTime
     * @return
     */
    public boolean getLock(Lock lock, long timeout, long tryInterval, long lockExpireTime) {
        try {
            if (StringUtils.isEmpty(lock.getName()) || StringUtils.isEmpty(lock.getValue())) {
                return false;
            }
            long startTime = System.currentTimeMillis();
            do {
                if (!redisUtilTool.hasKey(lock.getName())) {
                    redisUtilTool.addExpireStr(lock.getName(), lock.getValue(), lockExpireTime, TimeUnit.MILLISECONDS);
                    return true;
                } else {
                    log.warn("lock is exist !");
                }
                if (System.currentTimeMillis() - startTime > timeout) {
                    return false;
                }
                Thread.sleep(tryInterval);
            } while (true);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return false;
    }

    public void releaseLock(Lock lock) {
        if (StringUtils.isNotEmpty(lock.getName())) {
            redisUtilTool.rmString(lock.getName());
        }
    }

}
