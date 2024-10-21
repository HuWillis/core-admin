package com.example.core.admin.common.spring.spi;

import javax.annotation.PostConstruct;

/**
 * @author hy
 * @title: CoreSpringBootPatternServiceImpl
 * @projectName core-admin
 * @description: TODO
 * @date 2024-10-21 16:50:44 16:50
 *
 * 在 Spring Boot 中，SPI（Service Provider Interface） 机制用于模块化设计和动态扩展。
 * SPI 是 Java 原生的一种机制，可以在运行时动态加载不同的服务实现，常用于框架级别的插件式开发。
 * Spring Boot 也支持这种机制，用于动态地发现和加载实现类。
 *
 * SPI 机制的工作原理
 * 定义接口（服务接口）：一个接口由客户端代码调用。
 * 提供接口实现（服务实现）：多个服务提供者可以实现这个接口。
 * 通过 SPI 加载服务实现：客户端代码通过 Java 提供的 ServiceLoader 类动态加载服务实现。
 */
public class CoreSpringBootPatternServiceImpl implements PrintService {

    @Override
    public void printPattern() {
        System.out.println("   ____                  ____             _       _   ____              _   ");
        System.out.println("  / ___| _ __ ___   __|  _ \\ _ __ ___   | | __ _| | | __ )  __ _  ___| |_ ");
        System.out.println(" | |    | '__/ _ \\ / _` | |_) | '_ ` _ \\ | |/ _` | | |  _ \\ / _` |/ _ \\ __|");
        System.out.println(" | |___ | | | (_) | (_| |  __/| | | | | || | (_| | | | |_) | (_| |  __/ |_ ");
        System.out.println("  \\____||_|  \\___/ \\__,_|_|   |_| |_| |_||_|\\__,_|_| |____/ \\__, |\\___|\\__|");
        System.out.println("                                                         |___/            ");
    }


}
