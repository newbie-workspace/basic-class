package com.demoweb.interceptor;
import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.demoweb.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {

	// Controller 의 메서드 호출하기 전에 실행.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// System.out.println("-----------> preHandle()");
		
		String uri = request.getRequestURI();
		uri = uri.replace("/springdemoweb", "");
		if (uri.contains("/admin") || 
			uri.contains("/mail") || 
			uri.contains("/library") || 
			uri.contains("/board/write")) {
			
			MemberDto member = (MemberDto) request.getSession().getAttribute("loginuser");
			
			if (member == null) { // 로그인하지 않은 사용자
				response.sendRedirect("/springdemoweb/account/login?returnUrl=" + uri);
				return false; // 요청 처리 중단.
			}
			if (uri.contains("/admin") && !member.getUserType().equals("admin")) {
				response.sendRedirect("/springdemoweb/account/login?returnUrl=" + uri);
				return false; // 요청 처리 중단.
			}
		}
		
		return true;
	}

	// Controller 의 메서드 호출한 후에 실행.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		// System.out.println("-----------> postHandle()");
	}

	// 요청 처리 프로세스가 안료된 후 실행. (view 처리가 완료된 후.)
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		// System.out.println("-----------> afterCompletion()");
	}
	
}
