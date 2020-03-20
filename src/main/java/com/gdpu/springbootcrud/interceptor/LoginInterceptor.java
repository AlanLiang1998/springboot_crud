package com.gdpu.springbootcrud.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Descriptin 添加登录拦截器
 * @Author AlanLiang
 * Date 2020/3/18 17:47
 * Version 1.0
 **/
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object username = request.getSession().getAttribute("username");
        if (username != null) {
            //已登录则放行
            return true;
        } else {
            //未登录则返回登录页面
            response.sendRedirect("/");
            return false;
        }
    }
}
