package com.bs.firstboot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
	}
	
	@Bean
	LoggerInterceptor loggerInterceptor() {
		return new LoggerInterceptor();
	}
	
	@Bean
	Member member() {
		return new Member();
	}
	
	
}
