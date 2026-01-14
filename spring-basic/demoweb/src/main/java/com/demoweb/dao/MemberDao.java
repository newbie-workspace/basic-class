package com.demoweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demoweb.dto.MemberDto;

public class MemberDao {
	
	// insertMember 메서드 구현
	// 전달인자 : MemberDto
	// 반환형 : void
	// 구현 내용 : tbl_member 테이블에 데이터 저장 (LottoDao의 insertLotto 메서드 참고)
	
	public void insertMember(MemberDto member) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/labdb", "human", "human");
			String sql = "insert into tbl_member (memberid, passwd, email) values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getEmail());
			pstmt.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (Exception ex) {}
			try {conn.close();} catch (Exception ex) {}
		}
	}
	
	// selectMemberByIdAndPasswd 메서드 만들기
	// 전달인자 memberId, passwd
	// 결과형 MemberDto
	// tbl_member 테이블에서 데이터 조회
	public MemberDto checkMember(String memberId, String passwd) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		MemberDto member = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/labdb", "human", "human");
			String sql = "select * from tbl_member where memberid = ? and passwd = ?";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, memberId);
			statement.setString(2, passwd);
			rs=statement.executeQuery();
			
			if(rs.next()) {
				member = new MemberDto();
				member.setMemberId(rs.getString(1));
				member.setEmail(rs.getString(3));
				member.setUserType(rs.getString(4));
				member.setJoinDate(rs.getDate(5));
				member.setActive(rs.getBoolean(6));
				member.setUserGrade(rs.getInt(7));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {statement.close();} catch (Exception ex) {}
			try {connection.close();} catch (Exception ex) {}
		}
		return member;
	}

	public int selectMemberCountById(String memberId) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/labdb", "human", "human");
			String sql = "select count(*) from tbl_member where memberid = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, memberId);
			rs=statement.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
						
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {statement.close();} catch (Exception ex) {}
			try {connection.close();} catch (Exception ex) {}
		}

		return count;
		
	}
}
