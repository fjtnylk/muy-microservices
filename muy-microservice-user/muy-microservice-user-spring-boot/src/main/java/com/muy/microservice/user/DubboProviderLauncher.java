package com.muy.microservice.user;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDubboConfiguration
public class DubboProviderLauncher {

	public static void main(String[] args) {
		SpringApplication.run(DubboProviderLauncher.class, args);
	}
}
