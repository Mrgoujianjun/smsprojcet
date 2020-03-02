package com.gou.springcloud.security.comm.config;

import com.gou.springcloud.security.comm.bean.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author goujianjun
 * @email lygoujianjun@163.com
 * @date 2020-03-01 22:04
 */
@Configuration
public class AuthorWebAdapter implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handlerInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public HandlerInterceptor handlerInterceptor() {
        return new AuthenticationInterceptor();
    }
}
