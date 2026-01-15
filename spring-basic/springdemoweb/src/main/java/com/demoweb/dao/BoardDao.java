package com.demoweb.dao;

import java.util.ArrayList;

import com.demoweb.dto.BoardDto;

public interface BoardDao {

	void insertBoard(BoardDto board);

	ArrayList<BoardDto> showBoard();

}