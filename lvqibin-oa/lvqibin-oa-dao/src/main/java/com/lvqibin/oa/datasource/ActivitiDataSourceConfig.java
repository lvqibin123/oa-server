package com.lvqibin.oa.datasource;

import org.activiti.spring.SpringAsyncExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/*
 * 该类是为 activiti 配置数据源 将 数据源指定 到 oa_sys 表空间中
 */
@Configuration
public class ActivitiDataSourceConfig extends AbstractProcessEngineAutoConfiguration {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.sys")
	public DataSource activitiDataSource() {
		return DataSourceBuilder.create().build();
	}

	// 其中 dataSource 框架会自动为我们注入
	@Bean
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(activitiDataSource());
	}

	@Bean
	public SpringProcessEngineConfiguration springProcessEngineConfiguration(
			PlatformTransactionManager transactionManager, SpringAsyncExecutor springAsyncExecutor) throws IOException {

		return baseSpringProcessEngineConfiguration(activitiDataSource(), transactionManager, springAsyncExecutor);
	}
}
