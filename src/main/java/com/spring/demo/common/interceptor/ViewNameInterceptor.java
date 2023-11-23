package com.spring.demo.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ViewNameInterceptor extends HandlerInterceptorAdapter {
	
	//1.preHandle()- 컨트롤러가 호출되기 전에 실행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 String viewName = getViewName(request);
		 request.setAttribute("viewName", viewName);
		return true;//true- preHandle()가 true가 리턴이 되면,Controller로 보내고
		//false- controller로 보내지 않는다.(빈 화면)
	}
	//2.postHandle()-컨트롤러가 실행된후에 호출
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	//3.afterCompletion()-뷰에서 최종 결과가 생성하는 일을 포함해서 모든일이 완료 되었을때 실행
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
	
	//요청명에서 뷰이름을 반환 : /member/listMembers
	private String getViewName(HttpServletRequest request) {
		//URL http://localhost:8090/member/listMembers.do
		String contextPath = request.getContextPath();//http://localhost:8090
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		//request.getRequestURI(): /member/listMembers.do?abc=123&
		if(uri== null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		int begin = 0;
		if(!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}
		int end = 0;
		if(uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		}else if(uri.indexOf("?") != -1) {
			end=uri.indexOf("?");
		}else {
			end =uri.length();
		}
		//abc.jsp
		String fileName = uri.substring(begin,end);
		if(fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}
		if(fileName.indexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/",1),fileName.length());
		}
		return fileName;
	}
}





