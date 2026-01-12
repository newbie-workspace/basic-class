package com.exampleweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet { // HttpServlet을 상속 -> Servlet의 규격을 따르는 클래스로 만듬.
	private static final long serialVersionUID = 1L;
	@Override // doGet : 요청 처리를 위해 Container가 호출하는 약속된 메서드
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<h2>Hello Servlet Programming World ##</h2>");
		out.println("<h2>"+ new Date() +"</h2>");
	}
}
