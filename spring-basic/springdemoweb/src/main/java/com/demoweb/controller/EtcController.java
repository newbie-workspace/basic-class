package com.demoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EtcController {
	
	@GetMapping(path = { "/admin/user", "/mail/list", "/library/list" }, produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String processRequest(HttpServletRequest req) {
		
		String uri = req.getRequestURI();
		
		return "현재 요청 : " + uri;
	}

}
