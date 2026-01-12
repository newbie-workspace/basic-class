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
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/account/login"})
public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/account/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 요청 데이터 읽기.
		// 2. 요청 처리.
		//  2.1. 로그인 가능 여부 확인 (여기서는 DB없이 특정 아이디, 패스워드와 비교)
		//  2.2. 로그인 성공, 실패에 따른 처리 - session 객체에 데이터 저장. session 객체는 jsp의 내장객체이므로, req 객체에서 가져와야 함.
		// 3. jsp에서 읽을 수 있도록 request 객체에 데이터 저장.
		// 4. home으로 보내거나 jsp로 forward 
		
//		String memberId = req.getParameter("memberId");
//		String passwd = req.getParameter("passwd");
//		boolean loginResult = true;
//		if(memberId.equals("iamuser") && passwd.equals("pass")) {
//			HttpSession session = req.getSession();
//			session.setAttribute("loginuser", memberId); // 여기서 attributes의 내용은 임의로 가능.
//		} else {
//			loginResult = false;
//		}
//		if(loginResult) {
//			resp.sendRedirect("/demoweb/home"); // 홈으로 이동. 다른 작업영역으로 이동할 때에는 redirect로 이동.
//		} else {
//			req.setAttribute("loginResult", "loginFail");
//			req.getRequestDispatcher("/WEB-INF/views/account/login.jsp").forward(req,resp);
//		}
		
		// Datebase 와 연동해서 작업.
		// MemberDao 객체 만들고 메서드 호출. selectMemberByIdAndPasswd (전달인자 : memberId, passwd, 반환값을 MemberDto 타입 변수에 저장)
		// 조건식을 이용해서 member 값이 null 인지 확인.
		
		boolean loginResult = true;
		MemberDao mDao = new MemberDao();
		String memberId = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");
		passwd = Util.getHashedString(passwd, "SHA-256");
		MemberDto member = mDao.checkMember(memberId, passwd);
		
		if(member != null) {
			
			HttpSession session = req.getSession();
			session.setAttribute("loginuser", member); // member 객체를 저장...
			
		} else {
			loginResult = false;
		}
		
		if(loginResult) {
			resp.sendRedirect("/demoweb/home"); // 홈으로 이동. 다른 작업영역으로 이동할 때에는 redirect로 이동.
		} else {
			req.setAttribute("loginResult", "loginFail");
			req.getRequestDispatcher("/WEB-INF/views/account/login.jsp").forward(req,resp);
		}
			
	}
	
}
