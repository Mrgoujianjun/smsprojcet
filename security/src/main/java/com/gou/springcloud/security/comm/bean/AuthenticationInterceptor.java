package com.gou.springcloud.security.comm.bean;

import com.gou.springcloud.common.annotation.IgnorePermission;
import com.gou.springcloud.common.bean.GlobalConstant;
import com.gou.springcloud.common.enums.ErrorCode;
import com.gou.springcloud.common.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author goujianjun
 * @email lygoujianjun@163.com
 * @date 2020-03-01 22:05
 */

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtTokenStore tokenStore;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        String ignorePerm = GlobalConstant.IGNORE_PERMISSIONS;
        if (StringUtils.contains(ignorePerm, request.getRequestURI())) {
            return true;
        }

        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            IgnorePermission ignorePermission = method.getMethodAnnotation(IgnorePermission.class);
            if (ignorePermission != null) {
                return true;
            }
        }

        if (StringUtils.isEmpty(token)) {
            throw new BusinessException(ErrorCode.TOKEN_ERROR);
        }
        OAuth2Authentication oAuth2Authentication = tokenStore.readAuthentication(token);
        if (oAuth2Authentication == null) {
            throw new BusinessException(ErrorCode.TOKEN_ERROR);
        }
        return true;
    }
}
