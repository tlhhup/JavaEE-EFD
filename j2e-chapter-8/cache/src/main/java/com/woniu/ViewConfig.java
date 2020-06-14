package com.woniu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
//基础数据配置类
@Configuration
@EnableWebMvc
public class ViewConfig extends WebMvcConfigurerAdapter{
	@Bean
	public ViewResolver getView() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		//设置视图前、后缀
        resolver.setPrefix("/page");
        resolver.setSuffix(".jsp");
        return resolver;
	}
}
