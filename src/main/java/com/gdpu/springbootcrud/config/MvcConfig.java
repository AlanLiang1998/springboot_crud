package com.gdpu.springbootcrud.config;

import com.gdpu.springbootcrud.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Descriptin TODO
 * @Author AlanLiang
 * Date 2020/3/18 16:57
 * Version 1.0
 **/
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main").setViewName("main");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                //拦截所有访问路径
                .addPathPatterns("/**")
                //去除登录路径
                .excludePathPatterns("/", "index.html", "/user/login")
                //去除静态资源路径
                .excludePathPatterns("/bootstrap/**", "/asserts/**");
    }

}
