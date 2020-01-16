package com.lvqibin.oa;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// 此处排查activiti 的登录权限验证
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan(basePackages = {
		"com.lvqibin.oa.datasource",
		"com.lvqibin.oa.mybatisPlus",
		"com.lvqibin.oa.app.controller",
		"com.lvqibin.oa.sys.controller",
		"com.lvqibin.oa.app.service",
		"com.lvqibin.oa.sys.service",
		"com.lvqibin.oa.config",
		"com.lvqibin.oa.common"
})
public class OaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OaApplication.class, args);
	}

}
