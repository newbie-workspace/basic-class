package com.demoweb.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

// @WebListener
public class DemoWebListener implements ServletContextListener, HttpSessionListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("1. 웹 애플리케이션이 시작되었습니다.");
		
		// 1. application 객체 준비
		ServletContext application = sce.getServletContext();
		// 3. application 객체에 저장된 접속자 카운트 데이터 수정
		application.setAttribute("total", 0); // 누적 접속자수 
		application.setAttribute("current", 0); // 현재 접속자수
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("2. 세션이 시작되었습니다.");
		
		HttpSession session = se.getSession(); 
		// session.setMaxInactiveInterval(30); // default: 30분 동
		
		// 1. application 객체 준비
		ServletContext application = se.getSession().getServletContext();
		// 2. application 객체에 데이터 저장된 접속자 카운트 데이터 읽기
		int total = (int)application.getAttribute("total");
		int current = (int)application.getAttribute("current");
		// 3. application 객체에 저장된 접속자 카운트 데이터 수정
		application.setAttribute("total", total + 1); // 누적 접속자수 
		application.setAttribute("current", current + 1); // 현재 접속자수
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("3. 세션이 종료되었습니다.");
		
		// 1. application 객체 준비
		ServletContext application = se.getSession().getServletContext();
		// 2. application 객체에 데이터 저장된 접속자 카운트 데이터 읽기
		int current = (int)application.getAttribute("current");
		// 3. application 객체에 저장된 접속자 카운트 데이터 수정
		application.setAttribute("current", current - 1); // 현재 접속자수
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("4. 웹 애플리케이션이 종료되었습니다.");
	}
	
}
