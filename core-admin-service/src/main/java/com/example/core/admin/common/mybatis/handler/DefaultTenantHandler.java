package com.example.core.admin.common.mybatis.handler;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.example.core.admin.common.mybatis.context.TenantContext;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.springframework.stereotype.Component;

/**
 * @author hy
 * @title: DefaultTenantHandler
 * @projectName core-admin
 * @description: TODO
 * @date 2024-10-21 15:20:19 15:20
 */
@Component
public class DefaultTenantHandler implements TenantLineHandler {

    /**
     * 返回租户ID表达式，这里假设租户ID是整型的
     *
     * @return 租户ID表达式
     */
    @Override
    public Expression getTenantId() {
        // 假设获取的租户ID是从当前上下文中获得的
        String tenantId = TenantContext.getTenantId();
        return new LongValue(tenantId);
    }

    /**
     * 返回租户字段名
     *
     * @return 租户字段的名字
     */
    @Override
    public String getTenantIdColumn() {
        return "tenant_id";
    }

    /**
     * 是否进行租户过滤，通常可以针对某些表不进行过滤
     *
     * @param tableName 表名称
     * @return 是否进行过滤
     */
    @Override
    public boolean ignoreTable(String tableName) {
        // 如果某张表不需要进行租户隔离，可以在这里设置忽略
        // 比如返回 true 忽略某些公共表
        return "public_table".equalsIgnoreCase(tableName);
    }


}
