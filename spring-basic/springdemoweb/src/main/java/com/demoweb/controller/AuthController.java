package com.demoweb.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demoweb.common.Util;
import com.demoweb.dao.BoardDao;
import com.demoweb.dao.MemberDao;
import com.demoweb.dto.BoardDto;
import com.demoweb.dto.MemberDto;

import jakarta.servlet.http.HttpSession;


@Controller
public class AuthController {
	
	@GetMapping(path = {"/account/login"})
	public String loginView()	{
		return "account/login";
	}
	
	@PostMapping(path = {"/account/login"})
	public String login(
				@RequestParam("memberId") String memberId,
				@RequestParam("passwd") String passwd,
				HttpSession session,
				Model model // Model 타입의 전달인자는 View로 데이터를 전달하는 통로
		   ) {

		boolean loginResult = true;
		passwd = Util.getHashedString(passwd, "SHA-256");
		MemberDao mDao = new MemberDao();
		MemberDto member = mDao.checkMember(memberId, passwd);

		if(member != null) {
			
			session.setAttribute("loginuser", member); // member 객체를 저장...
		} else {
			
			loginResult = false;
		}
		
		if(loginResult) {
			
			return "redirect:/home";
		} else {
		
			model.addAttribute("loginResult", "loginFail"); // view 에서 읽을 수 있도록 Model 타입 객체에 저장.
			return "account/login"; // View 로 이동.
		}
	}
	
	@GetMapping(path = {"/account/logout"})
	public String logoutView(HttpSession session) {
		
		// 세션이 끝나야지.
		session.removeAttribute("loginuser");
		// session.invalidate(); // 세션 전부 삭제
		// return "redirect:/account/login"; // 그냥 리턴하면 주소 안 바뀜.
		return "redirect:login"; // 상대 경로.
	}
	
	@GetMapping(path = {"/account/register"})
	public String registerView() {
		
		return "account/register";
	}
	
	@PostMapping(path = {"/account/register"})
	public String register(
//				@RequestParam("memberId") String memberId,
//				@RequestParam("passwd") String passwd,
//				@RequestParam("email") String email
				MemberDto newMember
			) {
		
		MemberDao registerMember = new MemberDao();
		String hashedPasswd = Util.getHashedString(newMember.getPasswd(), "SHA-256");
		newMember.setPasswd(hashedPasswd);
		registerMember.insertMember(newMember);
		//return "redirect:/account/login"; // 절대 경로
		return "redirect:login"; // 상대 경로
	}
	
	// 아이디 중복 검사
	@GetMapping(path = {"/account/dup-check"}, produces = {"text/plain;charset=utf-8"})
	@ResponseBody
	public String dupCheck(
			@RequestParam("memberId") String memberId
			) {
		
		MemberDao dao = new MemberDao();
		int count = dao.selectMemberCountById(memberId);
		if (count > 0) {
			return "invalid";
		} else {
			return "valid";
		}
	}
	
	@GetMapping(path = {"/board/list"})
	public String boardView(Model model) {
		
		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> list = dao.showBoard();
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@GetMapping(path = {"/board/write"})
	public String boardWriteView() {
		
		return "board/write";
	}
	
	@PostMapping(path = {"/board/write"})
	public String boardWrite(BoardDto newBoard) {
		
		BoardDao dao = new BoardDao();
		dao.insertBoard(newBoard);
		return "redirect:list";
	}
	
}
