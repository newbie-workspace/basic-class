package com.demoweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.demoweb.dto.BoardDto;

@Component("boardDao") // @Component 로 등록하는 것은 <bean... 으로 servlet-context.xml 에 등록하는 것과 같음.
public class MySqlBoardDao implements BoardDao {
	
	@Override
	public void insertBoard(BoardDto board) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/labdb", "human", "human");
			String sql = "insert into tbl_board (writer, title, content) values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			pstmt.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (Exception ex) {}
			try {conn.close();} catch (Exception ex) {}
		}
	}
	
	@Override
	public ArrayList<BoardDto> showBoard() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardDto> list = new ArrayList<>();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/labdb", "human", "human");
			String sql = "select * from tbl_board order by boardno desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				BoardDto board = new BoardDto();
				board.setBoardNo(rs.getInt(1));
				board.setWriter(rs.getString(2));
				board.setTitle(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setWriteDate(rs.getDate(5));
				board.setModifyDate(rs.getDate(6));
				board.setReadCount(rs.getInt(7));
				board.setCategory(rs.getString(8));
				list.add(board);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (Exception ex) {}
			try {conn.close();} catch (Exception ex) {}
		}
		
		return list;
	}

	@Override
	public BoardDto selectBoardByBoardNo(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDto board = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/labdb", "human", "human");
			String sql = "select boardno, writer, title, content, writedate, modifydate, readcount from tbl_board where boardno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				board = new BoardDto();
				board.setBoardNo(rs.getInt(1));
				board.setWriter(rs.getString(2));
				board.setTitle(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setWriteDate(rs.getDate(5));
				board.setModifyDate(rs.getDate(6));
				board.setReadCount(rs.getInt(7));
				
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {rs.close();} catch (Exception ex) {}
			try {pstmt.close();} catch (Exception ex) {}
			try {conn.close();} catch (Exception ex) {}
		}
		
		return board;
		
	}

	@Override
	public void updateBoardReadCount(int boardNo) {
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/labdb", "human", "human");
			
			String sql = "update tbl_board set readcount = readcount + 1 where boardno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (Exception ex) {}
			try {conn.close();} catch (Exception ex) {}
		}
	}
}
