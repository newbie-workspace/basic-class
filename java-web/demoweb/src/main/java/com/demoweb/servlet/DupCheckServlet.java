package com.demoweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.demoweb.dao.MemberDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/account/dup-check"})
public class DupCheckServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 요청 데이터 읽기
		String memberId = req.getParameter("memberId");
		// 2. 요청 처리 (중복 여부 확인 -> 데이터베이스 조회)
		MemberDao dao = new MemberDao();
		int count = dao.selectMemberCountById(memberId);
		
		// 3. 결과 응답.
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		if (count > 0) {
			out.print("invalid");
		} else {
			out.print("valid");
		}
	}
}
