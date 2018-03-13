package com.muy;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableDubboConfiguration
public class MuyJobsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuyJobsApplication.class, args);
	}
}
