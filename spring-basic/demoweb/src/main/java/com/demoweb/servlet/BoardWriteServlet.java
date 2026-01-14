package com.demoweb.servlet;

import java.io.IOException;

import com.demoweb.dao.BoardDao;
import com.demoweb.dto.BoardDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/board/write"})
public class BoardWriteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청 데이터 읽기. (title, writer, content)
		String writer = req.getParameter("writer");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		// BoardDto, BoardDao 만들고 insertBoard 메서드 만들기
		
		// 요청 처리. (위에서 읽은 데이터베이스에 데이터 저장)
		BoardDto board = new BoardDto();
		board.setWriter(writer);
		board.setTitle(title);
		board.setContent(content);
		
		BoardDao dao = new BoardDao();
		dao.insertBoard(board);
		
		// 목록으로 이동.
		resp.sendRedirect("list");
	}
}
