package com.muy.microservice.user.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.muy.microservice.user.properties.MysqlProperties;
import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import io.shardingjdbc.core.api.config.MasterSlaveRuleConfiguration;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by yanglikai on 2017/9/5.
 */
@Configuration
@AutoConfigureAfter({MysqlProperties.class})
@EnableTransactionManagement
public class DatasourceConfig {
  @Resource
  private MysqlProperties jdbcProperties;

  /**
   * 主数据源.
   *
   * @return 主数据源实例
   * @throws SQLException SQLException
   */
  @Bean(name = "masterDs", initMethod = "init", destroyMethod = "close")
  @Primary
  public DruidDataSource masterDs() throws SQLException {
    DruidDataSource masterDs = new DruidDataSource();
    masterDs.setDriverClassName(jdbcProperties.getDriverClass());
    masterDs.setUrl(jdbcProperties.getWriteUrl());
    masterDs.setUsername(jdbcProperties.getWriteUsername());
    masterDs.setPassword(jdbcProperties.getWritePassword());

    masterDs.setFilters(jdbcProperties.getFilters());
    masterDs.setMaxActive(jdbcProperties.getMaxActive());
    masterDs.setInitialSize(jdbcProperties.getInitialSize());
    masterDs.setMaxWait(jdbcProperties.getMaxWait());
    masterDs.setMinIdle(jdbcProperties.getMinIdle());

    masterDs.setTimeBetweenEvictionRunsMillis(jdbcProperties.getTimeBetweenEvictionRunsMillis());
    masterDs.setMinEvictableIdleTimeMillis(jdbcProperties.getMinEvictableIdleTimeMillis());

    masterDs.setValidationQuery(jdbcProperties.getValidationQuery());
    masterDs.setTestWhileIdle(jdbcProperties.isTestWhileIdle());
    masterDs.setTestOnBorrow(jdbcProperties.isTestOnBorrow());
    masterDs.setTestOnReturn(jdbcProperties.isTestOnReturn());

    masterDs.setPoolPreparedStatements(jdbcProperties.isPoolPreparedStatements());
    masterDs.setMaxOpenPreparedStatements(jdbcProperties.getMaxOpenPreparedStatements());
    return masterDs;
  }

  /**
   * 从数据源.
   *
   * @return 从数据源实例
   * @throws SQLException SQLException
   */
  @Bean(name = "slaveDs", initMethod = "init", destroyMethod = "close")
  public DruidDataSource slaveDs() throws SQLException {
    DruidDataSource slaveDs = new DruidDataSource();
    slaveDs.setDriverClassName(jdbcProperties.getDriverClass());
    slaveDs.setUrl(jdbcProperties.getReadUrl());
    slaveDs.setUsername(jdbcProperties.getReadUsername());
    slaveDs.setPassword(jdbcProperties.getReadPassword());

    slaveDs.setFilters(jdbcProperties.getFilters());
    slaveDs.setMaxActive(jdbcProperties.getMaxActive());
    slaveDs.setInitialSize(jdbcProperties.getInitialSize());
    slaveDs.setMaxWait(jdbcProperties.getMaxWait());
    slaveDs.setMinIdle(jdbcProperties.getMinIdle());

    slaveDs.setTimeBetweenEvictionRunsMillis(jdbcProperties.getTimeBetweenEvictionRunsMillis());
    slaveDs.setMinEvictableIdleTimeMillis(jdbcProperties.getMinEvictableIdleTimeMillis());

    slaveDs.setValidationQuery(jdbcProperties.getValidationQuery());
    slaveDs.setTestWhileIdle(jdbcProperties.isTestWhileIdle());
    slaveDs.setTestOnBorrow(jdbcProperties.isTestOnBorrow());
    slaveDs.setTestOnReturn(jdbcProperties.isTestOnReturn());

    slaveDs.setPoolPreparedStatements(jdbcProperties.isPoolPreparedStatements());
    slaveDs.setMaxOpenPreparedStatements(jdbcProperties.getMaxOpenPreparedStatements());
    return slaveDs;
  }

  /**
   * 初始化事务数据源.
   *
   * @return 事务数据源实例
   * @throws SQLException SQLException
   */
  @Bean(name = "dataSource")
  public DataSource dataSource() throws SQLException {
    MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration();
    masterSlaveRuleConfig.setName("ds_master_slave");
    masterSlaveRuleConfig.setMasterDataSourceName("ds_master");
    masterSlaveRuleConfig.setSlaveDataSourceNames(Arrays.asList("ds_slave_0"));

    return
        MasterSlaveDataSourceFactory
            .createDataSource(createDataSourceMap(), masterSlaveRuleConfig, new ConcurrentHashMap<String, Object>());
  }

  private Map<String, DataSource> createDataSourceMap() throws SQLException {
    final Map<String, DataSource> result = new HashMap<>(2, 1);
    result.put("ds_master", masterDs());
    result.put("ds_slave_0", slaveDs());
    return result;
  }
}
