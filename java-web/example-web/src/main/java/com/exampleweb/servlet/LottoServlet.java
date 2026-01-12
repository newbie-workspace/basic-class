package com.exampleweb.servlet;
import java.io.IOException;

import com.exampleweb.dao.LottoDao;
import com.exampleweb.dto.LottoDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/lotto-winning-numbers"})
public class LottoServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청 데이터 읽기, 요청 처리, request 객체에 저장, jsp로 forward || 다른 servlet 으로 redirect (작업 영영 변경 또는 반복 안되도록)
		String sRound = req.getParameter("round");
		int round = Integer.parseInt(sRound);
		
		LottoDao dao = new LottoDao();
		LottoDto lotto = dao.selectLottoByRnd(round);
		
		req.setAttribute("lotto", lotto);
		
		req.getRequestDispatcher("16.lotto.jsp").forward(req, resp);
	}
}
