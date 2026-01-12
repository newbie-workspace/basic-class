package com.exampleweb.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//HttpServlet을 상속 -> Servlet의 규격을 따르는 클래스로 만듬.
@WebServlet(urlPatterns = "/get-greetings2") // web.xml 파일에 서블릿 등록 & 매핑 대신 처리
public class HelloServletWithAnnotation extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Hello Servlet Programming World 2 ##</h2>");
		out.println("<h2 style='color:red'>"+ new Date() +"</h2>");
		out.println("</body>");
		out.println("</html>");
	}
}
