package com.demoweb.servlet;

import java.io.IOException;

import com.demoweb.dto.MemberDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/library/list"})
public class LibraryListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// AuthFilter에서 일괄 관리하도록 구현해서 개별 서블릿에서 제거
//		MemberDto member = (MemberDto) req.getSession().getAttribute("loginuser");
//		if (member == null) { // 로그인하지 않은 사용자
//			resp.sendRedirect("/demoweb/account/login");
//			return;
//		}
	}
}
