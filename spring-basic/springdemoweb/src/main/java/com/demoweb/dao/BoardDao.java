package com.demoweb.dao;

import java.util.ArrayList;

import com.demoweb.dto.BoardDto;

public interface BoardDao {

	void insertBoard(BoardDto board);

	ArrayList<BoardDto> showBoard();

	BoardDto selectBoardByBoardNo(int boardNo);

	void updateBoardReadCount(int boardNo);

}