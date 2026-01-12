package com.demoweb.servlet;

import java.io.IOException;

import com.demoweb.common.Util;
import com.demoweb.dao.MemberDao;
import com.demoweb.dto.MemberDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/account/register"})
public class Register extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/account/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청 데이터 : memberId, passwd, email
		// MemberDto 객체 만들기, 앞에서 읽은 데이터를 저장 (set 계열 메서드 사용)
		// MemberDao 객체 만들기. memberDao 의 insertMember 메서드 호출 (전달인자 MemberDto)
		// 로그인 서블릿으로 이동.
		MemberDto member = new MemberDto();
		MemberDao registerMember = new MemberDao();
		
		String memberId = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");
		passwd = Util.getHashedString(passwd, "SHA-256");
		String email = req.getParameter("email");
		
		member.setMemberId(memberId);
		member.setPasswd(passwd);
		member.setEmail(email);
		registerMember.insertMember(member);
		
		resp.sendRedirect("login");
	}
}
