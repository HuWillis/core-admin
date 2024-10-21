package com.example.core.admin.common.web.interceptor;

import cn.hutool.core.util.StrUtil;
import com.example.core.admin.common.mybatis.context.TenantContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author hy
 * @title: TenantInterceptor
 * @projectName core-admin
 * @description: TODO
 * @date 2024-10-21 15:33:25 15:33
 */
@Component
public class TenantInterceptor implements HandlerInterceptor {

    /**
     * 请求拦截器，从请求头中获取租户ID，并将其设置到上下文中
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从请求头中获取租户ID
        String tenantIdStr = request.getHeader("TenantID");
        if (StrUtil.isNotBlank(tenantIdStr)) {
            // 设置租户ID到上下文
            TenantContext.setTenantId(tenantIdStr);
        } else {
            TenantContext.setTenantId("1");
        }
        return true;
    }

    /**
     * 请求处理完成后，清除租户ID上下文
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清除上下文，避免线程复用带来的问题
        TenantContext.clear();
    }
}
