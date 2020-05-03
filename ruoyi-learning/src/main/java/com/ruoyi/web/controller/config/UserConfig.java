package com.ruoyi.web.controller.config;

import com.ruoyi.web.controller.filter.UserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.config
 * @ClassName: 配置类
 * @Author: 胡天霸
 * @Date: 2020/5/2 11:50
 * @Version: 1.0
 */
@Configuration
public class UserConfig {
    @Bean
    public FilterRegistrationBean someFilterRegistration1() {
        // 过滤器注册类
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 添加过滤器
        registration.setFilter( new UserFilter());
        registration.addUrlPatterns("/learning");
        return registration;
    }
}
