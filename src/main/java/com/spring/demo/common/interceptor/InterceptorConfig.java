package com.spring.demo.common.interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//Interceptor -컨트롤러에 들어오는 요청,응답을 가로채는 역할
//           - 관리자 페이지 접근하기 전에 인증 용도
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(
				new ViewNameInterceptor())
		       .addPathPatterns("/*.do")
		       .addPathPatterns("/*/*.do")
		       //Intercepter 제외
		       .excludePathPatterns("/users/login");
	}
}
