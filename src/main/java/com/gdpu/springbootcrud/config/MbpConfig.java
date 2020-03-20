package com.gdpu.springbootcrud.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Descriptin TODO
 * @Author AlanLiang
 * Date 2020/3/18 23:05
 * Version 1.0
 **/
@Configuration
@MapperScan("com.gdpu.springbootcrud.mapper")
public class MbpConfig {

    /*注入分页插件*/
    @Bean
    public PaginationInterceptor paginationInterceptor() {

        return new PaginationInterceptor();
    }
}
