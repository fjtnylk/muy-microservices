package com.muy.microservice.user.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by yanglikai on 2017/9/5.
 */
@Configuration
@ComponentScan(value = "com.muy.microservice.user")
@Import({DatasourceConfig.class, MybatisConfig.class})
public class AppConfig {
}
