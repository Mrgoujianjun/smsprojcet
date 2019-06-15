package com.gou.springcloud.smsgateway.config;

import com.gou.springcloud.smsgateway.common.VerifyUserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author goujianjun
 * @date 2019-06-13 16:34
 */
@Configuration
public class SmsGatewayConfig {
    @Bean
    public VerifyUserInfo verifyUserInfo(){
        return new VerifyUserInfo();
    }
}
