package com.lvqibin.oa.datasource;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;

import java.util.List;

import javax.sql.DataSource;

/**
 * Created by summer on 2016/11/25.
 */
@Configuration
@MapperScan(basePackages = {"com.lvqibin.oa.sys.dao"}, sqlSessionTemplateRef  = "sysSqlSessionTemplate")
public class DataSourceSysConfig extends MybatisPlusAutoConfiguration {

    public DataSourceSysConfig(@Qualifier("dataSourceSysConfigProperties")MybatisPlusProperties properties, ObjectProvider<Interceptor[]> interceptorsProvider,
			ObjectProvider<TypeHandler[]> typeHandlersProvider,
			ObjectProvider<LanguageDriver[]> languageDriversProvider, ResourceLoader resourceLoader,
			ObjectProvider<DatabaseIdProvider> databaseIdProvider,
			ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider,
			ObjectProvider<List<MybatisPlusPropertiesCustomizer>> mybatisPlusPropertiesCustomizerProvider,
			ApplicationContext applicationContext) {
		super(properties, interceptorsProvider, typeHandlersProvider, languageDriversProvider, resourceLoader,
				databaseIdProvider, configurationCustomizersProvider, mybatisPlusPropertiesCustomizerProvider,
				applicationContext);
		// TODO Auto-generated constructor stub
	}

	/*
	 * @Bean(name = "sysSqlSessionFactory") public SqlSessionFactory
	 * testSqlSessionFactory(@Qualifier("sysDataSource") DataSource dataSource)
	 * throws Exception { SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
	 * bean.setDataSource(dataSource); bean.setMapperLocations(new
	 * PathMatchingResourcePatternResolver().getResources(
	 * "classpath:mapper/sys/*.xml")); return bean.getObject(); }
	 * 
	 * @Bean(name = "sysTransactionManager") public DataSourceTransactionManager
	 * testTransactionManager(@Qualifier("sysDataSource") DataSource dataSource) {
	 * return new DataSourceTransactionManager(dataSource); }
	 * 
	 * @Bean(name = "sysSqlSessionTemplate") public SqlSessionTemplate
	 * testSqlSessionTemplate(@Qualifier("sysSqlSessionFactory") SqlSessionFactory
	 * sqlSessionFactory) throws Exception { return new
	 * SqlSessionTemplate(sqlSessionFactory); }
	 */
	
    @Bean("sysSqlSessionFactory")
    @Override
    public SqlSessionFactory sqlSessionFactory(@Qualifier("sysDataSource") DataSource dataSource) throws Exception {
        return super.sqlSessionFactory(dataSource);
    }

    @Bean("sysSqlSessionTemplate")
    @Override
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sysSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return super.sqlSessionTemplate(sqlSessionFactory);
    }

}
