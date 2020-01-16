package com.lvqibin.oa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebLoginConfigurer implements WebMvcConfigurer {
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//其他静态资源，与本文关系不大
     // registry.addResourceHandler("/upload/**").addResourceLocations("file:"+ TaleUtils.getUplodFilePath()+"upload/");

      //需要配置1：----------- 需要告知系统，这是要被当成静态文件的！
      //第一个方法设置访问路径前缀，第二个方法设置资源路径
      registry.addResourceHandler("/angular/**").addResourceLocations("classpath:/angular/");
	  }
	

	// 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/angular/**");;
	}

	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
				.maxAge(3600).allowCredentials(true);
	}

	// 解决跨域
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration conf = new CorsConfiguration();
		conf.addAllowedHeader("*");
		conf.addAllowedMethod("*");
		conf.addAllowedOrigin("*");
		// 允许cookie
		conf.setAllowCredentials(true);
		conf.setMaxAge(3600L);
		conf.addExposedHeader("set-cookie");
		conf.addExposedHeader("access-control-allow-headers");
		conf.addExposedHeader("access-control-allow-methods");
		conf.addExposedHeader("access-control-allow-origin");
		conf.addExposedHeader("access-control-max-age");
		conf.addExposedHeader("X-Frame-Options");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", conf); // 4 对接口配置跨域设置
		return new CorsFilter(source);
	}
}
