package com.spring.demo.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ViewNameInterceptor extends HandlerInterceptorAdapter {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 String viewName = getViewName(request);
		  System.out.println("ViewName (Interceptor): " + viewName);
		 request.setAttribute("viewName", viewName);
		return true; //preHandle() true return: Controller 보냄
					 //			   false return: Controller 보내지 않음(빈화면)
	}
	
	//postHandle: 실행 후 호출
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
	
	
	private String getViewName(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		System.out.println("contextPath는? " + contextPath );
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if(uri== null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		int begin = contextPath.length();
		int end = uri.length();
		if(!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}
		
		if(uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
			System.out.println("end(;) " + end);
		}else if(uri.indexOf("?") != -1) {
			end=uri.indexOf("?");
		}else {
			end =uri.length();
		}
	
		String fileName = uri.substring(begin,end);
		System.out.println("fileName? " + fileName);// /main.do
		if(fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
			System.out.println("fileName(.): " + fileName); // main
		}
		if(fileName.indexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/",1),fileName.length());
		}
		System.out.println("fileName Return: " + fileName);
		return fileName;
	}
}





