package com.example.core.admin.common.mybatis.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import com.example.core.admin.common.mybatis.handler.DefaultTenantHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hy
 * @title: MybatisPlusConfig
 * @projectName core-admin
 * @description: TODO
 * @date 2024-10-21 15:30:04 15:30
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(DefaultTenantHandler tenantHandler) {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加多租户拦截器
        interceptor.addInnerInterceptor(new TenantLineInnerInterceptor(tenantHandler));
        return interceptor;
    }
}
