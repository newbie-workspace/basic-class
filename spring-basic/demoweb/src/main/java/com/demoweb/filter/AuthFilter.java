package com.demoweb.filter;

import java.io.IOException;

import com.demoweb.dto.MemberDto;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/*"})
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		
		String uri = req.getRequestURI();
		
		if (uri.contains("/admin") || 
			uri.contains("/mail") || 
			uri.contains("/library") || 
			uri.contains("/board/write")) {
			
			MemberDto member = (MemberDto) req.getSession().getAttribute("loginuser");
			
			if (member == null) { // 로그인하지 않은 사용자
				resp.sendRedirect("/demoweb/account/login");
				return;
			}
			if (uri.contains("/admin") && !member.getUserType().equals("admin")) {
				resp.sendRedirect("/demoweb/account/login");
				return;
			}
		}
		
		chain.doFilter(arg0, arg1);
	}
}
