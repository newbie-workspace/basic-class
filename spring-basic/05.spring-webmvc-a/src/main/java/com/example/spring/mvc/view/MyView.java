package com.example.spring.mvc.view;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.View;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyView implements View{

	@Override
	public void render(@Nullable Map<String, ?> model, // model: Controller 에서 전달한 데이터가 담긴 전달인자. 
					   HttpServletRequest request, 
					   HttpServletResponse response)
			throws Exception {
		
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter(); // HTTP 응답을 쓸 수 있는 출력기
		out.println("This is Content from Custom View");
		out.println("Data from Controller");
		for (Object key : model.keySet()) {
			out.println(model.get(key));
		}
		out.println(new Date().toString());
		
	}
	
}
