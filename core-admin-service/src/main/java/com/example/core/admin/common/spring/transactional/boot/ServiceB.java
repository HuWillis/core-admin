package com.example.core.admin.common.spring.transactional.boot;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hy
 * @title: ServiceB
 * @projectName core-admin
 * @description: TODO
 * @date 2024-10-21 16:09:42 16:09
 */
@Service
public class ServiceB {
    /**
     * Propagation.REQUIRED（默认）：当前方法需要事务，如果调用方法已存在事务，则加入该事务；否则创建新事务。
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void methodB() {
        // ServiceB 的数据库操作
    }
}
