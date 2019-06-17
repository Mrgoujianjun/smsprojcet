package com.gou.springcloud.smsgateway.common;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.math.RandomUtils;

import java.util.List;

/**
 * @author goujianjun
 * @date 2019-06-15 11:46
 * 自定义负责均衡规则
 */

public class MyLoadBalanceRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        List<Server> serverList = this.getLoadBalancer().getReachableServers();
        if (CollectionUtils.isEmpty(serverList)) {
            return null;
        }
        if (serverList.size() == 1) {
            return serverList.get(0);
        }
        if (key == null) {
            return randomServer(serverList);
        }
        return getServer(serverList,key);
    }

    /**
     * 随机生成server服务
     *
     * @param servers
     * @return
     */
    private Server randomServer(List<Server> servers) {
        int index = RandomUtils.nextInt(servers.size());
        return servers.get(index);
    }

    /**
     * @param servers
     * @param key
     * @return
     */
    private Server getServer(List<Server> servers, Object key) {
        int num = Math.abs(key.hashCode());
        if (num < servers.size()) {
            return servers.get(num);
        }

        int resNum = num % servers.size();
        return servers.get(resNum);
    }
}
