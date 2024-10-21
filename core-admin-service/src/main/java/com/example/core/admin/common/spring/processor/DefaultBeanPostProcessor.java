package com.example.core.admin.common.spring.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author hy
 * @title: DefaultBeanPostProcessor
 * @projectName core-admin
 * @description: TODO
 * @date 2024-10-21 15:54:29 15:54
 *
 * BeanPostProcessor接口来在每个Bean初始化时执行一些自定义操作，包括打印日志。
 * BeanPostProcessor允许您在Bean初始化前后进行处理。
 * 通过实现这个接口，可以在Spring容器管理的每个Bean初始化时打印一条消息。
 *
 * 类似的：
 * InitializingBean接口：允许在Bean属性设置完毕后执行自定义初始化逻辑。
 * DisposableBean接口：允许在Bean销毁时执行自定义清理逻辑。
 * 注解@PostConstruct：用于标注在Bean初始化完成后需要执行的方法。
 * 注解@PreDestroy：用于标注在Bean销毁前需要执行的方法。
 * BeanFactoryPostProcessor：允许在BeanFactory标准初始化之后但在任何Bean实例化之前对Bean定义进行修改。
 * ApplicationContextAware：使Bean能够获取ApplicationContext对象，从而可以在需要时手动获取其他Bean。
 */
@Component
@Slf4j
public class DefaultBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 这里是每个bean初始化之前执行的逻辑
        if (log.isDebugEnabled()){
            log.debug("######Bean '{}' 即将被初始化。", beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 打印初始化后每个bean的信息
        if (log.isDebugEnabled()){
            log.debug("######Bean '{}' 已经被初始化。", beanName);
        }
        return bean;
    }
}
