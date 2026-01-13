package com.example.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring.mvc.dto.PersonDto;

@Controller // spring IoC container 에 등록되어 관리됨.
public class DemoController {
	
	// 1. HttpServletRequest 전달인자로 데이터 읽기.
//	@RequestMapping(path = {"/demo/param"})
//	public String processParam(HttpServletRequest req) {
//		String data1 = req.getParameter("data1");
//		Int data2 = req.getParameter("data2");
//		System.out.println("-------------> " + data1 + "/" + data2);
//		return "demo/result"; // prefix: "/WEB-INF/views/", suffix: ".jsp" ->servlet-context.xml 에 설정되어 있음.
//	}
	
	// 2. 전달인자를 통해 요청 데이터를 직접 수신.
	// @RequestMapping(path = {"/demo/param"}, method = RequestMethod.GET)
//	@GetMapping(path = {"/demo/param"}) // GET 요청에 대해서만 처리하는 메서드.
//	public String processParam(
//			@RequestParam(name = "data1")String data1, 
//			@RequestParam("data2")int data2 // name 생략 가능. 
//			) { 
//		System.out.println("-------------> " + data1 + "/" + data2);
//		return "demo/result"; // prefix: "/WEB-INF/views/", suffix: ".jsp" ->servlet-context.xml 에 설정되어 있음.
//	}
	
	// 3. View 로 데이터 전달 
	@GetMapping(path = {"/demo/param"}) // GET 요청에 대해서만 처리하는 메서드.
	public String processParam(
			@RequestParam(name = "data1")String data1, 
			@RequestParam("data2")int data2,
			Model model) { // Model 타입 전달인자는 View로 데이터를 전달하는 통로 
		System.out.println("-------------> " + data1 + "/" + data2);
		model.addAttribute("data1",data1); // Model 타입 전달인자에 데이터를 저장하면 View 로 전
		model.addAttribute("data2",data2); // 실제로는 request 객체에 저장됩니다.
		return "demo/result"; // prefix: "/WEB-INF/views/", suffix: ".jsp" ->servlet-context.xml 에 설정되어 있음.
	}
	
	// 4. DTO 전달인자 객체를 사용해서 요청 데이터 읽기.
	@PostMapping(path = {"/demo/param"}) // Post 요청에 대해서만 처리하는 메서드.
	public String processParam2(
			// PersonDto person
			@ModelAttribute("personUsingModelAttribute") PersonDto person, // @ModelAttribute: 읽는 것도 가능하고 View로 전달하는 기능도 포함.
			Model model) { // Model 타입 전달인자는 View 로 데이터를 전달하는 통로.
		System.out.println("-------------> " + person);
		model.addAttribute("person2", person);
		return "demo/result"; // prefix: "/WEB-INF/views/", suffix: ".jsp" ->servlet-context.xml 에 설정되어 있음.
	}

	// 5. redirect
	@GetMapping(path = {"/demo/redirect"})
	public String redirect() {
		System.out.println("---------> home 으로 redirect.");
		return "redirect:/home";
	}
	
	// 6. forward
	@GetMapping(path = {"/demo/forward"})
	public String forward() {
		System.out.println("------------> 으로 forward ");
		return "forward:/resources/forward-result.html"; 
		// .html, .png, .css 등의 코드의 실행이 필요 없는 것들은  Spring process 를 거치지 않으므로 그런 것들은
		// /resources/ 에 모아 놓는 것이 일반적. 
		// servlet-context.xml 에 resources mapping 에서 설정할 수 있음.
	}
	
}
