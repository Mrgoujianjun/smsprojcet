package com.gou.springcloud.smsgateway.common;

import com.gou.springcloud.common.tools.RedisUtilTool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author goujianjun
 * @date 2019-06-05 14:40
 */
@Component
@RefreshScope
public class MyGlobalFilter implements GlobalFilter, Ordered {

    @Resource
    private RedisUtilTool redisUtilTool;
    @Value("${authorToken}")
    private String authorToken;

    @Value("${ignorePath:null}")
    private String ignorePath;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (ignorePath != null) {
            List<String> paths = Arrays.asList(StringUtils.split(ignorePath, ","));
            if (paths.contains(exchange.getRequest().getURI().getPath())) {
                chain.filter(exchange);
            }
        }
        List<String> tokens = exchange.getRequest().getHeaders().get(authorToken);
        if (CollectionUtils.isEmpty(tokens) || StringUtils.isEmpty(tokens.get(0))) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        } else {
            if (redisUtilTool.getValueByKey(authorToken) == null) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
