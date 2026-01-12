package com.exampleweb.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener // web.xml 파일의 설정을 대신하는 annotation
public class ExampleWebListener implements ServletContextListener, HttpSessionListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) { // 웹 애플리케이션이 시작될 때 자동으로 호출.
		System.out.println("1. 웹 애플리케이션이 시작되었습니다.");
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("2. 세션이 시작되었습니다."); // 세션이 시작되었습니다. : 사용자가 브라우저를 열고 '처음'(첫 요청) 접속했을 때.
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("3. 세션이 종료되었습니다."); // 세션이 종료 : 특정 세션 기준 마지막 요청이 발생한 후 일정시간 동안 추가 요청이 없을 때. (기본 30분)
												  // 또는 session.invalidate();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("4. 웹 애플리케이션이 종료되었습니다."); // 웹 애플리케이션이 종료될 때 자동 호출.
	}

	

}
