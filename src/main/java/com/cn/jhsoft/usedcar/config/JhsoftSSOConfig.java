package com.cn.jhsoft.usedcar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by chenyi9 on 2017/11/10.
 */
@Configuration
@ImportResource(locations={"classpath:conf/${spring.profiles.active}/sso.xml"})
@PropertySource("classpath:conf/${spring.profiles.active}/app.properties")
public class JhsoftSSOConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
