package com.example.core.admin.common.mybatis.context;

/**
 * @author hy
 * @title: TenantContext
 * @projectName core-admin
 * @description: TODO
 * @date 2024-10-21 15:27:32 15:27
 */
public class TenantContext {
    private static final ThreadLocal<String> TENANT_THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 设置租户ID
     * @param tenantId 租户ID
     */
    public static void setTenantId(String tenantId) {
        TENANT_THREAD_LOCAL.set(tenantId);
    }

    /**
     * 获取租户ID
     * @return 租户ID
     */
    public static String getTenantId() {
        return TENANT_THREAD_LOCAL.get();
    }

    /**
     * 清除租户ID
     */
    public static void clear() {
        TENANT_THREAD_LOCAL.remove();
    }

}
