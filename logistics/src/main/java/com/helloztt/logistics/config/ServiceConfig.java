package com.helloztt.logistics.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Created by helloztt on 2016/5/6.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.huotu.agento2o.service")
@EnableJpaRepositories(
        basePackages = "com.helloztt.logisticsService",
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager"
)
@ImportResource({"classpath:config.xml"})
public class ServiceConfig {
}
