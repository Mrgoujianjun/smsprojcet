package com.gou.springcloud.smsgateway.config;

import com.gou.springcloud.smsgateway.common.MyBalanceHandler;
import com.gou.springcloud.smsgateway.common.MyLoadBalanceRule;
import com.gou.springcloud.smsgateway.common.VerifyUserInfo;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.gateway.config.LoadBalancerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author goujianjun
 * @date 2019-06-13 16:34
 */
@Configuration
public class SmsGatewayConfig {
    @Bean
    public VerifyUserInfo verifyUserInfo() {
        return new VerifyUserInfo();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 自定义负载均衡机制
     *
     * @param loadBalancer
     * @param properties
     * @return
     */
    @Bean
    public MyBalanceHandler myBalanceHandler(LoadBalancerClient loadBalancer, LoadBalancerProperties properties) {
        return new MyBalanceHandler(loadBalancer, properties);
    }

    @Bean
    public MyLoadBalanceRule myLoadBalanceRule() {
        return new MyLoadBalanceRule();
    }
}
