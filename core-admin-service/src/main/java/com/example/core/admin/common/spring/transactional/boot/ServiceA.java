package com.example.core.admin.common.spring.transactional.boot;

import lombok.RequiredArgsConstructor;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hy
 * @title: ServiceA
 * @projectName core-admin
 * @description: TODO
 * @date 2024-10-21 16:09:26 16:09
 *
 * 事务的传播行为：定义了事务方法之间如何相互影响，如何在多方法调用中管理事务的边界。
 * REQUIRED（默认）	有事务则加入，没有则创建。
 * REQUIRES_NEW	总是新建事务，暂停当前事务。
 * SUPPORTS	有事务则加入，没有则以非事务方式执行。
 * NOT_SUPPORTED	总是以非事务方式执行，暂停当前事务。
 * NEVER	强制非事务执行，如果存在事务则抛出异常。
 * MANDATORY	必须在事务中执行，如果没有事务则抛出异常。
 * NESTED	如果有事务则开启嵌套事务，没有则新建事务。
 *
 * 事务的隔离级别：决定事务之间并发访问数据的隔离程度，影响脏读、不可重复读和幻读等问题。隔离级别越高，数据一致性越强，但性能越差。
 */
@Service
@RequiredArgsConstructor
public class ServiceA {
    private final ServiceB serviceB;

    /**
     * 事务方法
     * ServiceA 中的 methodA() 方法被事务管理。
     * 如果 methodB() 抛出异常，整个事务都会回滚。
     * 因为默认的 Propagation.REQUIRED 传播级别会加入现有的事务
     */
    @Transactional(rollbackFor = Exception.class)
    public void methodA() {
        // 调用另一个服务的方法
        serviceB.methodB();
        // 其他操作
    }

    /**
     * methodC() 的事务不会按照预期创建，因为它是 methodB() 内部调用的
     * 解决方法:
     * 1、拆分成不同的 Service 类：
     * 将 methodB() 放到另一个 Service 中，这样通过代理就能正常创建事务。

     * 2、使用 AopContext 强制通过代理调用：
     * 通过 AopContext 来获取当前对象的代理实例，确保内部方法调用仍然通过代理执行。
     */
    @Transactional
    public void methodB() {
        // 同类中的方法调用
        // methodC();

        // 通过代理调用
        ((ServiceA) AopContext.currentProxy()).methodC();

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void methodC() {
        // methodB 的操作
    }
}
