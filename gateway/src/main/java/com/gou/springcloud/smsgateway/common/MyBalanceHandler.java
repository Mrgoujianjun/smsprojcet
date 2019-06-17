package com.gou.springcloud.smsgateway.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.gateway.config.LoadBalancerProperties;
import org.springframework.cloud.gateway.filter.LoadBalancerClientFilter;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.server.ServerWebExchange;

import java.net.URI;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;

/**
 * @author goujianjun
 * @date 2019-06-15 11:26
 * 自定义负载均衡器
 */

public class MyBalanceHandler extends LoadBalancerClientFilter {

    public MyBalanceHandler(LoadBalancerClient loadBalancer, LoadBalancerProperties properties) {
        super(loadBalancer, properties);
    }

    @Override
    protected ServiceInstance choose(ServerWebExchange exchange) {
        String userId = exchange.getRequest().getHeaders().getFirst("userId");
        if (StringUtils.isEmpty(userId)) {
            return super.choose(exchange);
        }

        if (this.loadBalancer instanceof RibbonLoadBalancerClient) {
            RibbonLoadBalancerClient ribbonLoadBalancerClient = (RibbonLoadBalancerClient) this.loadBalancer;
            String host = ((URI) exchange.getAttribute(GATEWAY_REQUEST_URL_ATTR)).getHost();
            //用户id作为负责均衡客户端的key
            return ribbonLoadBalancerClient.choose(host, userId);
        }
        return super.choose(exchange);
    }

}
