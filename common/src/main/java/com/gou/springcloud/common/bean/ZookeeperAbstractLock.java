package com.gou.springcloud.common.bean;

import lombok.extern.log4j.Log4j2;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author goujianjun
 * @email lygoujianjun@163.com
 * @date 2020-03-03 10:57
 */
@RefreshScope
@Log4j2
public abstract class ZookeeperAbstractLock implements ExtLock {

    @Value("${spring.cloud.zookeeper.server}")
    private String zkServer;

    protected ZkClient zkClient = new ZkClient(zkServer);

    @Value("${spring.cloud.zookeeper.path}")
    protected String lockPath;

    @Override
    public void getLock() {
        if (tryLock()) {
            log.info("锁获取成功！");
        } else {
            waitLock();
        }
    }

    @Override
    public void unLock() {
        if (zkClient != null) {
            zkClient.close();
        }
    }

    /**
     * 等待锁
     */
    public abstract void waitLock();

    /**
     * 尝试获取锁
     *
     * @return true获取成功；false 获取失败
     */
    public abstract boolean tryLock();
}
