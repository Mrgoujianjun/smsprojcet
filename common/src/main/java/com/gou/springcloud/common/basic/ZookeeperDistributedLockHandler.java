package com.gou.springcloud.common.basic;

import com.gou.springcloud.common.bean.ZookeeperAbstractLock;
import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

/**
 * @author goujianjun
 * @email lygoujianjun@163.com
 * @date 2020-03-03 10:53
 * zookeeper 创建分布式锁
 */

public class ZookeeperDistributedLockHandler extends ZookeeperAbstractLock {
    private CountDownLatch countDownLatch = null;
    @Override
    public boolean tryLock() {
        try {
            zkClient.createEphemeral(lockPath);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public void waitLock() {
        IZkDataListener dataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        };
        zkClient.subscribeDataChanges(lockPath, dataListener);
        if (zkClient.exists(lockPath)) {
            countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        zkClient.unsubscribeDataChanges(lockPath, dataListener);
    }
}
