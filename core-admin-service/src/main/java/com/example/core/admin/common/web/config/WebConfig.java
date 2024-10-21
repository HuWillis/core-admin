package com.example.core.admin.common.web.config;

import com.example.core.admin.common.web.interceptor.TenantInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author hy
 * @title: WebConfig
 * @projectName core-admin
 * @description: TODO
 * @date 2024-10-21 15:37:48 15:37
 */
@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final TenantInterceptor tenantInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tenantInterceptor)
            // 拦截所有请求
            .addPathPatterns("/**");
    }
}
