package com.demoweb.servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.demoweb.dao.BoardDao;
import com.demoweb.dto.BoardDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/board/list"})
public class BoardListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> list = dao.showBoard();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);

		
		
		
		
	}
}
