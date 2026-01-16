package com.demoweb.dao;

import java.util.ArrayList;

import com.demoweb.dto.BoardDto;

public interface BoardDao {

	void insertBoard(BoardDto board);

	ArrayList<BoardDto> showBoard();
	ArrayList<BoardDto> showBoardByPage(int start, int count);

	BoardDto selectBoardByBoardNo(int boardNo);

	void updateBoardReadCount(int boardNo);

	void deleteBoardByNo(int boardNo);

	int selectBoardCount();

}