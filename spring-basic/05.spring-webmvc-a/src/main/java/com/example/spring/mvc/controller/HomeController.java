package com.example.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // WebApplicatonContext에 등록, @Component와 비슷한 역활 + 웹 기능 추가.
public class HomeController {
	
	@RequestMapping(path = {"/", "home"}) //@WebServlet과 비슷한 역활.
	public String home() {
		return "home";	// home: "/WEB-INF/views/" + "home" + ".jsp" 로 해석
	}
	
}
