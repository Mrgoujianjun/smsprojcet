package com.gou.springcloud.security.comm.config;

import com.gou.springcloud.security.comm.bean.UserAuthenticationProvider;
import com.gou.springcloud.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author goujianjun
 * @email lygoujianjun@163.com
 * @date 2020-03-01 21:51
 */
@Configuration
@EnableWebSecurity
public class AuthorSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder()).and().authenticationProvider(userAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().requestMatchers().antMatchers("/oauth/**").and().authorizeRequests()
                .antMatchers("/oauth/**").permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public RedisTemplate redisTemplate(){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
    @Bean
    public Jackson2JsonRedisSerializer jackson2JsonRedisSerializer() {
        return new Jackson2JsonRedisSerializer(Object.class);
    }

    @Bean
    public ValueOperations valueOperations() {
        return redisTemplate().opsForValue();
    }

    @Bean
    public HashOperations hashOperations() {
        return redisTemplate().opsForHash();
    }

    @Bean
    public ListOperations listOperations() {
        return redisTemplate().opsForList();
    }

    @Bean
    public SetOperations setOperations() {
        return redisTemplate().opsForSet();
    }

    @Bean
    public ZSetOperations zSetOperations() {
        return redisTemplate().opsForZSet();
    }
}
