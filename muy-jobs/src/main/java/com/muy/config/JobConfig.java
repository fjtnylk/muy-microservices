package com.muy.config;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.muy.handler.IgnoreJobExceptionHandler;
import com.muy.jobs.MyElasticJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yanglikai on 2018/3/12.
 */
//@Configuration
public class JobConfig {

  @Bean
  public JobCoreConfiguration simpleCoreConfig() {
    return
        JobCoreConfiguration.newBuilder("test_job", "0/5 * * * * ?", 3)
            .shardingItemParameters("0=A,1=B,2=C").jobParameter("param").failover(true).misfire(false).description("desc")
            .jobProperties("job_exception_handler", IgnoreJobExceptionHandler.class.getName()).build();
  }

  @Bean
  public SimpleJobConfiguration jobTypeConfig() {
    return
        new SimpleJobConfiguration(simpleCoreConfig(), MyElasticJob.class.getCanonicalName());
  }

  @Bean
  public CoordinatorRegistryCenter createRegistryCenter() {
    CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration("127.0.0.1:2181", "myNamespace"));
    regCenter.init();
    return regCenter;
  }

  @Bean
  public LiteJobConfiguration liteJobConfig() {
    return LiteJobConfiguration.newBuilder(jobTypeConfig()).build();
  }

  @Bean
  public JobScheduler jobScheduler() {
    JobScheduler jobScheduler = new JobScheduler(createRegistryCenter(), liteJobConfig());
    jobScheduler.init();
    return jobScheduler;
  }
}
