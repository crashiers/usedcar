package com.cn.jhsoft.usedcar.config;

import com.cn.jhsoft.usedcar.common.xss.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import java.util.ArrayList;

/**
 * Filter配置
 *
 * @author jhsoft
 * @email hn1987@126.com
 * @date 2017-04-21 21:56
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean shiroFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        //该值缺省为false，表示生命周期由SpringApplicationContext管理，设置为true则表示由ServletContainer管理
        registration.addInitParameter("targetFilterLifecycle", "true");
        registration.setEnabled(true);
        registration.setOrder(Integer.MAX_VALUE - 1);
        registration.addUrlPatterns("/*");
        return registration;
    }

    @Bean
    public FilterRegistrationBean xssFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new XssFilter());

        // 添加过滤地址
        ArrayList<String> match = new ArrayList<>();
        match.add("/sys/*");
        match.add("/job/*");
        match.add("/*/*");
        registration.setUrlPatterns(match);

        registration.setName("xssFilter");
        registration.setOrder(Integer.MAX_VALUE);
        return registration;
    }

    /**
     * 统一给 product模块的 页面赋值  code和codeName
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        // 这种方式设置，则menuFilter中可以用 @Autowired，  需要在Filter上加上  @Component("codeFilter")
        registrationBean.setFilter(new DelegatingFilterProxy("codeFilter"));
        //该值缺省为false，表示生命周期由SpringApplicationContext管理，设置为true则表示由ServletContainer管理
        registrationBean.addInitParameter("targetFilterLifecycle", "true");

        ArrayList<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/product/*");
        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.setName("codeFilter");
        return registrationBean;
    }


}
