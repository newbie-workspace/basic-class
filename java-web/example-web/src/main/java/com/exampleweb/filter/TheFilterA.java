package com.exampleweb.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Filter : 요청 제어 or 여러 개의 요청에 대히 공통된 사항 적용
@WebFilter(urlPatterns = {"*.jsp"}) // 확장자가 jsp인 모든 경우. 필터들의 순서는 web.xml 설정을 통해서만 가능. 
public class TheFilterA implements Filter{ // import jakarta.servlet.Filter
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("-------> Filter A");
		
		// ServletRequest 는 HttpServletRequest의 상위 - > 형변환 
		HttpServletRequest hreq = (HttpServletRequest)req;
		String uri = hreq.getRequestURI(); // 현재 요청의 경로 조회
		
		// if (uri.contains("hello")) {
		if (uri.contains("03") || uri.contains("07")) {
			HttpServletResponse hresp = (HttpServletResponse)resp;
			hresp.sendRedirect("index.html");
			return;
		}
		chain.doFilter(req, resp); // 다음 체인 또는 servlet(jsp) 등으로 요청 전달.
		
	}
	
}
