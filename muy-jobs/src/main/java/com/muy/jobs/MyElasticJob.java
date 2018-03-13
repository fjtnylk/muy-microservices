package com.muy.jobs;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikai on 2018/3/12.
 */
@Component
public class MyElasticJob implements SimpleJob {

  @Override
  public void execute(ShardingContext shardingContext) {
    switch (shardingContext.getShardingItem()) {
      case 0:
        System.out.println("---------------------start---------------------");
        System.out.println("JobName: " + shardingContext.getJobName());
        System.out.println("TaskId: " + shardingContext.getTaskId());
        System.out.println("ShardingParamter: " + shardingContext.getShardingParameter());
        System.out.println("JobParamter: " + shardingContext.getJobParameter());
        System.out.println("TotalCount: " + shardingContext.getShardingTotalCount());
        System.out.println("--------------------- end ---------------------");
        break;
      case 1:
        System.out.println("---------------------start---------------------");
        System.out.println("JobName: " + shardingContext.getJobName());
        System.out.println("TaskId: " + shardingContext.getTaskId());
        System.out.println("ShardingParamter: " + shardingContext.getShardingParameter());
        System.out.println("JobParamter: " + shardingContext.getJobParameter());
        System.out.println("TotalCount: " + shardingContext.getShardingTotalCount());
        System.out.println("--------------------- end ---------------------");
        break;
      case 2:
        //System.out.println("---------------------start---------------------");
        //System.out.println("JobName: " + shardingContext.getJobName());
        //System.out.println("TaskId: " + shardingContext.getTaskId());
        //System.out.println("ShardingParamter: " + shardingContext.getShardingParameter());
        //System.out.println("JobParamter: " + shardingContext.getJobParameter());
        //System.out.println("TotalCount: " + shardingContext.getShardingTotalCount());
        //System.out.println("--------------------- end ---------------------");
        //break;
        //throw new IllegalArgumentException("参数错误");
      case 3:
        //throw new IllegalArgumentException("参数错误");
    }
  }
}
