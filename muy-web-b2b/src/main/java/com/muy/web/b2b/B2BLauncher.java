package com.muy.web.b2b;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.muy.plugins.spring.boot.annotation.EnablePluginsConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by yanglikai on 2018/1/27.
 */
@SpringBootApplication
@EnableDubboConfiguration
@EnablePluginsConfiguration
public class B2BLauncher {
  public static void main(String[] args) {
    SpringApplication.run(B2BLauncher.class, args);
  }
}
