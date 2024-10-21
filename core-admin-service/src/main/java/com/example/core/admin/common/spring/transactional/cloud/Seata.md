使用 Seata 来解决微服务分布式事务问题
Seata 提供了多种模式（如 AT 模式、TCC 模式、Saga 模式和 XA 模式），最常用的是 AT 模式，它通过自动代理数据库本地事务实现全局事务管理。
AT模式：自动分布式事务，结合数据库的本地事务和全局事务，通常用于较轻量级的事务场景。
TCC模式：开发者需要定义Try、Confirm、Cancel三个阶段来处理事务。
Saga模式：支持长事务的有序回滚机制。
XA模式：实现两阶段提交协议（2PC）。


XA协议是一种分布式事务协议，通常由数据库系统提供（如MySQL、PostgreSQL等）
它是两阶段提交（2PC）的实现。通过XA协议，数据库本身可以确保多个数据库实例之间的一致性。

优点：
数据库原生支持，开发相对简单。
缺点：
XA事务性能较差，不适合高并发、高吞吐的微服务场景。
资源长时间锁定，可能导致系统瓶颈。

两阶段提交（2PC, Two-Phase Commit）
两阶段提交协议（2PC）是一种经典的分布式事务协议，通常在数据库之间协调事务。它将事务分为两个阶段：
第一阶段：准备阶段（Prepare Phase）：协调者向所有参与者发出请求，询问它们是否准备好提交事务。参与者执行事务但不提交，并返回“准备好”或“失败”。
第二阶段：提交阶段（Commit Phase）：如果所有参与者都准备好，协调者发出提交命令；如果有一个参与者未准备好，协调者发出回滚命令。
优点：
能够确保所有服务都同时提交或回滚。
缺点：
2PC协议开销大，协调者是单点故障。
在高并发场景下，性能较差。
容易导致长时间锁定资源，降低系统吞吐量。


1. 引入Seata依赖
<dependency>
    <groupId>io.seata</groupId>
    <artifactId>seata-all</artifactId>
    <version>最新版本号</version>
</dependency>

<!-- 使用的是 Spring Cloud Alibaba，则可以添加如下依赖 -->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-seata</artifactId>
    <version>最新版本号</version>
</dependency>

2. 配置 Seata 服务器
下载并启动 Seata Server: https://github.com/apache/incubator-seata/releases

解压并修改配置文件 conf/file.conf 中的 store.mode 配置项，决定事务日志存储方式（file、db等）
store {
  mode = "db"
  db {
    datasource = "druid"
    dbType = "mysql"
    driverClassName = "com.mysql.jdbc.Driver"
    url = "jdbc:mysql://127.0.0.1:3306/seata"
    user = "root"
    password = "root"
  }
}

启动 Seata Server：sh ./bin/seata-server.sh -p 8091 -h 127.0.0.1

在数据库中创建 Seata 事务日志表：
-- SQL for MySQL
CREATE TABLE `global_table` (
  `xid` varchar(128) NOT NULL,
  `transaction_id` bigint(20) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `application_id` varchar(32) DEFAULT NULL,
  `transaction_service_group` varchar(32) DEFAULT NULL,
  `transaction_name` varchar(128) DEFAULT NULL,
  `timeout` int(11) DEFAULT NULL,
  `begin_time` bigint(20) DEFAULT NULL,
  `application_data` varchar(2000) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`xid`),
  KEY `idx_gmt_modified_status` (`gmt_modified`,`status`),
  KEY `idx_transaction_id` (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

3. 配置微服务中的 Seata 客户端
在 application.yml 中配置 Seata：
spring:
  cloud:
    alibaba:
      seata:
        tx-service-group: my_tx_group   # 事务组名称

Seata 客户端配置文件（file.conf 和 registry.conf）

file.conf：用于配置事务日志存储
service {
  vgroupMapping.my_tx_group = "default"   # 事务组映射
  default.grouplist = "127.0.0.1:8091"    # Seata Server 地址
}

registry.conf：用于配置 Seata 服务发现
registry {
  type = "nacos"  # 使用 Nacos 作为注册中心，支持 Eureka、Zookeeper 等
  nacos {
    serverAddr = "127.0.0.1:8848"
  }
}
config {
  type = "nacos"
  nacos {
    serverAddr = "127.0.0.1:8848"
  }
}

4. 使用 @GlobalTransactional 开启全局事务
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OrderService {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private PaymentService paymentService;

    @GlobalTransactional(name = "order-create-transaction", rollbackFor = Exception.class)
    public void createOrder(Order order) {
        // 扣减库存
        inventoryService.decreaseStock(order.getProductId(), order.getQuantity());
        // 扣减用户账户余额
        paymentService.decreaseBalance(order.getUserId(), order.getAmount());
        // 创建订单
        orderDao.save(order);
    }
}

5. 数据库配置：代理数据源
Seata 的 AT 模式需要代理数据库操作，以便自动生成回滚日志。在 application.yml 中配置 Seata 代理数据源。

spring:
  seata:
    datasource:
      proxy-mode: AT    # 启用 Seata 的 AT 模式代理数据源




