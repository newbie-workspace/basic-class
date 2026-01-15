package com.demoweb.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.demoweb.dao.BoardDao;
import com.demoweb.dto.BoardDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	// MySqlBoardDao 객체를 IoC 컨테이너에 등록.
	// BoardDao boardDao = new MySqlBoardDao();
	// @Autowired // 의존 객체 자동 주입. -> 변수에 바로 @Autowired 를 쓰는 것은 권장하지 않음.
	// @Qualifier("boardDao") // @Component 로 등록한 이름과 동일해야 함. 
	// private BoardDao boardDao;
	// 권장 방법.
	private BoardDao boardDao;
	public BoardController(BoardDao boardDao) { // 생성자의 전달인자는 자동으로 의존 객체 주입.
		this.boardDao = boardDao;
	}

	@GetMapping(path = {"/board/list"})
	public String boardView( Model model) { // Model 타입 전달인자는 View 로 데이터를 전달하는 도구.
		ArrayList<BoardDto> list = boardDao.showBoard();
		
		
		
		
		model.addAttribute("list", list); // 실제로는 request 객체에 저장.
		return "board/list";
	}
	
	@GetMapping(path = {"/board/write"})
	public String boardWriteView() {
		return "board/write";
	}
	
	@PostMapping(path = {"/board/write"})
	public String boardWrite(BoardDto newBoard, HttpSession session) {
		boardDao.insertBoard(newBoard);
		
		return "redirect:list";
	}
	
}
