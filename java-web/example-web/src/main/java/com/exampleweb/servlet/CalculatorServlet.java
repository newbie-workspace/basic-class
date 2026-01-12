package com.exampleweb.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/calculate")
// @WebServlet (urlPatterns = {"/calculate"})
public class CalculatorServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Double operand1 = Double.parseDouble(req.getParameter("operand1"));
		Double operand2 = Double.parseDouble(req.getParameter("operand2"));
		String operator = req.getParameter("operator");
		
		double result = 0; 
		boolean valid = true;
		switch (operator) { 
		case "+":
			result = operand1 + operand2;
			break;
		case "-":
			result = operand1 - operand2;
			break;
		case "*":
			result = operand1 * operand2;
			break;
		case "/":
			result = (double) operand1 / operand2;
			break;
		case "%":
			result = operand1 % operand2;
			break;
		default:			
			valid = false;
		}
		
		req.setAttribute("operation", String.format("%f %s %f", operand1, operator, operand2));
		
		if (valid) {
			req.setAttribute("result",result);		
		} else {
			req.setAttribute("result","유효하지 않은 연산자");
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("06.calc-result.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("06.calculator.jsp").forward(req, resp);
	}
}
