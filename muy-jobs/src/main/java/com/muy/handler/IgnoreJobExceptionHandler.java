package com.muy.handler;

import com.dangdang.ddframe.job.executor.handler.JobExceptionHandler;

/**
 * Created by yanglikai on 2018/3/13.
 */
public class IgnoreJobExceptionHandler implements JobExceptionHandler {
  /**
   * 处理作业异常.
   *
   * @param jobName 作业名称
   * @param cause   异常原因
   */
  @Override
  public void handleException(String jobName, Throwable cause) {
    System.out.println("IgnoreJobExceptionHandler.handleException()");
  }
}
