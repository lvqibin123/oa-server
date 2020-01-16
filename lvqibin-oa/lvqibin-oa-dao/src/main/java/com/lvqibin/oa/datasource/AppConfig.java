package com.lvqibin.oa.datasource;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;

@Configuration
public class AppConfig {

    @Bean
    @Qualifier("dataSourceAppConfigProperties")
    @ConfigurationProperties(prefix = "mybatis-plus.app")
    public MybatisPlusProperties dataSourceAppConfigProperties() {
        return new MybatisPlusProperties();
    }

    @Bean
    @Qualifier("dataSourceSysConfigProperties")
    @ConfigurationProperties(prefix = "mybatis-plus.sys")
    public MybatisPlusProperties dataSourceSysConfigProperties() {
        return new MybatisPlusProperties();
    }
    
    /**
    *
    * 当要更新一条记录的时候，希望这条记录没有被别人更新
    *
    * 乐观锁 插件
    * @return
    */
   @Bean
   public OptimisticLockerInterceptor optimisticLoker() {
       return new OptimisticLockerInterceptor();
   }
}
