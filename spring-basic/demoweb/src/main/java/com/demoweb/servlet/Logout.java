package com.demoweb.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet (urlPatterns = {"/account/logout"})
public class Logout extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청 처리 (로그아웃)
		// jsp에서 읽을 수 있도록 request에 데이터 저장
		// jsp로 forward or 다른 servlet으로 redirect
		HttpSession session = req.getSession();
		session.removeAttribute("loginuser"); // 로그아웃 : session에서 해당 데이터 삭제
		session.invalidate(); // session 자체를 제거.
		resp.sendRedirect("login");
	}
}
