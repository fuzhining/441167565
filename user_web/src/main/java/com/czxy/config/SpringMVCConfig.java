package com.czxy.config;

import com.czxy.imterceptor.Userlnterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

//@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {

    @Resource
   private Userlnterceptor userlnterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(userlnterceptor);
        interceptorRegistration.addPathPatterns("/**");
    }
}
