package com.gou.springcloud.common.basic;

import com.gou.springcloud.common.tools.RedisUtilTool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @author goujianjun
 * @date 2019-07-09 16:49
 */
@Component
@RefreshScope
public class TokenInspect implements HandlerInterceptor {
    @Resource
    private RedisUtilTool redisUtilTool;
    @Value("${authorToken}")
    private String authorToken;
    @Value("${ignorePath}")
    private String ignorePath;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (StringUtils.isNotEmpty(ignorePath)) {
            List<String> paths = Arrays.asList(StringUtils.split(ignorePath, ","));
            if (paths.contains(request.getPathInfo())) {
                return true;
            }
        }

        String token = request.getParameter(authorToken);
        if (StringUtils.isNotEmpty(token)) {
            Object username = redisUtilTool.getValueByKey(token);
            if (username == null) {
                return false;
            }
        }
        return true;
    }

}
