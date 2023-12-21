package com.bs.firstboot.config;

import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.bs.firstboot.common.LoggerInterceptor;
import com.bs.firstboot.model.dto.Member;

@Configuration //WebMvcConfigurer 인터페이스
@MapperScan("com.bs.firstboot.common.mapper")
public class WebMVCConfiguration implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//인터셉터 등록할 때 사용하는 메소드
		registry.addInterceptor(new LoggerInterceptor())
		.addPathPatterns("/**");
		
		
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//view 연결해주는 로직을 코드로 작성할 때 사용
		registry.addViewController("/board/boardList").setViewName("board/boardList");
		registry.addViewController("/chatpage").setViewName("chatting");
	}
	
	@Bean
	LoggerInterceptor loggerInterceptor() {
		return new LoggerInterceptor();
	}
	
	@Bean
	Member member() {
		return new Member();
	}
	
	@Bean
	@Primary
	HandlerExceptionResolver handelerExceptionResolver2() {
		Properties exceptionProp = new Properties();
		exceptionProp.setProperty(IllegalArgumentException.class.getName(), 
								"error/argumentsException");
		
		SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
		resolver.setExceptionMappings(exceptionProp);
		resolver.setDefaultErrorView("error/error");
		return resolver;
		
	}

	//외부에서 js로 요청한 것에 대한 허용하기
	//cors : 다른 서버에서 js로 요청한 내용을 차단함
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localhost:3000");
		//나랑 origin이 달라도 허용
		
		
	}
	
	
	
	
}
