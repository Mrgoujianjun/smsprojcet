package com.gou.springcloud.nacosprovider.config;

import com.gou.springcloud.common.basic.TokenInspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author goujianjun
 * @date 2019-07-09 16:46
 */
@Configuration
@EnableWebMvc
public class WebSecurityConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInspect()).addPathPatterns("/**");
    }

    @Bean
    public TokenInspect tokenInspect(){
        return new TokenInspect();
    }
}
