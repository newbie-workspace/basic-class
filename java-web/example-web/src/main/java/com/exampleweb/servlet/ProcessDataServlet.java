package com.exampleweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns = {"/process-data"})
public class ProcessDataServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청 데이터 읽기
		String name = req.getParameter("name"); // <input ... name = 'name'> 입력 데이터 읽기
		String email = req.getParameter("email"); // <input ... name = 'email'> 입력 데이터 읽기
		System.out.printf("[%s] : [%s]\n", name, email);
		// 응답
		resp.setContentType("text/html;charset=utf-8"); // 응답 컨텐츠 종류 및 한글 지원 설정.
		PrintWriter out = resp.getWriter(); // 네트워크에 출력하는 스트림 도구.
		out.println("<html>");
		out.println("<head>");
		out.println("<title>데이터 처리 결과</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Post 방식 데이터 처리 완료</h2>");
		out.printf("<h2 style='color:blue'>[%s]</h2>", name);
		out.printf("<h2 style='color:blue'>[%s]</h2>", email);
		out.println("</body>");
		out.println("</html>"); // Servlet으로 html 작성은 매우 성가심.
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청 데이터 읽기
		String name = req.getParameter("name"); // <input ... name = 'name'> 입력 데이터 읽기
		String email = req.getParameter("email"); // <input ... name = 'email'> 입력 데이터 읽기
		System.out.printf("[%s] : [%s]\n", name, email);
		// 응답 
		resp.setContentType("text/html;charset=utf-8"); // 응답 컨텐츠 종류 및 한글 지원 설정.
		PrintWriter out = resp.getWriter(); // 네트워크에 출력하는 스트림 도구.
		out.println("<html>");
		out.println("<head>");
		out.println("<title>데이터 처리 결과</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Get 방식 데이터 처리 완료</h2>");
		out.printf("<h2 style='color:blue'>[%s]</h2>", name);
		out.printf("<h2 style='color:blue'>[%s]</h2>", email);
		out.println("</body>");
		out.println("</html>"); // Servlet으로 html 작성은 매우 성가심.
	}
}
