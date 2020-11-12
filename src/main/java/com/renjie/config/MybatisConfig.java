package com.renjie.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: fan
 * @Date: 2020/11/12
 * @Description:
 */
@Configuration
@EnableTransactionManagement
public class MybatisConfig {

    //注册乐观锁插件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor ();
    }

    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //设置请求的页面大于最大页后操作，true调回到首页，false继续请求 默认false
//        paginationInterceptor.setOverflow(false);
        //设置最大单页限制数量，默认500 条，-1不受影响
//        paginationInterceptor.setLimit(500);
        //开启 count 的join优化，只针对部分left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));

        return  paginationInterceptor;
    }





}
